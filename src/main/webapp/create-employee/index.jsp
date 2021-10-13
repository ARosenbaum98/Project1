<%@ page import="java.util.Objects" %>
<%@ page import="com.reimbursement.webmodels.User" %>
<%@ page import="com.reimbursement.connection.SQLConnect" %>
<%@ page import="com.reimbursement.weblinks.WebLink" %>
<html>
<jsp:include page="/static-html/head.jsp"/>
<!-- Page Specific CSS -->
<!-- Dashboard CSS -->
<link rel="stylesheet" media="screen" href="<%out.print(WebLink.URL_CSS);%>dash/dash.css">
<link rel="stylesheet" media="screen and (max-width: 680px)" href="<%out.print(WebLink.URL_CSS);%>dash/dash-mobile.css">


<% User user = WebLink.signinRedirect(request, response); %>
<% if(user==null) throw new javax.servlet.jsp.SkipPageException();%>
<body>

<div id="page-container">

    <jsp:include page="/static-html/header.jsp"/>



    <link rel="stylesheet" media="screen"
          href="../css/create-user/create-user.css">

    <div class="background">
        <h2 class="submit-header">Create New Employee</h2>
        <form action="../createemployee"  method="post">

            <div id="create-user-form">


                <div id="user-account-info">
                    <div class="user-containers">

                        <span>Employee Email</span>
                        <input type="email" name="email" required>
                    </div>
                    <div class="user-containers">

                        <span>Create Username</span>
                        <input type="text" name="username" required>
                    </div>
                    <div class="user-containers">

                        <span>Create Password</span>
                        <input type="text" name="password" required>
                    </div>
                </div>


                <div id="user-names">
                    <div class="user-containers">
                        <span>Employee First Name</span>
                        <input type="text" name="fname" required>
                    </div>
                    <div class="user-containers">
                        <span>Employee Middle Name</span>
                        <input type="text" name="mname">
                    </div>
                    <div class="user-containers">
                        <span>Employee Last Name</span>
                        <input type="text" name="lname" required>
                    </div>
                    <div class="user-containers">
                        <span>Gender</span>
                        <select name="gender" required>
                            <option value="">Select Gender</option>
                            <option value="F">Female</option>
                            <option value="M">Male</option>
                            <option value="N">Non-Binary/Other</option>
                        </select>
                    </div>
                </div>

                <div class="user-containers">
                    <span>Address Line 1</span>
                    <input type="text" name="address-line-1" required>
                </div>
                <div class="user-containers">
                    <span>Address Line 2</span>
                    <input type="text" name="address-line-2">
                </div>
                <div class="user-containers">
                    <span>Address City</span>
                    <input type="text" name="address-city" required>
                </div>

                <span>State</span>
                <select name="address-state" id="state" required>
                    <option value="" selected="selected">Select a State</option>
                    <option value="AL">Alabama</option>
                    <option value="AK">Alaska</option>
                    <option value="AZ">Arizona</option>
                    <option value="AR">Arkansas</option>
                    <option value="CA">California</option>
                    <option value="CO">Colorado</option>
                    <option value="CT">Connecticut</option>
                    <option value="DE">Delaware</option>
                    <option value="DC">District Of Columbia</option>
                    <option value="FL">Florida</option>
                    <option value="GA">Georgia</option>
                    <option value="HI">Hawaii</option>
                    <option value="ID">Idaho</option>
                    <option value="IL">Illinois</option>
                    <option value="IN">Indiana</option>
                    <option value="IA">Iowa</option>
                    <option value="KS">Kansas</option>
                    <option value="KY">Kentucky</option>
                    <option value="LA">Louisiana</option>
                    <option value="ME">Maine</option>
                    <option value="MD">Maryland</option>
                    <option value="MA">Massachusetts</option>
                    <option value="MI">Michigan</option>
                    <option value="MN">Minnesota</option>
                    <option value="MS">Mississippi</option>
                    <option value="MO">Missouri</option>
                    <option value="MT">Montana</option>
                    <option value="NE">Nebraska</option>
                    <option value="NV">Nevada</option>
                    <option value="NH">New Hampshire</option>
                    <option value="NJ">New Jersey</option>
                    <option value="NM">New Mexico</option>
                    <option value="NY">New York</option>
                    <option value="NC">North Carolina</option>
                    <option value="ND">North Dakota</option>
                    <option value="OH">Ohio</option>
                    <option value="OK">Oklahoma</option>
                    <option value="OR">Oregon</option>
                    <option value="PA">Pennsylvania</option>
                    <option value="RI">Rhode Island</option>
                    <option value="SC">South Carolina</option>
                    <option value="SD">South Dakota</option>
                    <option value="TN">Tennessee</option>
                    <option value="TX">Texas</option>
                    <option value="UT">Utah</option>
                    <option value="VT">Vermont</option>
                    <option value="VA">Virginia</option>
                    <option value="WA">Washington</option>
                    <option value="WV">West Virginia</option>
                    <option value="WI">Wisconsin</option>
                    <option value="WY">Wyoming</option>
                </select>
                <div class="user-containers">
                    <span>Zip Code</span>
                    <input type="text" name="address-zip">
                </div>

                <button class="submit-user">
                    submit
                </button>
            </div>
        </form>

    </div>



    <jsp:include page="/static-html/footer.jsp"/>

</div>
</body>
</html>