<%@ page import="com.reimbursement.weblinks.WebLink" %>
<%@ page import="com.reimbursement.webmodels.User" %>
<%@ page import="java.time.DateTimeException" %>
<%@ page import="java.time.LocalDateTime" %>
<%@ page import="com.reimbursement.webmodels.ReimbursementRequest" %>
<%@ page import="com.reimbursement.connection.SQLConnect" %>
<%@ page import="java.util.Locale" %>
<html>
<jsp:include page="/static-html/head.jsp"/>

<!-- Page Specific CSS -->
<!-- Dashboard CSS -->
<link rel="stylesheet" media="screen"
      href="<%out.print(WebLink.URL_CSS);%>view-request-detail/view-request-detail.css">

<% User user = WebLink.signinRedirect(request, response);%>
<% SQLConnect<ReimbursementRequest> requestSQLConnect = new SQLConnect<>(ReimbursementRequest.class);%>
<% ReimbursementRequest rRequest = requestSQLConnect.getByPrimaryKey(Integer.parseInt(request.getParameter("id")));%>


<body>

<div id="page-container">


    <jsp:include page="/static-html/header.jsp"/>

    <%
        System.out.println(request.getParameter("id"));
    %>

    <div class="background">
        <h2 class="request-header">Reimbursement Request</h2>

        <div class="expense-containers">
            <span>Submitter Name</span><p><%out.print(rRequest.getUser().getFname()+" "+rRequest.getUser().getLname());%></p>
        </div>
        <div class="expense-containers">
            <span>Amount</span><p><%out.print(rRequest.getAmount());%></p>
        </div>
        <div class="expense-containers">
            <span>Description</span><p><%out.print(rRequest.getDescription());%></p>
        </div>
        <div class="expense-containers">
            <span>Date of Expense</span><p><%out.print(rRequest.getDateOfPurchase().getMonth().toString().charAt(0)+""+rRequest.getDateOfPurchase().getMonth().toString().toLowerCase(Locale.ROOT).substring(1)+" "+
                                                       rRequest.getDateOfPurchase().getDayOfMonth()+", "+
                                                       rRequest.getDateOfPurchase().getYear());%></p>
        </div>
        <div class="expense-containers">
            <span>Date submitted</span><p><%out.print(
                    rRequest.getDateOfSubmission().getMonth().toString().charAt(0)+""+rRequest.getDateOfSubmission().getMonth().toString().toLowerCase(Locale.ROOT).substring(1)+" "+
                    rRequest.getDateOfSubmission().getDayOfMonth()+", "+
                    rRequest.getDateOfSubmission().getYear());%></p>
        </div>
        <div class="expense-containers">
            <span>Approval Status</span><p><%
                if(rRequest.getIsPending()){
                    out.print("<i>Request is Pending Manager Approval</i>");
                }else{
                    if(rRequest.getIsApproved()){
                        out.print("Approved ");
                    }else{
                        out.print("Denied ");
                    }
                    out.print("("+rRequest.getDateOfApproval().getMonthValue()+"-"+rRequest.getDateOfApproval().getDayOfMonth()+"-"+rRequest.getDateOfApproval().getYear()+")");
                }


            %></p>
        </div>
    </div>


    <jsp:include page="/static-html/footer.jsp"/>

</div>
</body>
</html>