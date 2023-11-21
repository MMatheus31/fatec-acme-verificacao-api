package com.example.acmeverificacaoapi.entity;


import com.google.cloud.firestore.annotation.DocumentId;
import lombok.Getter;
import lombok.Setter;

import java.sql.Timestamp;

@Getter
@Setter
public class UserAccount {

    public String display_name;
    public String email;
    public String phone_number;
    public String register_number;
    public int role_id;
    public int team_id;
    public String uid;
}
