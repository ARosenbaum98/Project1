<html>
<jsp:include page="/static-html/head.jsp"/>

<!-- Page Specific CSS -->
<!-- Dashboard CSS -->

<body>

<div id="page-container">

    <jsp:include page="/static-html/header.jsp"/>

    <form action="../login" method="post">
        Name:<input type="text" name="name"><br>
        Password:<input type="password" name="password"><br>
        <input type="submit" value="login">
    </form>

    <jsp:include page="/static-html/footer.jsp"/>

</div>
</body>
</html>