package com.reimbursement.webmodels;

import com.reimbursement.connection.SQLConnect;
import org.hibernate.annotations.NaturalId;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name="p1_users")
public class User {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="user_id")
    private Integer id;

    @Column(name = "is_manager", nullable = false)
    private boolean isManager;

    @Email(message = "email validation")
    @Column(name = "email", nullable = false, unique = true)
    private String email;

    @NotNull(message = "username null check ")
    @NaturalId
    @Column(nullable = false, unique = true)
    private String username;

    @Column(name = "pass", nullable = false, unique = true)
    private String password;

    @Column(name = "date_joined")
    private LocalDateTime dateJoined;

    @Column(name = "prefix")
    private String prefix;

    @Column(name = "fname")
    private String fname;

    @Column(name = "mname")
    private String mname;

    @Column(name = "lname", nullable = false)
    private String lname;

    @Column(name = "suffix")
    private String suffix;

    @Column(name = "gender")
    private String gender;

    @Column(name = "picture_id")
    private Integer pictureId;

    @Column(name = "address_line_1")
    private String addressLine1;

    @Column(name = "address_line_2")
    private String addressLine2;

    @Column(name = "address_city")
    private String addressCity;

    @Column(name = "address_state")
    private String addressState;

    @Column(name = "zip")
    private Integer zip;

    @ManyToMany( fetch = FetchType.LAZY, cascade = CascadeType.MERGE)
    @JoinTable(
            name = "p1_manager_employee_map",
            joinColumns = {
                @JoinColumn(name = "employee_id")
            },
            inverseJoinColumns = {
               @JoinColumn(name = "manager_id")
            }
    )
    private List<User> managers = new ArrayList<>();

    @ManyToMany( fetch = FetchType.LAZY, cascade = CascadeType.MERGE)
    @JoinTable(
            name = "p1_manager_employee_map",
            joinColumns = {
                    @JoinColumn(name = "manager_id")
            },
            inverseJoinColumns = {
                    @JoinColumn(name = "employee_id")
            }
    )
    private List<User> supervisees = new ArrayList<User>();

    /**
     * @return Gets all managers for employee user - returns null if user is a manager
     */
    public List<User> getManagers() {
        if(isManager) return null;
        return managers;
    }

    public void addManagers(User... managers) {
        this.managers.addAll(Arrays.asList(managers));
    }

    /**
     * @return Gets all supervisees for manager user - returns null if user is not a manager
     */
    public List<User> getSupervisees() {
        if(!isManager) return null;
        return supervisees;
    }

    public void addSupervisee(User... supervisees) {
        this.supervisees.addAll(Arrays.asList(supervisees));
    }

    public Integer getId() {
        return id;
    }

    public boolean isManager() {
        return isManager;
    }

    public String getAddressState() {
        return addressState;
    }

    public String getAddressCity() {
        return addressCity;
    }

    public Integer getPictureId() {
        return pictureId;
    }

    public String getGender() {
        return gender;
    }

    public String getSuffix() {
        return suffix;
    }

    public String getLname() {
        return lname;
    }

    public String getMname() {
        return mname;
    }

    public String getFname() {
        return fname;
    }

    public String getPrefix() {
        return prefix;
    }

    public LocalDateTime getDateJoined() {
        return dateJoined;
    }

    public String getPassword() {
        return password;
    }

    public String getUsername() {
        return username;
    }

    public String getEmail() {
        return email;
    }

    public boolean getIsManager() {
        return isManager;
    }

    public String getAddressLine1() {
        return addressLine1;
    }

    public String getAddressLine2() {
        return addressLine2;
    }

    public Integer getZip() {
        return zip;
    }

    public void setManager(boolean manager) {
        isManager = manager;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setDateJoined(LocalDateTime dateJoined) {
        this.dateJoined = dateJoined;
    }

    public void setPrefix(String prefix) {
        this.prefix = prefix;
    }

    public void setFname(String fname) {
        this.fname = fname;
    }

    public void setMname(String mname) {
        this.mname = mname;
    }

    public void setLname(String lname) {
        this.lname = lname;
    }

    public void setSuffix(String suffix) {
        this.suffix = suffix;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public void setPictureId(Integer pictureId) {
        this.pictureId = pictureId;
    }

    public void setAddressLine1(String addressLine1) {
        this.addressLine1 = addressLine1;
    }

    public void setAddressLine2(String addressLine2) {
        this.addressLine2 = addressLine2;
    }

    public void setAddressCity(String addressCity) {
        this.addressCity = addressCity;
    }

    public void setAddressState(String addressState) {
        this.addressState = addressState;
    }

    public void setZip(Integer zip) {
        this.zip = zip;
    }

    public User(Integer id, boolean isManager, String email, String username, String password, LocalDateTime dateJoined, String prefix, String fname, String mname, String lname, String suffix, String gender, Integer pictureId, String addressLine1, String addressLine2, String addressCity, String addressState, Integer zip) {
        this.id = id;
        this.isManager = isManager;
        this.email = email;
        this.username = username;
        this.password = password;
        this.dateJoined = dateJoined;
        this.prefix = prefix;
        this.fname = fname;
        this.mname = mname;
        this.lname = lname;
        this.suffix = suffix;
        this.gender = gender;
        this.pictureId = pictureId;
        this.addressLine1 = addressLine1;
        this.addressLine2 = addressLine2;
        this.addressCity = addressCity;
        this.addressState = addressState;
        this.zip = zip;
    }

    public User(){}
    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", isManager=" + isManager +
                ", email='" + email + '\'' +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", dateJoined=" + dateJoined +
                ", prefix='" + prefix + '\'' +
                ", fname='" + fname + '\'' +
                ", mname='" + mname + '\'' +
                ", lname='" + lname + '\'' +
                ", suffix='" + suffix + '\'' +
                ", gender='" + gender + '\'' +
                ", pictureLink='" + pictureId + '\'' +
                ", addressLine1='" + addressLine1 + '\'' +
                ", addressLine2='" + addressLine2 + '\'' +
                ", addressCity='" + addressCity + '\'' +
                ", addressState='" + addressState + '\'' +
                ", zip=" + zip +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return id == user.id && Objects.equals(email, user.email) && Objects.equals(username, user.username);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, email, username);
    }

    @Override
    public User clone(){
        return new User(
                id,
                isManager,
                email,
                username,
                password,
                dateJoined,
                prefix,
                fname,
                mname,
                lname,
                suffix,
                gender,
                pictureId,
                addressLine1,
                addressLine2,
                addressCity,
                addressState,
                zip
        );
    }

}
