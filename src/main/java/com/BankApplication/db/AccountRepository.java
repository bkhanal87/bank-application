package com.BankApplication.db;

import com.BankApplication.model.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
// extending JpaRepository and passing entity and primary key type
public interface AccountRepository extends JpaRepository<Account, Integer> {

}


