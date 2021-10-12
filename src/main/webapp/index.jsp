<%@ page import="java.util.Objects" %>
<%@ page import="com.reimbursement.webmodels.User" %>
<%@ page import="com.reimbursement.connection.SQLConnect" %>
<%@ page import="com.reimbursement.weblinks.WebLink" %>
<html>
<jsp:include page="/static-html/head.jsp"/>
<!-- Page Specific CSS -->
<!-- Dashboard CSS -->
<link rel="stylesheet" media="screen" href="<%out.print(WebLink.URL_CSS);%>dash/dash.css">
<link rel="stylesheet" media="screen and (max-width: 680px)" href="<%out.print(WebLink.URL_CSS);%>dash/dash-mobile.css">


<% User user = WebLink.signinRedirect(request, response); %>
<% if(user==null) throw new javax.servlet.jsp.SkipPageException();%>
<body>

    <div id="page-container">

        <jsp:include page="/static-html/header.jsp"/>


        <div id="activity-center-banner">
            <div id="welcome-message-container">
                <h1 id="welcome-message">Welcome, <%

                    out.print(user.getFname()+" "+ user.getLname());

                %></h1>
            </div>
        </div>


        <div id="activity-center-container">


            <div id="activity-card-container">

                <div id="activity-card-list">

                    <div class="activity-card" id="activity-card-view-my-profile"><a class = "card-link" href="<%out.print(WebLink.URL_PROFILE);%>?id=<%out.print(user.getId());%>">
                        <p>View My Profile</p>
                    </a></div>
                    <div <%if(user.isManager()) out.print("style='display: none'");%>  class="activity-card" id="activity-card-view-my-reimbursements"><a class = "card-link" href="<%out.print(WebLink.URL_VIEW_REQUEST+"?id="+user.getId());%>">
                        <p>View My Reimbursements</p>
                    </a></div>
                    <div <%if(user.isManager()) out.print("style='display: none'");%> class="activity-card" id="activity-card-submit-reimbursement-request"><a class = "card-link" href="<%out.print(WebLink.URL_SUBMIT_REQUEST);%>">
                        <p>Submit Reimbursement Request</p>
                    </a></div>
                    <div <%if(!user.isManager()) out.print("style='display: none'");%> class="activity-card" id="activity-card-view-employees"><a class = "card-link" href="<%out.print(WebLink.URL_VIEW_EMPLOYEES+"?man_id="+user.getId());%>">
                        <p>View Employees</p>
                    </a></div>
                    <div <%if(!user.isManager()) out.print("style='display: none'");%> class="activity-card" id="activity-card-view-reimbursement-requests"><a class = "card-link" href="<%if(user.isManager()) out.print(WebLink.URL_VIEW_REQUEST+"?man_id="+user.getId()); else out.print(WebLink.URL_VIEW_REQUEST+"?man_id="+user.getId());%>">
                        <p>View Reimbursement Requests</p>
                    </a></div>

                </div>

            </div>

        </div>



        <jsp:include page="/static-html/footer.jsp"/>

    </div>
</body>
</html>