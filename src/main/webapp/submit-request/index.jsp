<%@ page import="com.reimbursement.weblinks.WebLink" %>
<%@ page import="com.reimbursement.webmodels.User" %>
<%@ page import="java.time.DateTimeException" %>
<%@ page import="java.time.LocalDateTime" %>
<html>
<jsp:include page="/static-html/head.jsp"/>

<!-- Page Specific CSS -->
<!-- Dashboard CSS -->
<link rel="stylesheet" media="screen"
      href="<%out.print(WebLink.URL_CSS);%>submit-request/submit-request.css">

<% User user = WebLink.signinRedirect(request, response);%>


<body>

<div id="page-container">

    <jsp:include page="/static-html/header.jsp"/>

    <div class="background">
        <h2 class="submit-header">Submit Reimbursement Request</h2>
        <form action="../submit-request/" method="post">

            <div class="expense-containers">
                <span>Amount</span>
                <input type="number" name="expense-amount" id="reimbursement-amount">
            </div>
            <div class="expense-containers">
                <span>Description</span><br>
                <textarea name="expense-desc" id="reimbursement-desc" rows="3"></textarea>
            </div>
            <div class="expense-containers">
                <span>Date of Expense</span>
                <input type="date" name="expense-date" id="reimbursement-date">
            </div>

            <button class="submit-request">
                submit
            </button>
        </form>

    </div>


    <jsp:include page="/static-html/footer.jsp"/>

</div>
</body>
</html>