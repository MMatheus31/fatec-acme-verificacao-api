package com.example.acmeverificacaoapi.service;

import com.example.acmeverificacaoapi.entity.UserAccount;
import com.google.api.core.ApiFuture;
import com.google.cloud.firestore.DocumentReference;
import com.google.cloud.firestore.DocumentSnapshot;
import com.google.cloud.firestore.Firestore;
import com.google.cloud.firestore.WriteResult;
import com.google.firebase.cloud.FirestoreClient;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Map;
import java.util.concurrent.ExecutionException;

@Service
public class UserService {

    public UserAccount getUser(String documentId) throws ExecutionException, InterruptedException {

        Firestore dbFirestore = FirestoreClient.getFirestore();
        DocumentReference documentReference = dbFirestore.collection("UserAccount").document(documentId);
        ApiFuture<DocumentSnapshot> future = documentReference.get();
        DocumentSnapshot document = future.get();

        if (document.exists()){
            return document.toObject(UserAccount.class);
        }

        return null;
    }

    public String changeUserForManager(UserAccount userAccount) throws ExecutionException, InterruptedException {

        Firestore dbFirestore = FirestoreClient.getFirestore();
        ApiFuture<WriteResult> collectionApiFuture = dbFirestore.collection("UserAccount").document(userAccount.getUid()).set(userAccount);
        return collectionApiFuture.get().getUpdateTime().toString();
    }

    public String deleteUserForManager(String documentId){

        Firestore dbFirestore = FirestoreClient.getFirestore();
        ApiFuture<WriteResult> writeResultApiFuture = dbFirestore.collection("UserAccount").document(documentId).delete();

        return "User: " + documentId + " Successfully deleted!";
    }
}
