package com.reimbursement.weblinks;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.reimbursement.connection.SQLConnect;
import com.reimbursement.webmodels.User;

import java.io.*;
import javax.json.Json;
import javax.servlet.ServletException;
import javax.servlet.http.*;
import javax.servlet.annotation.*;

@WebServlet(
        name = "Logout",
        value = "/logout"
)
public class LogoutServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Cookie ckusername=new Cookie(LoginCookie.USER_COOKIE, "");
        Cookie ckpassword=new Cookie(LoginCookie.PASSWORD_COOKIE, "");
        Cookie ckfname=new Cookie(LoginCookie.FNAME_COOKIE, "");
        Cookie cklname=new Cookie(LoginCookie.LNAME_COOKIE, "");

        ckusername.setMaxAge(0);
        ckpassword.setMaxAge(0);
        ckfname.setMaxAge(0);
        cklname.setMaxAge(0);

        response.addCookie(ckusername);
        response.addCookie(ckpassword);
        response.addCookie(ckfname);
        response.addCookie(cklname);

        response.sendRedirect(WebLink.URL_HOME);
        return;
    }
}