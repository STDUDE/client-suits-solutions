package edu.bsuir.ss.api.login;

import com.google.gson.annotations.SerializedName;

import edu.bsuir.ss.model.UserModel;

/**
 * Created by Antony on 01.12.2016.
 */
public class LoginResponse {
    @SerializedName("token")
    private String token;

    @SerializedName("user")
    private UserModel user;

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public UserModel getUserDetails() {
        return user;
    }

    public void setUserDetails(UserModel user) {
        this.user = user;
    }
}
