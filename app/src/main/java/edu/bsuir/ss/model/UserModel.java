package edu.bsuir.ss.model;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class UserModel {

    @SerializedName("id")
    private int id;

    @SerializedName("first_name")
    private String firstName;

    @SerializedName("last_name")
    private String lastName;

    @SerializedName("post")
    private String post;

    @SerializedName("department_id")
    private int departmentId;

    @SerializedName("photo")
    private String photo;

    @SerializedName("photo_min")
    private String photoMin;

    @SerializedName("email")
    private String email;

    @SerializedName("phone")
    private String phone;

    @SerializedName("skype")
    private String skype;

    @SerializedName("contacts")
    List<UserModel> contacts;

    @SerializedName("user_name")
    private String userName;

    @SerializedName("token")
    private String token;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getDepartmentId() {
        return departmentId;
    }

    public void setDepartmentId(int departmentId) {
        this.departmentId = departmentId;
    }

    public String getPost() {
        return post;
    }

    public void setPost(String post) {
        this.post = post;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String proto) {
        this.photo = photo;
    }

    public String getPhotoMin() {
        return photoMin;
    }

    public void setPhotoMin(String proto) {
        this.photoMin = photo;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getSkype() {
        return skype;
    }

    public void setSkype(String skype) {
        this.skype = skype;
    }

    public List<UserModel> getContacts() {
        return contacts;
    }

    public void setContacts(List<UserModel> contacts) {
        this.contacts = contacts;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }
}
