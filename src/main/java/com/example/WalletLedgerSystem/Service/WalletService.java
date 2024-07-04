package com.example.WalletLedgerSystem.Service;

import com.example.WalletLedgerSystem.dao.rdms.Wallet;
import com.example.WalletLedgerSystem.repository.WalletInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class WalletService {
    @Autowired
    WalletInterface walletinterface;

    public Wallet loadWallet(Wallet wallet)
    {
        Wallet loadedWallet= walletinterface.save(wallet);
        return loadedWallet;
    }

}
