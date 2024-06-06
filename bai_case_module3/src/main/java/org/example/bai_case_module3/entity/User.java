package org.example.bai_case_module3.entity;

import java.util.Date;

public class User {
    private int userId;
    private String username;
    private String password;
    private String fullName;
    private Role roleId;
    private Date dateOfBirth;
    private Gender gender;
    private String email;
    private String phoneNumber;
    private String address;
    private Double wallet;
    private Status status= Status.ACTIVE;

    public User() {
    }

    public User(String username, String password, String fullName, Role roleId, Date dateOfBirth, Gender gender, String email, String phoneNumber, String address, Double wallet, Status status) {
        this.username = username;
        this.password = password;
        this.fullName = fullName;
        this.roleId = roleId;
        this.dateOfBirth = dateOfBirth;
        this.gender = gender;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.address = address;
        this.wallet = wallet;
        this.status = status;
    }

    public User(String username, String password, String fullName, Role roleId, Date dateOfBirth, Gender gender, String email, String phoneNumber, String address) {
        this.username = username;
        this.password = password;
        this.fullName = fullName;
        this.roleId = roleId;
        this.dateOfBirth = dateOfBirth;
        this.gender = gender;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.address = address;
    }

    public User(int userId, String username, String password, String fullName, Role roleId, Date dateOfBirth, Gender gender, String email, String phoneNumber, String address, Double wallet, Status status) {
        this.userId = userId;
        this.username = username;
        this.password = password;
        this.fullName = fullName;
        this.roleId = roleId;
        this.dateOfBirth = dateOfBirth;
        this.gender = gender;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.address = address;
        this.wallet = wallet;
        this.status = status;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public Role getRoleId() {
        return roleId;
    }

    public void setRoleId(Role roleId) {
        this.roleId = roleId;
    }

    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Double getWallet() {
        return wallet;
    }

    public void setWallet(Double wallet) {
        this.wallet = wallet;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }
}
