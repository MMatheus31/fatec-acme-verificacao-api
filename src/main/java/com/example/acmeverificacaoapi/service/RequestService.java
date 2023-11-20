package com.example.acmeverificacaoapi.service;

import com.example.acmeverificacaoapi.entity.UserAccount;
import com.example.acmeverificacaoapi.entity.UserRequest;
import com.google.api.core.ApiFuture;
import com.google.cloud.firestore.Firestore;
import com.google.cloud.firestore.QueryDocumentSnapshot;
import com.google.cloud.firestore.QuerySnapshot;
import com.google.cloud.firestore.WriteResult;
import com.google.firebase.cloud.FirestoreClient;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;

@Service
public class RequestService {

    public List<UserRequest> getAllRequests() throws ExecutionException, InterruptedException {

        Firestore dbFirestore = FirestoreClient.getFirestore();
        QuerySnapshot querySnapshot = dbFirestore.collection("UserRequest").get().get();
        List<UserRequest> userRequests = new ArrayList<>();

        for (QueryDocumentSnapshot documentSnapshot : querySnapshot){
            UserRequest userRequest = documentSnapshot.toObject(UserRequest.class);
            userRequests.add(userRequest);
        }

        return userRequests;
    }

    public String changeStatus(UserRequest userRequest) throws ExecutionException, InterruptedException {

        Firestore dbFirestore = FirestoreClient.getFirestore();
        ApiFuture<WriteResult> collectionApiFuture = dbFirestore.collection("UserRequest").document(userRequest.getRid()).set(userRequest);
        return "Request Approved " + collectionApiFuture.get().getUpdateTime().toString();
    }
}
