package com.BankApplication.service;

import com.BankApplication.db.AccountRepository;
import com.BankApplication.db.TransactionRepository;
import com.BankApplication.model.Account;
import com.BankApplication.model.Transfer;
import com.BankApplication.model.Transaction;
import org.springframework.transaction.annotation.Transactional;
import com.BankApplication.db.TransferRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.time.LocalDateTime;

@Service
public class TransferServiceImpl implements TransferService{

    // Inject TransferRepository here
    @Autowired
    private TransferRepository transferRepository;

    @Autowired
    private AccountRepository accountRepository;

    @Autowired
    private TransactionRepository transactionRepository;

    // create a transfer record
   @Override
    @Transactional
    public Transfer createTransfer(Transfer transfer) {

        if (transfer.getFromAccountId() == null ||
                transfer.getToAccountId() == null) {
            throw new RuntimeException("Both account IDs are required");
        }

        if (transfer.getFromAccountId().equals(transfer.getToAccountId())) {
            throw new RuntimeException("Cannot transfer to the same account");
        }

        if (transfer.getAmount() <= 0) {
            throw new RuntimeException("Transfer amount must be greater than zero");
        }

        Account fromAccount = accountRepository.findById(
                        transfer.getFromAccountId())
                .orElseThrow(() -> new RuntimeException("Sending account not found"));

        Account toAccount = accountRepository.findById(
                        transfer.getToAccountId())
                .orElseThrow(() -> new RuntimeException("Receiving account not found"));

        if (fromAccount.getBalance() < transfer.getAmount()) {
            throw new RuntimeException("Insufficient funds");
        }

        // Update account balances
        fromAccount.setBalance(fromAccount.getBalance() - transfer.getAmount());
        toAccount.setBalance(toAccount.getBalance() + transfer.getAmount());

        accountRepository.save(fromAccount);
        accountRepository.save(toAccount);

        // Set transfer date
        LocalDateTime now = LocalDateTime.now();
        transfer.setDate(now);

        // Save transfer record
        Transfer savedTransfer = transferRepository.save(transfer);

        // Create transaction for sending account
        Transaction outgoingTransaction = new Transaction();
        outgoingTransaction.setAccountId(fromAccount.getId());
        outgoingTransaction.setType("TRANSFER_OUT");
        outgoingTransaction.setAmount(-transfer.getAmount());
        outgoingTransaction.setDescription(
                "Transfer to account " + toAccount.getAccountNumber());
        outgoingTransaction.setDate(now);

        transactionRepository.save(outgoingTransaction);

        // Create transaction for receiving account
        Transaction incomingTransaction = new Transaction();
        incomingTransaction.setAccountId(toAccount.getId());
        incomingTransaction.setType("TRANSFER_IN");
        incomingTransaction.setAmount(transfer.getAmount());
        incomingTransaction.setDescription(
                "Transfer from account " + fromAccount.getAccountNumber());
        incomingTransaction.setDate(now);

        transactionRepository.save(incomingTransaction);

        return savedTransfer;
    }

    // Fetch all transfer records
    @Override
    public List<Transfer> getAllTransfers() {

        return transferRepository.findAll();
    }

    // Fetch a transfer record by id
    public Transfer getTransferById(Integer id) {
        return transferRepository.findById(id).orElseThrow(() -> new RuntimeException(
                "Transfer not found with id:" + id
        ));
    }

    // delete a transfer record by id
    @Override
    public void deleteTransfer(Integer id) {
        Transfer transferDB = transferRepository.findById(id)
                .orElseThrow(() -> new RuntimeException(
                        "Transfer not found with id: " + id
                ));
        transferRepository.delete(transferDB);
    }

    // update a transfer record by id
    @Override
    public Transfer updateTransfer(Integer id, Transfer transfer) {

        Transfer transferDB = transferRepository.findById(id)
                .orElseThrow(() -> new RuntimeException(
                        "Transfer not found with id: " + id
                ));
        transferDB.setFromAccountId(transfer.getFromAccountId());
        transferDB.setToAccountId(transfer.getToAccountId());
        transferDB.setAmount(transfer.getAmount());
        transferDB.setDescription(transfer.getDescription());
        transferDB.setDate(transfer.getDate());

        return transferRepository.save(transferDB);
    }
}
