<%@ page import="com.reimbursement.weblinks.WebLink" %>
<%@ page import="com.reimbursement.webmodels.User" %>
<%@ page import="java.time.DateTimeException" %>
<%@ page import="java.time.LocalDateTime" %>
<%@ page import="java.util.Enumeration" %>
<%@ page import="com.reimbursement.connection.SQLConnect" %>
<html>
<jsp:include page="/static-html/head.jsp"/>

<!-- Page Specific CSS -->
<!-- Dashboard CSS -->
<link rel="stylesheet" media="screen"
      href="<%out.print(WebLink.URL_CSS);%>profile/profile.css">
<link rel="stylesheet" media="screen and (max-width: 680px)"
      href="<%out.print(WebLink.URL_CSS);%>profile/profile-mobile.css">

<% User user = WebLink.signinRedirect(request, response);%>

<%
    Enumeration<String> args = request.getParameterNames();
    while(args.hasMoreElements()){
        String arg = args.nextElement();
        if(arg.equals("id")){
            SQLConnect<User> connect = new SQLConnect<>(User.class);
            User newUser = connect.getByPrimaryKey(Integer.parseInt(request.getParameter(arg)));
            if(newUser!=null){
                user = newUser;
            }
        }
    }
%>

<body>

<div id="page-container">

    <jsp:include page="/static-html/header.jsp"/>

    <!-- Page Specific CSS -->
    <!-- Login CSS -->
    <link rel="stylesheet" media="screen"
          href="<%out.print(WebLink.URL_CSS);%>profile/profile.css">
    <link rel="stylesheet" media="screen and (max-width: 680px)"
          href="<%out.print(WebLink.URL_CSS);%>profile/profile-mobile.css">

    <div id="profile-flexbox">

        <h1 class="profile-label">Name</h1>
        <div class="profile-content-container" id="profile-name">
            <div class="profile-content" id="fname"><%out.print(user.getFname());%></div>
            <div class="profile-content" id="mname"><%out.print(user.getMname());%></div>
            <div class="profile-content" id="lname"><%out.print(user.getLname());%></div>
            <div class="profile-content" id="suffix"><%out.print(user.getSuffix());%></div>
        </div>

        <h1 class="profile-label">Account info</h1>
        <div class="profile-content-container" id="profile-info">
            <div class="profile-content" id="username">
                <span>Username:</span><p><%out.print(user.getUsername());%></p>
            </div>
            <div class="profile-content" id="pass">
                <span>Password:</span>*******
            </div>
            <div class="profile-content" id="email">
                <span>Email:</span><p><%out.print(user.getEmail());%></p>
            </div>
            <div class="profile-content" id="date-joined">
                <span>Date:</span><%out.print(user.getDateJoinedAsString());
            %>
            </div>
        </div>

        <h1 class="profile-label">Address</h1>
        <div class="profile-content-container" id="profile-address">
            <div class="profile-content" id="address-line-1"><%out.print(user.getAddressLine1());%></div>
            <div class="profile-content" id="address-line-2"><%out.print(user.getAddressLine2());%></div>
            <div class="profile-content" id="address-city-state-zip"><%out.print(user.getAddressCity()+", "+user.getAddressState()+" "+user.getZip());%></div>
        </div>

        <div id="link-to-tickets">
            <a href="#">View Tickets</a>
        </div>


    </div>


    <jsp:include page="/static-html/footer.jsp"/>

</div>
</body>
</html>