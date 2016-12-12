package edu.bsuir.ss.api.login;

import com.google.gson.annotations.SerializedName;

/**
 * Created by Antony on 04.12.2016.
 */
public class BaseResponse<T extends Object>
{
//    @SerializedName("code")
//    private int code;

    @SerializedName("status")
    private String status;

    @SerializedName("message")
    private String message;

    @SerializedName("body")
    private T body;

    //public int getCode() { return code; }
    public String getStatus() { return status; }
    public String getMessage() { return message; }
    public T getBody() { return body; }

    public boolean isSuccess() {
        return status.equalsIgnoreCase("SUCCESS");
    }

}