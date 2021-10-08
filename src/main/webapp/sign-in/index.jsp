<%@ page import="com.reimbursement.weblinks.WebLink" %>
<html>
<jsp:include page="/static-html/head.jsp"/>

<!-- Page Specific CSS -->
<!-- Dashboard CSS -->

<body>

<div id="page-container">

    <jsp:include page="/static-html/header.jsp"/>

        <!-- Page Specific CSS -->
        <!-- Login CSS -->
        <link rel="stylesheet" media="screen"
              href="<%out.print(WebLink.URL_CSS);%>login/login.css">
    

        <div class="login">
        <h2 class="sign-in-header"> sign in </h2>
            <form action="../login" method="post">
                <input type="text" class="text" name="username">
                <span>username</span>

                <br>
                <br>

                <input type="password" class="text" name="password">
                <span>password</span>
                <br>
                
                <button class="signin">
                Sign In
                </button>
            </form>

        </div>

    <jsp:include page="/static-html/footer.jsp"/>

</div>
</body>
</html>