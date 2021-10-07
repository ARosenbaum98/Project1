package com.reimbursement.weblinks;

import com.reimbursement.connection.SQLConnect;
import com.reimbursement.webmodels.User;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import java.util.Objects;

public class LoginCookie {

    public static final String USER_COOKIE = "reimbursementsApp_username";
    public static final String PASSWORD_COOKIE = "reimbursementsApp_password";

    public static User getLoginUser(HttpServletRequest request) {
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
}
