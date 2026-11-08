package com.BankApplication.service;

import com.BankApplication.model.Transfer;

import java.util.List;

public interface TransferService {
    List<Transfer> getAllTransfers();

    Transfer getTransferById(Integer id);

    Transfer createTransfer(Transfer transfer);

    Transfer updateTransfer(Integer id, Transfer transfer);

    void deleteTransfer(Integer id);

}
