package com.example.acmeverificacaoapi.entity;

import lombok.Getter;
import lombok.Setter;

import java.sql.Timestamp;

@Getter
@Setter
public class UserRequest {

    public String date_request;
    public String id_user;
    public int request_approver_primary;
    public int request_approver_secondary;
    public int request_code;
    public String request_local;
    public String rid;
    public boolean send_status;
    public boolean status_request;

}
