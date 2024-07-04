package com.example.WalletLedgerSystem.dao.rdms;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;


import java.util.Date;
import java.util.List;
import java.util.UUID;

import static java.util.UUID.randomUUID;


@Getter
@Setter
@Entity
@ToString
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String firstName;
    private String middleName;
    private String lastName;
    private String email;
    private boolean isPrimary;
    private int mobileNumber;
    private String stateCode;
    private String uniqueParam;
    private Date dob;
    private String displayName;
    private String gender;
    private String isSubWallet;
    private int parentWalletId;
    private int linkedKycLimit;
    private int externalRefId;
    private String userId;

    @PrePersist
    public void onCreate() {
        this.userId = generateUserId();
    }

    private String generateUserId() {
        String random = UUID.randomUUID().toString().replace("-", "").substring(0, 10);
        return "usr"+random;
    }

    public User() {

    }

    public User(int id, String firstName, String middleName, String lastName, String email, int mobileNumber, String stateCode, String uniqueParam, Date dob, String displayName, String gender, String isSubWallet, int parentWalletId, int linkedKycLimit, int externalRefId, int userId) {
        this.firstName = firstName;
        this.middleName = middleName;
        this.lastName = lastName;
        this.email = email;
        this.mobileNumber = mobileNumber;
        this.stateCode = stateCode;
        this.uniqueParam = uniqueParam;
        this.dob = dob;
        this.displayName = displayName;
        this.gender = gender;
        this.isSubWallet = isSubWallet;
        this.parentWalletId = parentWalletId;
        this.linkedKycLimit = linkedKycLimit;
        this.externalRefId = externalRefId;
        this.id = id;
    }
}

    //    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true)
//     private List<Wallet> wallets;






