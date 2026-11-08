package com.BankApplication.db;

import com.BankApplication.model.Transfer;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;

@Repository
public interface TransferRepository extends JpaRepository<Transfer, Integer> {

}
