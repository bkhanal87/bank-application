package com.BankApplication.controller;

import com.BankApplication.model.Transfer;
import com.BankApplication.service.TransferService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/transfers")
@CrossOrigin(origins = "http://localhost:4200")
public class TransferController {

    @Autowired
    private TransferService transferService;

    //Get all transfers
    @GetMapping
    public List<Transfer> getAllTransfers() {

        return transferService.getAllTransfers();
    }

    // Get transfer by ID
    @GetMapping("/{id}")
    public Transfer getTransferById(@PathVariable Integer id) {

        return transferService.getTransferById(id);
    }

    // Create a Transfer Record
    @PostMapping
    public Transfer createTransfer(@RequestBody Transfer transfer) {

        return transferService.createTransfer(transfer);
    }

    // update a transfer record
    @PutMapping("/{id}")
    public Transfer updateTransfer(
            @PathVariable Integer id,
            @RequestBody Transfer transfer) {
        return transferService.updateTransfer(id, transfer);
    }

    // Delete a transfer record
    @DeleteMapping("/{id}")
    public String deleteTransfer(@PathVariable Integer id) {
        transferService.deleteTransfer(id);
        return "Transfer successfully deleted!";
    }


}
