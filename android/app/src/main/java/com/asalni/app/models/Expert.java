package com.asalni.app.models;

import com.google.gson.annotations.SerializedName;

public class Expert {
    @SerializedName("id")
    public String id;

    @SerializedName("userId")
    public String userId;

    @SerializedName("specialty")
    public String specialty;

    @SerializedName("bio")
    public String bio;

    @SerializedName("rating")
    public double rating;

    @SerializedName("totalConsultations")
    public int totalConsultations;

    @SerializedName("status")
    public String status; // "pending", "verified", "active", "suspended"

    @SerializedName("user")
    public User user;
}
