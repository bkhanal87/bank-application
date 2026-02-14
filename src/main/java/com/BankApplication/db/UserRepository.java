package com.BankApplication.db;

import com.BankApplication.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
//import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
// extending JpaRepository and passing entity and primary key type
public interface UserRepository extends JpaRepository<User, Integer> {
}
