package com.example.helpinghand.model;

public class User {

    private int id;
    private String userName;
    private String email;
    private String password;
    private String firstName;
    private String postcode;
    private int group;
    private int admin;
    private String kindOfHelp;
    private String aboutMe;

    public User(int id, String userName, String email, String password, String firstName, String postcode, int group, int admin, String kindOfHelp, String aboutMe){
        this.id = id;
        this.userName = userName;
        this.email = email;
        this.password = password;
        this.firstName = firstName;
        this.postcode = postcode;
        this.group = 0;
        this.admin = 0;
        this.kindOfHelp = kindOfHelp;
        this.aboutMe = aboutMe;

    }


    public int getId() {
        return id;
    }

    public String getUserName() {
        return userName;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPostcode() {
        return postcode;
    }

    public void setPostcode(String postcode) {
        this.postcode = postcode;
    }

    public int getGroup() {
        return group;
    }

    public void setGroup(int group) {
        this.group = group;
    }

    public int getAdmin() {
        return admin;
    }

    public void setAdmin(int admin) {
        this.admin = admin;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

}
