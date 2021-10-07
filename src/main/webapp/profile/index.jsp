<%@ page import="com.reimbursement.weblinks.WebLink" %>
<html>
<jsp:include page="/static-html/head.jsp"/>

<!-- Page Specific CSS -->
<!-- Dashboard CSS -->
<link rel="stylesheet" media="screen"
      href="<%out.print(WebLink.URL_CSS);%>profile/profile.css">
<link rel="stylesheet" media="screen and (max-width: 680px)"
      href="<%out.print(WebLink.URL_CSS);%>profile/profile-mobile.css">

<body>

<div id="page-container">

    <jsp:include page="/static-html/header.jsp"/>
    <jsp:include page="/static-html/footer.jsp"/>

</div>
</body>
</html>