package com.asalni.app.models;

import com.google.gson.annotations.SerializedName;

public class Consultation {
    @SerializedName("id")
    public String id;

    @SerializedName("userId")
    public String userId;

    @SerializedName("expertId")
    public String expertId;

    @SerializedName("title")
    public String title;

    @SerializedName("description")
    public String description;

    @SerializedName("status")
    public String status; // "open", "closed"

    @SerializedName("rating")
    public int rating;

    @SerializedName("createdAt")
    public String createdAt;

    @SerializedName("expert")
    public Expert expert;

    @SerializedName("user")
    public User user;
}
