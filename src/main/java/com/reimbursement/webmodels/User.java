package com.reimbursement.webmodels;

import java.time.LocalDateTime;
import java.util.Objects;

public class User {

    private int id;
    private boolean isManager;
    private String email;
    private String username;
    private String password;
    private LocalDateTime dateJoined;
    private String prefix;
    private String fname;
    private String mname;
    private String lname;
    private String suffix;
    private String gender;
    private String pictureLink;
    private String addressLine1;
    private String addressLine2;
    private String addressCity;
    private String addressState;
    private int zip;

    public User(int id, boolean isManager, String email, String username, String password, LocalDateTime dateJoined, String prefix, String fname, String mname, String lname, String suffix, String gender, String pictureLink, String addressLine1, String addressLine2, String addressCity, String addressState, int zip) {

        this.id = id;
        this.setManager(isManager);
        this.setEmail(email);
        this.setUsername(username);
        this.setPassword(password);
        this.setDateJoined(dateJoined);
        this.setPrefix(prefix);
        this.setFname(fname);
        this.setMname(mname);
        this.setLname(lname);
        this.setSuffix(suffix);
        this.setGender(gender);
        this.setPictureLink(pictureLink);
        this.setAddressLine1(addressLine1);
        this.setAddressLine2(addressLine2);
        this.setAddressCity(addressCity);
        this.setAddressState(addressState);
        this.setZip(zip);
    }

    public int getId() {
        return id;
    }

    public boolean isManager() {
        return isManager;
    }

    public void setManager(boolean manager) {
        isManager = manager;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
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

    public LocalDateTime getDateJoined() {
        return dateJoined;
    }

    public void setDateJoined(LocalDateTime dateJoined) {
        this.dateJoined = dateJoined;
    }

    public String getPrefix() {
        return prefix;
    }

    public void setPrefix(String prefix) {
        this.prefix = prefix;
    }

    public String getFname() {
        return fname;
    }

    public void setFname(String fname) {
        this.fname = fname;
    }

    public String getMname() {
        return mname;
    }

    public void setMname(String mname) {
        this.mname = mname;
    }

    public String getLname() {
        return lname;
    }

    public void setLname(String lname) {
        this.lname = lname;
    }

    public String getSuffix() {
        return suffix;
    }

    public void setSuffix(String suffix) {
        this.suffix = suffix;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getPictureLink() {
        return pictureLink;
    }

    public void setPictureLink(String pictureLink) {
        this.pictureLink = pictureLink;
    }

    public String getAddressLine1() {
        return addressLine1;
    }

    public void setAddressLine1(String addressLine1) {
        this.addressLine1 = addressLine1;
    }

    public String getAddressLine2() {
        return addressLine2;
    }

    public void setAddressLine2(String addressLine2) {
        this.addressLine2 = addressLine2;
    }

    public String getAddressCity() {
        return addressCity;
    }

    public void setAddressCity(String addressCity) {
        this.addressCity = addressCity;
    }

    public String getAddressState() {
        return addressState;
    }

    public void setAddressState(String addressState) {
        this.addressState = addressState;
    }

    public int getZip() {
        return zip;
    }

    public void setZip(int zip) {
        this.zip = zip;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + this.getId() +
                ", isManager=" + this.isManager() +
                ", email='" + this.getEmail() + '\'' +
                ", username='" + this.getUsername() + '\'' +
                ", password='" + this.getPassword() + '\'' +
                ", dateJoined=" + this.getDateJoined() +
                ", prefix='" + this.getPrefix() + '\'' +
                ", fname='" + this.getFname() + '\'' +
                ", mname='" + this.getMname() + '\'' +
                ", lname='" + this.getLname() + '\'' +
                ", suffix='" + this.getSuffix() + '\'' +
                ", gender='" + this.getGender() + '\'' +
                ", pictureLink='" + this.getPictureLink() + '\'' +
                ", addressLine1='" + this.getAddressLine1() + '\'' +
                ", addressLine2='" + this.getAddressLine2() + '\'' +
                ", addressCity='" + this.getAddressCity() + '\'' +
                ", addressState='" + this.getAddressState() + '\'' +
                ", zip='" + this.getZip() + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return getId() == user.getId() && getEmail().equals(user.getEmail()) && getUsername().equals(user.getUsername());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getEmail(), getUsername());
    }

    @Override
    public Object clone() {
        return new User(this.getId(), this.isManager(), this.getEmail(), this.getUsername(), this.getPassword(), this.getDateJoined(), this.getPrefix(), this.getFname(), this.getMname(), this.getLname(), this.getSuffix(), this.getGender(), this.getPictureLink(), this.getAddressLine1(), this.getAddressLine2(), this.getAddressCity(), this.getAddressState(), this.getZip());
    }
}
