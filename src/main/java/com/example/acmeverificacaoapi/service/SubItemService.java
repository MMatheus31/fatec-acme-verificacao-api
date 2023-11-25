package com.example.acmeverificacaoapi.service;

import com.example.acmeverificacaoapi.entity.SubItem;
import com.example.acmeverificacaoapi.entity.UserRequest;
import com.google.cloud.firestore.Firestore;
import com.google.cloud.firestore.QueryDocumentSnapshot;
import com.google.cloud.firestore.QuerySnapshot;
import com.google.firebase.cloud.FirestoreClient;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;

@Service
public class SubItemService {

    public List<SubItem> getAllSubItens() throws ExecutionException, InterruptedException {

        Firestore dbFirestore = FirestoreClient.getFirestore();
        QuerySnapshot querySnapshot = dbFirestore.collection("subitem").get().get();
        List<SubItem> subItens = new ArrayList<>();

        for (QueryDocumentSnapshot documentSnapshot : querySnapshot){
            SubItem item = documentSnapshot.toObject(SubItem.class);
            subItens.add(item);
        }

        return subItens;
    }
}
