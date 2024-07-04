package com.example.WalletLedgerSystem.repository;

import com.example.WalletLedgerSystem.dao.rdms.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserInterface extends JpaRepository<User, Integer> {
    List<User> findByStateCode(String stateCode);
}
