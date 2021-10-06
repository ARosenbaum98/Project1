<%@ page import="java.util.Objects" %>
<%@ page import="com.reimbursement.webmodels.User" %>
<%@ page import="com.reimbursement.connection.SQLConnect" %>
<html>
<jsp:include page="/static-html/head.html"/>

<%
    Cookie[] cookies = null;

    SQLConnect<User> connect = new SQLConnect(User.class);

    User user;

    // Get an array of Cookies associated with the this domain
    cookies = request.getCookies();

    if( cookies != null ) {
        for (Cookie cookie : cookies) {
            System.out.println(cookie.getName());
            if(cookie.getName().equals("login_user")){
                if(Objects.equals(cookie.getValue(), "")){
                    //TODO REDIRECT
                }else{
                    user = connect.getByPrimaryKey(Integer.parseInt(cookie.getValue()));
                    out.println(user.toString());
                    System.out.println(user.toString());
                }
            }
        }
    }
%>

<!-- Page Specific CSS -->
<!-- Dashboard CSS -->
<link rel="stylesheet" media="screen" href="/Project1_war_exploded/css/dash/dash.css">
<link rel="stylesheet" media="screen and (max-width: 680px)" href="/Project1_war_exploded/css/dash/dash-mobile.css">

<body>

    <div id="page-container">

        <jsp:include page="/static-html/header.html"/>
        <jsp:include page="/static-html/dash.jsp"/>
        <jsp:include page="/static-html/footer.html"/>

    </div>
</body>
</html>