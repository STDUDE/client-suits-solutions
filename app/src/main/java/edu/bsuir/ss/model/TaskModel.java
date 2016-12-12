package edu.bsuir.ss.model;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

public class TaskModel {

    @SerializedName("id")
    private int id;

    @SerializedName("name")
    private String name;

    @SerializedName("content")
    private String content;

    @SerializedName("start_datetime")
    private String startDate;

    @SerializedName("end_datetime")
    private String endDate;

    @SerializedName("head_folder")
    private int headFolder;

    @SerializedName("head_user")
    private UserModel headUser;

    @SerializedName("executors")
    private ArrayList<UserModel> executors;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public String getEndDate() {
        return endDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }

    public int getHeadFolder() {
        return headFolder;
    }

    public void setHeadFolder(int headFolder) {
        this.headFolder = headFolder;
    }

    public UserModel getHeadUser() {
        return headUser;
    }

    public void setHeadUser(UserModel headUser) {
        this.headUser = headUser;
    }

    public ArrayList<UserModel> getExecutors() {
        return executors;
    }

    public void setExecutors(ArrayList<UserModel> executors) {
        this.executors = executors;
    }
}
