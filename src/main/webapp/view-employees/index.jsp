<%@ page import="com.reimbursement.weblinks.WebLink" %>
<%@ page import="com.reimbursement.webmodels.User" %>
<%@ page import="java.time.DateTimeException" %>
<%@ page import="java.time.LocalDateTime" %>
<%@ page import="com.reimbursement.webmodels.ReimbursementRequest" %>
<%@ page import="com.reimbursement.connection.SQLConnect" %>
<%@ page import="java.util.Locale" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.Enumeration" %>
<%@ page import="java.util.ArrayList" %>
<html>
<jsp:include page="/static-html/head.jsp"/>

<!-- Page Specific CSS -->
<link rel="stylesheet" media="screen"
      href="<%out.print(WebLink.URL_CSS);%>view-employees/view-employees.css">

<% User user = WebLink.signinRedirect(request, response);%>
<% SQLConnect<User> userSQLConnect = new SQLConnect<>(User.class);%>
<%
    Enumeration<String> args = request.getParameterNames();

    List<String> userCols = new ArrayList<>();
    List<Object> userVals = new ArrayList<>();

    List<String> managerCols = new ArrayList<>();
    List<Object> managerVals = new ArrayList<>();

    l1: while(args.hasMoreElements()){
        String arg = args.nextElement();
        String val = request.getParameter(arg);
        System.out.println(arg+" = "+val);

        if(!val.equals("")) {

            switch (arg) {
                case "man_id":
                    managerCols = new ArrayList<>();
                    managerCols.add("user_id");
                    managerVals = new ArrayList<>();
                    managerVals.add(val);
                    break l1;
                case "empl_id":
                    userCols = new ArrayList<>();
                    userVals = new ArrayList<>();
                    userCols.add("user_id");
                    userVals.add(val);
                    break l1;
                case "email":
                    userCols = new ArrayList<>();
                    userVals = new ArrayList<>();
                    userCols.add("email");
                    userVals.add(val);
                    break l1;
                case "fname":
                    userCols.add("fname");
                    userVals.add(val);
                    break;
                case "lname":
                    userCols.add("lname");
                    userVals.add(val);
                    break;
                case "man_lname":
                    managerCols.add("lname");
                    managerVals.add(val);
                    break;
            }
        }
    }

    List<User> displayUsers = userSQLConnect.get( userCols.toArray(new String[0]), userVals.toArray());
    List<User> managersList;
    if(managerCols.size()>0){
        managersList = userSQLConnect.get(managerCols.toArray(new String[0]), managerVals.toArray());
        int i = 0;
        while(i<displayUsers.size()){
            User employee = displayUsers.get(i);
            if(!employee.isManager()){
                int j = 0;
                while(j<managersList.size()) {
                    User manager = managersList.get(j);
                    if (!employee.getManagers().contains(manager)) {
                        displayUsers.remove(employee);
                        i--;
                    }

                    j++;
                }
            }else{
                displayUsers.remove(employee);
                i--;
            }
            i++;
        }
    }

%>


<body>

<div id="page-container">


    <jsp:include page="/static-html/header.jsp"/>



    <div class="background">

        <h2>Seach Employees</h2>
        <form id="search-employees-form" action="<%out.print(WebLink.URL_HOME);%>view-employees" method="get">
            <table id="search">
                <tr>
                    <th><label for="fname">First Name</label></th>
                    <th><label for="lname">Last Name</label></th>
                    <th><label for="email">Email</label></th>
                    <th><label for="man_lname">Manager Last Name</label></th>
                </tr>
                <tr>
                    <td><input id ="fname" name ="fname" type="text"></td>
                    <td><input id ="lname" name ="lname" type="text"></td>
                    <td><input id ="email" name ="email" type="text"></td>
                    <td><input id ="man_lname" name ="man_lname" type="text"></td>
                </tr>
            </table>
            <button type="submit">Submit</button>
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
                    out.print("<td><a href='"+WebLink.URL_PROFILE+"?id="+rowUser.getId()+"'>"+rowUser.getFname()+"</a></td>");
                    out.print("<td><a href='"+WebLink.URL_PROFILE+"?id="+rowUser.getId()+"'>"+rowUser.getLname()+"</a></td>");
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