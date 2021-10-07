<%@ page import="com.reimbursement.weblinks.LoginCookie" %>
<%@ page import="com.reimbursement.webmodels.User" %>
<div id="activity-center-banner">
    <div id="welcome-message-container">
        <h1 id="welcome-message">Welcome, <%

            User user = LoginCookie.getLoginUser(request);

            if(user!=null){
                out.print(user.getFname()+" "+user.getLname());
            }

        %></h1>
    </div>
</div>


<div id="activity-center-container">


    <div id="activity-card-container">

        <div id="activity-card-list">

            <div class="activity-card" id="activity-card-view-my-profile">
                <p>View My Profile</p>
            </div>
            <div class="activity-card" id="activity-card-view-my-reimbursements">
                <p>View My Reimbursements</p>
            </div>
            <div class="activity-card" id="activity-card-submit-reimbursement-request">
                <p>Submit Reimbursement Request</p>
            </div>
            <div class="activity-card" id="activity-card-view-employees">
                <p>View Employees</p>
            </div>
            <div class="activity-card" id="activity-card-view-reimbursement-requests">
                <p>View Reimbursement Requests</p>
            </div>

        </div>
        
    </div>
    
</div>
    