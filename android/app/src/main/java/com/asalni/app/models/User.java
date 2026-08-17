package com.asalni.app.models;

import com.google.gson.annotations.SerializedName;

public class User {
    @SerializedName("id")
    public String id;

    @SerializedName("name")
    public String name;

    @SerializedName("email")
    public String email;

    @SerializedName("password")
    public String password;

    @SerializedName("role")
    public String role; // "admin", "expert", "user"

    @SerializedName("expertStatus")
    public String expertStatus; // "pending", "verified", "active", "suspended"

    @SerializedName("createdAt")
    public String createdAt;

    @SerializedName("updatedAt")
    public String updatedAt;
}
