package edu.bsuir.ss.model;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

/**
 * Created by Antony on 01.12.2016.
 */
public class FolderModel {

    @SerializedName("id")
    private int id;

    @SerializedName("head_folder")
    private int headFolder;

    @SerializedName("type")
    private Boolean type;

    @SerializedName("name")
    private String name;

    @SerializedName("description")
    private String description;

    @SerializedName("head_user")
    private UserModel headUser;

    @SerializedName("group_users")
    private ArrayList<UserModel> groupUsers;

    @SerializedName("folders")
    private ArrayList<FolderModel> folders;

    @SerializedName("folders")
    private ArrayList<TaskModel> tasks;

    public FolderModel() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getHeadFolder() {
        return headFolder;
    }

    public void setHeadFolder(int headFolder) {
        this.headFolder = headFolder;
    }

    public Boolean getType() {
        return type;
    }

    public void setType(Boolean type) {
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public UserModel getHeadUser() {
        return headUser;
    }

    public void setHeadUser(UserModel headUser) {
        this.headUser = headUser;
    }

    public ArrayList<UserModel> getGroupUsers() {
        return groupUsers;
    }

    public void setGroupUsers(ArrayList<UserModel> groupUsers) {
        this.groupUsers = groupUsers;
    }

    public ArrayList<FolderModel> getFolders() {
        return folders;
    }

    public void setFolders(ArrayList<FolderModel> folders) {
        this.folders = folders;
    }

    public ArrayList<TaskModel> getTasks() {
        return tasks;
    }

    public void setTasks(ArrayList<TaskModel> tasks) {
        this.tasks = tasks;
    }
}


