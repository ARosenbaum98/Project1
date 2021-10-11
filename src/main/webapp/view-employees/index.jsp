<%@ page import="com.reimbursement.weblinks.WebLink" %>
<%@ page import="com.reimbursement.webmodels.User" %>
<%@ page import="java.time.DateTimeException" %>
<%@ page import="java.time.LocalDateTime" %>
<%@ page import="com.reimbursement.webmodels.ReimbursementRequest" %>
<%@ page import="com.reimbursement.connection.SQLConnect" %>
<%@ page import="java.util.Locale" %>
<%@ page import="java.util.List" %>
<html>
<jsp:include page="/static-html/head.jsp"/>

<!-- Page Specific CSS -->
<link rel="stylesheet" media="screen"
      href="<%out.print(WebLink.URL_CSS);%>view-employees/view-employees.css">

<% User user = WebLink.signinRedirect(request, response);%>
<% SQLConnect<User> userSQLConnect = new SQLConnect<>(User.class);%>
<%

    String[] cols = new String[]{};
    Object[] vals = new Object[]{};
    List<User> displayUsers = userSQLConnect.get(cols, vals);
%>


<body>

<div id="page-container">


    <jsp:include page="/static-html/header.jsp"/>



    <div class="background">

        <h2>Seach Employees</h2>
        <form id="search-employees-form" action="">
            <table id="search">
                <tr>
                    <th><label for="fname">First Name</label></th>
                    <th><label for="lname">Last Name</label></th>
                    <th><label for="email">Email</label></th>
                    <th><label for="manager-name">Manager Last Name</label></th>
                </tr>
                <tr>
                    <td><input id ="fname" type="text"></td>
                    <td><input id ="lname" type="text"></td>
                    <td><input id ="email" type="text"></td>
                    <td><input id ="manager-name" type="text"></td>
                </tr>
            </table>
        </form>
        <h2 id="request-list-header">Employees List</h2>

        <table id = "requests-table">
            <tr>
                <th>First Name</th>
                <th>Last Name</th>
                <th>Email</th>
                <th>Manager(s)</th>
                <th>Active Requests</th>
            </tr>

            <%
                for(User rowUser : displayUsers){
                    out.print("<tr>");
                    out.print("<td>"+rowUser.getFname()+"</td>");
                    out.print("<td>"+rowUser.getLname()+"</td>");
                    out.print("<td>"+rowUser.getEmail()+"</td>");

                    out.print("<td>");
                        int i=1;
                        if(rowUser.getManagers()!=null) {
                            for (User manager : rowUser.getManagers()) {
                                out.print(manager.getFname() + " " + manager.getLname());
                                if (i < rowUser.getManagers().size()) {
                                    out.print("<br>");
                                }
                            }
                        }else{
                            out.print("N/A");
                        }
                    out.print("</td>");

                    out.print("<td>{Number}</td>");
                    out.print("</tr>");
                }

            %>

        </table>

    </div>


    <jsp:include page="/static-html/footer.jsp"/>

</div>
</body>
</html>