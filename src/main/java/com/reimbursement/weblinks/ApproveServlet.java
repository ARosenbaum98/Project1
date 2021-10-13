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
        name = "ApproveRequest",
        value = "/approverequest"
)
public class ApproveServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        SQLConnect<ReimbursementRequest> connectRequest = new SQLConnect<>(ReimbursementRequest.class);

        response.setContentType("text/html");

        int id = Integer.parseInt(request.getParameter("id"));
        System.out.println(request.getParameter("approved"));
        boolean approved = Boolean.parseBoolean(request.getParameter("approved"));
        ReimbursementRequest rRequest = connectRequest.getByPrimaryKey(id);

        System.out.print("Doing post for id=");
        System.out.println(id);

        rRequest.setApproved(approved);
        rRequest.setIsPending(false);
        rRequest.setDateOfApproval(LocalDateTime.now());

        connectRequest.update(rRequest);

        response.sendRedirect(WebLink.URL_VIEW_REQUEST_DETAIL+"?id="+id);
        return;

    }
}