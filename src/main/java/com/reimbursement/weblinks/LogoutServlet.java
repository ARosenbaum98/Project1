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
        name = "LoginOut",
        value = "/logout"
)
public class LogoutServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Cookie ck=new Cookie("login_user",null);
        ck.setMaxAge(0);
        response.addCookie(ck);
        response.sendRedirect("");
    }
}