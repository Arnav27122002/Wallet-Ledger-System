package com.example.WalletLedgerSystem.dao.requestresponse;

import lombok.*;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class UserResponse {
    private int userId;
    private String firstName;
    private String lastName;
    private String email;
}

