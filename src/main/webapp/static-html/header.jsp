<%@ page import="com.reimbursement.weblinks.WebLink" %>
<header id="site-banner">
    <div id="banner-logo">
        <img src="<%out.print(WebLink.URL_SITE_IMGS);%>favcon.old.png" height = "50px" alt="logo">
        <div id="banner-company-name-slogan">
            <h1 id="banner-company-name">NoBody Enterprise</h1>
            <h2 id="banner-company-slogan">We don't exist, we won't exist</h2>
        </div>
    </div>

    <nav id="banner-nav-button-container">

        <ul id="banner-nav-list">
            <li class="navbar">
                <div class="navbar-button">
                    <a class="navbar-button-text" href="<%out.print(WebLink.URL_PROFILE);%>">
                        My Profile
                    </a>
                </div>
            </li>
            <li class="navbar">
                <div class="navbar-button">
                    <a class="navbar-button-text" href="<%out.print(WebLink.URL_HOME);%>">
                        Dashboard
                    </a>
                </div>
            </li>
            <li class="navbar">
                <div class="navbar-button">
                    <a class="navbar-button-text" href="<%out.print(WebLink.URL_LOGOUT);%>">
                        Logout
                    </a>
                </div>
            </li>
        </ul>
    </nav>
</header>