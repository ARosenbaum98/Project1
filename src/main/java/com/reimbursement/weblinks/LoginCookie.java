package com.reimbursement.weblinks;

import com.reimbursement.connection.SQLConnect;
import com.reimbursement.webmodels.User;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import java.util.Objects;

public class LoginCookie {

    public static User getLoginUser(HttpServletRequest request) {
        Cookie[] cookies = null;

        SQLConnect<User> connect = new SQLConnect(User.class);

        User user;

        // Get an array of Cookies associated with the this domain
        cookies = request.getCookies();

        for (Cookie cookie : cookies) {
            if (cookie.getName().equals("login_user")) {
                if (Objects.equals(cookie.getValue(), "")) {
                    return null;
                } else {
                    user = connect.getByPrimaryKey(Integer.parseInt(cookie.getValue()));
                    return user;
                }
            }
        }
        return null;
    }
}
