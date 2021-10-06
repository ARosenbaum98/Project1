package com.reimbursement.connection;

import com.github.javafaker.Faker;
import com.reimbursement.webmodels.User;

import java.time.LocalDateTime;
import java.util.Locale;
import java.util.Objects;
import java.util.Random;
import java.util.Scanner;

public class Populate {

    static Scanner in = new Scanner(System.in);

    public static void main(String[] args){

       populateUsers();
    }

    public static void populateUsers(){

        System.out.println("Would you like to add a manager and five users to the database?");
        System.out.println("(y/n)");
        if(!Objects.equals(in.next(), "y")) return;

        SQLConnect<User> connect = new SQLConnect<>(User.class);

        // Create our manager
        User manager = createRandomUser(true);

        // Create five supervisees for them to manage
        for(int i = 0; i < 5; i++){
            User supervisee = createRandomUser(false);
            connect.insert(supervisee);
            manager.addSupervisee(supervisee);
        }

        // Push to database
        connect.insert(manager);
    }

    public static User createRandomUser(boolean isManager){

        Scanner in = new Scanner(System.in);
        Faker f = new Faker();
        Random r = new Random();

        String password = f.internet().password();
        LocalDateTime date_joined = LocalDateTime.now();
        String fname = f.name().firstName();
        String mname = (r.nextInt(5)==0)?f.name().firstName():null;
        String lname = f.name().lastName();
        String username = fname+"."+lname+r.nextInt(100);
        String email = username+"@email.com";
        String suffix = (r.nextInt(20)==0)?f.name().suffix():null;
        String gender = (r.nextInt(20)==0)?"N":r.nextBoolean()?"F":"M";
        String prefix = (gender=="F")?"Ms":(gender=="M")?"Mr":"Mx";
        Integer pictureId = null;
        String address1 = f.address().streetAddress();
        String address2 = null;
        String addressCity = f.address().city();
        String addressState = f.address().stateAbbr();
        int zip = 10000+r.nextInt( 89999);

        User user = new User(
             -1, isManager, email, username, password,
                date_joined,
                prefix, fname, mname, lname, suffix, gender,
                pictureId, address1, address2, addressCity, addressState, zip
        );

        return user;

    }
}
