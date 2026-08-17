package com.asalni.app.models;

import com.google.gson.annotations.SerializedName;

public class Message {
    @SerializedName("id")
    public String id;

    @SerializedName("consultationId")
    public String consultationId;

    @SerializedName("senderId")
    public String senderId;

    @SerializedName("senderType")
    public String senderType; // "user", "expert", "admin"

    @SerializedName("content")
    public String content;

    @SerializedName("createdAt")
    public String createdAt;
}
