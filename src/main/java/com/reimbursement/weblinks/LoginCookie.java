package com.reimbursement.weblinks;

import com.reimbursement.connection.SQLConnect;
import com.reimbursement.webmodels.User;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import java.util.Objects;

public class LoginCookie {

    public static final String USER_COOKIE = "reimbursementsApp_username";
    public static final String PASSWORD_COOKIE = "reimbursementsApp_password";
    public static final String FNAME_COOKIE = "reimbursementsApp_fname";
    public static final String LNAME_COOKIE = "reimbursementsApp_lname";


    public static User getLoginUserFromServer(HttpServletRequest request) {
        Cookie[] cookies = null;

        SQLConnect<User> connect = new SQLConnect(User.class);

        // Get an array of Cookies associated with this domain
        cookies = request.getCookies();
        String username = "";
        String password = "";

        for (Cookie cookie : cookies) {

            // Get the Username cookie
            if (cookie.getName().equals(USER_COOKIE)) {

                // User is logged out
                if (Objects.equals(cookie.getValue(), "")) {
                    return null;
                }

                username = cookie.getValue();
            }

            if(cookie.getName().equals(PASSWORD_COOKIE)){
                // User is logged out
                if (Objects.equals(cookie.getValue(), "")) {
                    return null;
                }

                password = cookie.getValue();
            }
        }

        String[] cols = {"username","pass"};
        Object[] vals = {username, password};
        User user = connect.getUnique(cols, vals);

        return user;
    }

    public static String getPasswordFromCookie(HttpServletRequest request){
        try {
            return getCookieByName(request, PASSWORD_COOKIE).getValue();
        }catch(NullPointerException e){
            return null;
        }
    }

    public static String getUsernameFromCookie(HttpServletRequest request){
        try {
            return getCookieByName(request, USER_COOKIE).getValue();
        }catch(NullPointerException e){
            return null;
        }
    }

    public static String getFnameFromCookie(HttpServletRequest request){
        try {
            return getCookieByName(request, FNAME_COOKIE).getValue();
        }catch(NullPointerException e){
            return null;
        }
    }

    public static String getLnameFromCookie(HttpServletRequest request){
        try {
            return getCookieByName(request, LNAME_COOKIE).getValue();
        }catch(NullPointerException e){
            return null;
        }
    }

    private static Cookie getCookieByName(HttpServletRequest request, String cookieName){

        Cookie[] cookies = null;
        cookies = request.getCookies();

        for (Cookie cookie : cookies) {

            if (cookie.getName().equals(cookieName)) {
                return cookie;
            }
        }
        return null;
    }
}
