package com.reimbursement.weblinks;

import com.reimbursement.connection.SQLConnect;
import com.reimbursement.webmodels.ReimbursementRequest;
import com.reimbursement.webmodels.User;

import javax.ejb.Local;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@WebServlet(
        name = "CreateEmployeeServlet",
        value = "/createemployee"
)
public class CreateEmployeeServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String email = request.getParameter("email");
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String fname = request.getParameter("fname");
        String mname = request.getParameter("mname");
        String lname = request.getParameter("lname");
        String suffix = null;
        String gender = request.getParameter("gender");
        String address1 = request.getParameter("address-line-1");
        String address2 = request.getParameter("address-line-2");
        String city = request.getParameter("address-city");
        String state = request.getParameter("address-state");
        int zip = Integer.parseInt(request.getParameter("address-zip"));

        LocalDateTime dateCreated = LocalDateTime.now();

        User newUser = new User(-1,false, email, username, password, dateCreated, (gender.equals("M"))?"Mr":((gender.equals("F"))?"Ms":"Mx"),fname, mname, lname, suffix, gender, null, address1, address2, city, state, zip);

        SQLConnect<User> connect = new SQLConnect(User.class);
        newUser.addManagers(connect.getByPrimaryKey(Integer.parseInt(request.getParameter("manager"))));


        int newId = (Integer)connect.insert(newUser);

        response.sendRedirect(WebLink.URL_PROFILE+"?id="+newId);
        return;
    }
}