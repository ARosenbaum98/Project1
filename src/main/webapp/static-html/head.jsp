<%@ page import="java.util.Objects" %>
<%@ page import="com.reimbursement.webmodels.User" %>
<%@ page import="com.reimbursement.connection.SQLConnect" %>
<%@ page import = "java.io.*,java.util.*" %>
<%@ page import="com.reimbursement.weblinks.WebLink" %>

<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">


    <link rel="icon" href="<%out.println(WebLink.URL_SITE_IMGS);%>favcon.png">

    <!-- Banner CSS -->
    <link rel="stylesheet" media="screen"
          href="<%out.println(WebLink.URL_CSS);%>site-wide/banner.css">
    <link rel="stylesheet" media="screen and (max-width: 680px)"
          href="<%out.println(WebLink.URL_CSS);%>site-wide/banner-mobile.css">

    <!-- Main Content CSS -->
    <link rel="stylesheet" media="screen"
          href="<%out.println(WebLink.URL_CSS);%>site-wide/main.css">
    
    <!-- Footer CSS -->
    <link rel="stylesheet"
          media="screen" href="<%out.println(WebLink.URL_CSS);%>site-wide/footer.css">

    <title>Reimbursement App</title>

</head>
