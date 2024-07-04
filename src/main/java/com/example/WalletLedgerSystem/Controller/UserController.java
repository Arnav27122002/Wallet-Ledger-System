package com.example.WalletLedgerSystem.Controller;


import com.example.WalletLedgerSystem.Service.UserService;
import com.example.WalletLedgerSystem.dao.rdms.User;
import com.example.WalletLedgerSystem.dao.rdms.Wallet;
import com.example.WalletLedgerSystem.dao.requestresponse.UserRequest;
import com.example.WalletLedgerSystem.dao.requestresponse.UserResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userservice;

    @PostMapping("/create")
    public ResponseEntity<UserResponse> createUser(@RequestBody UserRequest userRequestDTO)
    {
        UserResponse createduser= userservice.saveUserWal(userRequestDTO);
        return ResponseEntity.ok(createduser);
    }

    @GetMapping("/state/{stateCode}")
    public ResponseEntity<List<User>> getUserBasedOnState(@PathVariable String stateCode)
    {
         List<User> receivedUser= userservice.getUserBasedOnState(stateCode);
         return ResponseEntity.ok(receivedUser);
    }


}
