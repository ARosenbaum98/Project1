<!DOCTYPE html>
<html lang="en">

<%@ include file="head.html">


<body>


    <div id="page-container">
        <header id="site-banner">

            <div id="banner-logo">
                <img src="imgs/favcon.png" height = "50px" alt="logo">
                <div id="banner-company-name-slogan">
                    <h1 id="banner-company-name">NoBody Enterprise</h1>
                    <h2 id="banner-company-slogan">We don't exist, we won't exist</h2>
                </div>
            </div>

            <nav id="banner-nav-button-container">

                    <ul id="banner-nav-list">
                        <li class="navbar">
                            <div class="navbar-button">
                                <p class="navbar-button-text">
                                    My Profile
                                </p>
                            </div>
                        </li>
                        <li class="navbar">
                            <div class="navbar-button">
                                <p class="navbar-button-text">
                                    Dashboard
                                </p>
                            </div>
                        </li>
                        <li class="navbar">
                            <div class="navbar-button">
                                <p class="navbar-button-text">
                                    Logout
                                </p>
                            </div>
                        </li>
                    </ul>
            </nav>

        </header>

        
        <div id="activity-center-banner">
            <div id="welcome-message-container">
                <h1 id="welcome-message">Welcome, Asher Rosenbaum</h1>
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
            
        <footer id="page-end-bar">

            <p>Copyright 2021 NoBody Enterprise</p>

        </footer>

    </div>
    
</body>


</html>