package com.example.acmeverificacaoapi.controller;

import com.example.acmeverificacaoapi.entity.SubItem;
import com.example.acmeverificacaoapi.entity.UserRequest;
import com.example.acmeverificacaoapi.service.SubItemService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.concurrent.ExecutionException;

@RestController
public class SubItemController {

    public SubItemService subItemService;

    public SubItemController(SubItemService subItemService){
        this.subItemService = subItemService;
    }

    @GetMapping("/getAllSubItens")
    public List<SubItem> getRequests() throws ExecutionException, InterruptedException {
        return subItemService.getAllSubItens();
    }
}
