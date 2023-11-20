package com.example.acmeverificacaoapi.controller;

import com.example.acmeverificacaoapi.entity.UserAccount;
import com.example.acmeverificacaoapi.service.UserService;
import org.springframework.web.bind.annotation.*;

import java.util.concurrent.ExecutionException;

@RestController
public class UserController {

    public UserService userService;

    public UserController(UserService userService){
        this.userService = userService;
    }

    @GetMapping("/getUser")
    public UserAccount getUserAccount(@RequestParam String documentId) throws ExecutionException, InterruptedException {
        return userService.getUser(documentId);
    }

    @PutMapping("/changeUser")
    public String changeUserAccountForManager(@RequestBody UserAccount userAccount) throws ExecutionException, InterruptedException {
        return userService.changeUserForManager(userAccount);
    }

    @DeleteMapping("/deleteUser")
    public String deleteUserAccountForManager(@RequestParam String documentId) {
        return userService.deleteUserForManager(documentId);
    }
}
