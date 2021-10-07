package com.reimbursement.weblinks;

import com.reimbursement.webmodels.User;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class WebLink {

    public static void signinRedirect(HttpServletRequest request, HttpServletResponse response) throws IOException {

        // Get user
        User user = LoginCookie.getLoginUser(request);

        // Send redirect if not logged in
        if(user==null){
            response.sendRedirect("/Project1_war_exploded/sign-in");
            return;
        }
    }

}
