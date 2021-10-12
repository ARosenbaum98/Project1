<%@ page import="com.reimbursement.weblinks.LoginCookie" %>
<%@ page import="com.reimbursement.webmodels.User" %>
<div id="activity-center-banner">
    <div id="welcome-message-container">
        <h1 id="welcome-message">Welcome, <%

            out.print(LoginCookie.getFnameFromCookie(request)+" "+ LoginCookie.getLnameFromCookie(request));

        %></h1>
    </div>
</div>


<div id="activity-center-container">


    <div id="activity-card-container">

        <div id="activity-card-list">

            <div class="activity-card" id="activity-card-view-my-profile"><a class = "card-link" href="#" class>
                <p>View My Profile</p>
            </a></div>
            <div class="activity-card" id="activity-card-view-my-reimbursements"><a class = "card-link" href="#" class>
                <p>View My Reimbursements</p>
            </a></div>
            <div class="activity-card" id="activity-card-submit-reimbursement-request"><a class = "card-link" href="#" class>
                <p>Submit Reimbursement Request</p>
            </a></div>
            <div class="activity-card" id="activity-card-view-employees"><a class = "card-link" href="#" class>
                <p>View Employees</p>
            </a></div>
            <div class="activity-card" id="activity-card-view-reimbursement-requests"><a class = "card-link" href="#" class>
                <p>View Reimbursement Requests</p>
            </a></div>

        </div>
        
    </div>
    
</div>
    