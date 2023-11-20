package com.example.acmeverificacaoapi.controller;

import com.example.acmeverificacaoapi.entity.UserAccount;
import com.example.acmeverificacaoapi.entity.UserRequest;
import com.example.acmeverificacaoapi.service.RequestService;
import com.example.acmeverificacaoapi.service.UserService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.concurrent.ExecutionException;

@RestController
public class RequestController {

    public RequestService requestService;

    public RequestController(RequestService requestService){
        this.requestService = requestService;
    }

    @GetMapping("/getAllRequests")
    public List<UserRequest> getRequests() throws ExecutionException, InterruptedException {
        return requestService.getAllRequests();
    }

    @PutMapping("/changeStatusRequest")
    public String changeRequestStatus(@RequestBody UserRequest userRequest) throws ExecutionException, InterruptedException {
        return requestService.changeStatus(userRequest);

    }
}
