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
        name = "LoginServlet",
        value = "/login"
)
public class LoginServlet extends HttpServlet {
    private String message;

    public void init() {
        message = "Hello World!";
    }


    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out=response.getWriter();

        request.getRequestDispatcher("/sign-in").include(request, response);

        String name=request.getParameter("name");
        String password=request.getParameter("password");

        SQLConnect<User> connect = new SQLConnect<>(User.class);
        String[] cols = new String[]{"username","pass"};
        String[] vals = new String[]{name, password};

        User user = connect.getUnique(cols, vals);

        if(user!= null){
            Cookie ckusername=new Cookie(LoginCookie.USER_COOKIE, String.valueOf(user.getUsername()));
            Cookie ckpassword=new Cookie(LoginCookie.PASSWORD_COOKIE, String.valueOf(user.getPassword()));
            response.addCookie(ckusername);
            response.addCookie(ckpassword);

            response.sendRedirect(WebLink.URL_HOME);
            return;
        }else{
            response.sendRedirect(WebLink.URL_SIGN_IN);
        }

        out.close();
    }



//
//    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
//        response.setContentType("text/html");
//
//        // Hello
//        PrintWriter out = response.getWriter();
//        out.println("<html><body>");
//        out.println("<h1>" + message + "</h1>");
//        out.println("</body></html>");
//    }


    public void destroy() {
    }
}