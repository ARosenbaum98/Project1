<html>
<jsp:include page="/static-html/head.html"/>

<!-- Page Specific CSS -->
<!-- Dashboard CSS -->
<link rel="stylesheet" media="screen" href="/Project1_war_exploded/css/profile/profile.css">
<link rel="stylesheet" media="screen and (max-width: 680px)" href="/Project1_war_exploded/css/profile/profile-mobile.css">

<body>

<div id="page-container">

    <jsp:include page="/static-html/header.html"/>

    <form action="../login" method="post">
        Name:<input type="text" name="name"><br>
        Password:<input type="password" name="password"><br>
        <input type="submit" value="login">
    </form>

    <jsp:include page="/static-html/footer.html"/>

</div>
</body>
</html>