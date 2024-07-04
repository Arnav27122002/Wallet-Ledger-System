package com.example.WalletLedgerSystem.repository;

import com.example.WalletLedgerSystem.dao.rdms.Wallet;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

@Repository
public interface WalletInterface extends JpaRepository<Wallet, Integer> {
}
