package com.reimbursement.weblinks;

import com.reimbursement.webmodels.User;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class WebLink {

    public static final String URL_HOME = "http://localhost:8080/Project1_war_exploded/";
    public static final String PATH_SIGN_IN = "sign-in/";
    public static final String PATH_CSS = "css/";
    public static final String PATH_PROFILE = "profile/";
    public static final String PATH_HTML_TEMPLATES = "static-html/";
    public static final String PATH_SITE_IMGS = "imgs/";

    public static final String URL_SIGN_IN = URL_HOME+PATH_SIGN_IN;
    public static final String URL_CSS = URL_HOME+PATH_CSS;
    public static final String URL_PROFILE = URL_HOME+PATH_PROFILE;
    public static final String URL_HTML_TEMPL = URL_HOME+PATH_HTML_TEMPLATES;
    public static final String URL_SITE_IMGS = URL_HOME+PATH_SITE_IMGS;
    public static final String URL_LOGOUT = URL_HOME+"logout";

    public static User signinRedirect(HttpServletRequest request, HttpServletResponse response) throws IOException {

        // Get user
        User user = LoginCookie.getLoginUserFromServer(request);

        // Send redirect if not logged in
        if(user==null){
            response.sendRedirect(URL_HOME+"sign-in");
            return null;
        }
        return user;
    }

}
