package com.reimbursement.weblinks;

import com.reimbursement.connection.SQLConnect;
import com.reimbursement.webmodels.ReimbursementRequest;
import com.reimbursement.webmodels.User;

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

        SQLConnect<ReimbursementRequest> connectRequest = new SQLConnect<>(ReimbursementRequest.class);

        response.setContentType("text/html");
        PrintWriter out=response.getWriter();

        request.getRequestDispatcher("/submit-request").include(request, response);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");

        int amount = Integer.parseInt(request.getParameter("expense-amount")) ;
        String desc =request.getParameter("expense-desc");
        LocalDateTime expenseDate = LocalDate.parse(request.getParameter("expense-date"), formatter).atStartOfDay();

        User user = WebLink.signinRedirect(request, response);
        ReimbursementRequest rRequest = new ReimbursementRequest(-1, true, null, amount, desc, expenseDate, LocalDateTime.now(), null, user);

        connectRequest.insert(rRequest);

        out.close();
    }
}
