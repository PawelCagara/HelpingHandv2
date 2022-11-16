package com.example.helpinghand.model;


import com.google.firebase.database.Exclude;

import java.util.HashMap;
import java.util.Map;

public class Message {
    public String msgId, userId, msg, userName, empty;

    public Message() {
    }

    public Message(String empty) {
        this.empty = empty;
    }

    public Message(String msgId, String userName, String userId, String msg, String userGender) {
        this.msgId = msgId;
        this.userId = userId;
        this.msg = msg;
        this.userName = userName;
    }

    public Message(String msgId, String userName, String userId, String msg, String userGender, String empty) {
        this.msgId = msgId;
        this.userId = userId;
        this.msg = msg;
        this.userName = userName;
        this.empty = empty;
    }

    @Exclude
    Map<String, Object> toMap() {
        HashMap<String, Object> result = new HashMap<>();
        result.put("msgId", msgId);
        result.put("userId", userId);
        result.put("msg", msg);
        result.put("userName", userName);
        return result;
    }
}
