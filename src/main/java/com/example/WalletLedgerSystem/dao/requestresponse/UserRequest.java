package com.example.WalletLedgerSystem.dao.requestresponse;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.*;


import java.util.Date;
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class UserRequest {
        private String firstName;
        private String middleName;
        private String lastName;
        @Email(message="put the correct format")
        private String email;
    @NotNull(message = "Mobile number is required")
    @Pattern(regexp = "^[0-9]{10}$", message = "Mobile number should be 10 digits")
        private String mobileNumber;
        private String stateCode;
        private String uniqueParam;
        private Date dob;
        private String displayName;
        private String gender;
        private String isSubWallet;
        private int parentWalletId;
        private int linkedKycLimit;
        private int externalRefId;
    }
