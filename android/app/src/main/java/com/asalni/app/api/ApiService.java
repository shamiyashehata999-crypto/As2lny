package com.asalni.app.api;

import com.asalni.app.models.User;
import com.asalni.app.models.Consultation;
import com.asalni.app.models.Expert;
import com.asalni.app.models.Message;
import retrofit2.Call;
import retrofit2.http.*;
import java.util.List;

public interface ApiService {
    // Authentication
    @POST("/api/auth/register")
    Call<AuthResponse> register(@Body User user);

    @POST("/api/auth/login")
    Call<AuthResponse> login(@Body LoginRequest loginRequest);

    @GET("/api/auth/me")
    Call<User> getMe();

    // Experts
    @GET("/api/experts")
    Call<List<Expert>> getExperts();

    @POST("/api/experts/apply")
    Call<Expert> applyAsExpert(@Body ExpertApplication application);

    @GET("/api/experts/{id}")
    Call<Expert> getExpert(@Path("id") String id);

    // Consultations
    @GET("/api/consultations")
    Call<List<Consultation>> getConsultations();

    @POST("/api/consultations")
    Call<Consultation> createConsultation(@Body Consultation consultation);

    @GET("/api/consultations/{id}")
    Call<Consultation> getConsultation(@Path("id") String id);

    @PUT("/api/consultations/{id}")
    Call<Consultation> updateConsultation(@Path("id") String id, @Body Consultation consultation);

    // Messages
    @POST("/api/messages")
    Call<Message> sendMessage(@Body Message message);

    @GET("/api/messages/{consultationId}")
    Call<List<Message>> getMessages(@Path("consultationId") String consultationId);

    // AI
    @POST("/api/ai/ask")
    Call<AiResponse> askAi(@Body AiRequest request);

    // Admin
    @GET("/api/admin/stats")
    Call<AdminStats> getStats();

    @GET("/api/admin/users")
    Call<List<User>> getAllUsers();

    public class AuthResponse {
        public String token;
        public User user;
    }

    public class LoginRequest {
        public String email;
        public String password;
    }

    public class ExpertApplication {
        public String specialty;
        public String bio;
        public String documents;
    }

    public class AiRequest {
        public String question;
    }

    public class AiResponse {
        public String answer;
    }

    public class AdminStats {
        public int totalUsers;
        public int totalExperts;
        public int totalConsultations;
        public int totalReports;
    }
}
