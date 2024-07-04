
package com.example.WalletLedgerSystem.dao.rdms;
import com.example.WalletLedgerSystem.dao.rdms.User;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import jakarta.persistence.*;

import java.util.Date;
import java.util.UUID;


@Getter
@Setter
@Entity
public class Wallet {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String isSubWallet;
    private String walletId;
    private String walletName;
    private Date date;

    @PrePersist
    public void generate() {
        this.walletId = generateWalletId();
    }

    private String generateWalletId() {
        String random = UUID.randomUUID().toString().replace("-", "").substring(0, 10);
        return "wal"+random;
    }

    public Wallet() {
    }

    public Wallet(int id, String isSubWallet, String walletId, String walletName, Date date) {
        this.id = id;
        this.isSubWallet= isSubWallet;
        this.walletId= walletId;
        this.walletName= walletName;
        this.date= date;
    }

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;


    @Override
    public String toString() {
        return "Wallet{" +
                "id=" + id +
                ", isSubWallet='" + isSubWallet + '\'' +
                ", walletId=" + walletId +
                ", walletName='" + walletName + '\'' +
                ", date=" + date +
                ", user=" + user +
                '}';
    }
}

