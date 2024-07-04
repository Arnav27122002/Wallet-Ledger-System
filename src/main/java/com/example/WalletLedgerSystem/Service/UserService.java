package com.example.WalletLedgerSystem.Service;

import com.example.WalletLedgerSystem.dao.enums.defaultWallet;
import com.example.WalletLedgerSystem.dao.rdms.User;
import com.example.WalletLedgerSystem.dao.rdms.Wallet;
import com.example.WalletLedgerSystem.dao.requestresponse.UserRequest;
import com.example.WalletLedgerSystem.dao.requestresponse.UserResponse;
import com.example.WalletLedgerSystem.repository.UserInterface;
import com.example.WalletLedgerSystem.repository.WalletInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;



@Service
public class UserService {

    @Autowired
    private UserInterface userinterface;
    @Autowired
    private WalletInterface walletinterface;

    @Transactional
    public UserResponse saveUserWal(UserRequest userRequestDTO) {
        User user = new User();
        user.setFirstName(userRequestDTO.getFirstName());
        user.setMiddleName(userRequestDTO.getMiddleName());
        user.setLastName(userRequestDTO.getLastName());
        user.setEmail(userRequestDTO.getEmail());
        //user.setMobileNumber(userRequestDTO.getMobileNumber());
        user.setStateCode(userRequestDTO.getStateCode());
        //user.setUniqueParam((userRequestDTO.getUniqueParam()));
        //user.setDob(userRequestDTO.getDob());
        String displayName = String.format("%s %s %s",
                userRequestDTO.getFirstName() != null ? userRequestDTO.getFirstName() : "",
                userRequestDTO.getMiddleName() != null ? userRequestDTO.getMiddleName() : "",
                userRequestDTO.getLastName() != null ? userRequestDTO.getLastName() : "").trim().replaceAll(" +", " ");

        user.setDisplayName(displayName);
        //user.setGender((userRequestDTO.getGender()));
        //user.setUniqueParam((userRequestDTO.getUniqueParam()));
        //user.setIsSubWallet((userRequestDTO.getIsSubWallet()));
        //user.setParentWalletId(userRequestDTO.getParentWalletId());
        //user.setLinkedKycLimit(userRequestDTO.getLinkedKycLimit());
        //user.setExternalRefId(userRequestDTO.getExternalRefId());

        User  savedUser = userinterface.save(user);

        List<Wallet> wallets = new ArrayList<>();
        for (defaultWallet walletType : defaultWallet.values()) {
            if(savedUser.isPrimary()==true)
            {

            }
            Wallet wallet = new Wallet();
            wallet.setWalletName(walletType.name());
            wallet.setIsSubWallet("no");
            wallet.setUser(savedUser);
            wallets.add(wallet);
        }
        walletinterface.saveAll(wallets);

        UserResponse userResponseDTO = new UserResponse();
        userResponseDTO.setFirstName(savedUser.getFirstName());
        userResponseDTO.setLastName(savedUser.getLastName());
        userResponseDTO.setEmail(savedUser.getEmail());

        return userResponseDTO;
    }


    public List<User> getUserBasedOnState(String stateCode) {
        return userinterface.findByStateCode(stateCode);
    }
}




