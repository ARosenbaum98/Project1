<%@ page import="com.reimbursement.weblinks.WebLink" %>
<%@ page import="com.reimbursement.webmodels.User" %>
<%@ page import="java.time.DateTimeException" %>
<%@ page import="java.time.LocalDateTime" %>
<%@ page import="com.reimbursement.webmodels.ReimbursementRequest" %>
<%@ page import="com.reimbursement.connection.SQLConnect" %>
<%@ page import="java.util.*" %>
<html>
<jsp:include page="/static-html/head.jsp"/>

<!-- Page Specific CSS -->
<!-- View Requests CSS -->
<link rel="stylesheet" media="screen"
      href="<%out.print(WebLink.URL_CSS);%>view-request/view-request.css">


<% User user = WebLink.signinRedirect(request, response);%>
<% if(user==null) throw new javax.servlet.jsp.SkipPageException();%>
<% SQLConnect<ReimbursementRequest> requestSQLConnect = new SQLConnect<>(ReimbursementRequest.class);%>


<body>

<div id="page-container">


    <jsp:include page="/static-html/header.jsp"/>



    <div class="background">
        <h2 id="request-list-header">Reimbursement Requests</h2>

        <%
            String[] cols = new String[12];
            Object[] vals = new Object[12];

            Enumeration<String> args = request.getParameterNames();
            while(args.hasMoreElements()){
                String arg = args.nextElement();
                if(arg.equals("id")){
                    cols[0]="user_id";
                    vals[0]=Integer.parseInt(request.getParameter(arg));
                }else if(arg.equals("man_id")){
                    SQLConnect<User> userConnect = new SQLConnect<>(User.class);
                    int i = 0;
                    for(User employee : user.getSupervisees()){
                        userConnect.getByPrimaryKey(employee.getId());

                        cols[i]="user_id";
                        vals[i]=employee.getId();
                        i++;
                    }
                }
            }


            List<ReimbursementRequest> requests = requestSQLConnect.get(cols, vals);


        %>

        <table id = "requests-table">
            <tr>
                <th>Name</th>
                <th>Amount</th>
                <th>Date of purchase</th>
                <th>Date of request</th>
                <th>Status</th>
            </tr>
            <%
                for(ReimbursementRequest reqst : requests){
                    out.print("<tr>\n");
                    out.print("<td>"+reqst.getUser().getFname()+" "+reqst.getUser().getLname()+"</td>");
                    out.print("<td>$"+reqst.getAmount()+"</td>");
                    out.print("<td>"+"("+reqst.getDateOfPurchase().getMonthValue()+"-"+reqst.getDateOfPurchase().getDayOfMonth()+"-"+reqst.getDateOfPurchase().getYear()+")"+"</td>");
                    out.print("<td>"+"("+reqst.getDateOfSubmission().getMonthValue()+"-"+reqst.getDateOfSubmission().getDayOfMonth()+"-"+reqst.getDateOfSubmission().getYear()+")"+"</td>");
                    out.print("<td>"+((reqst.getIsPending())?"Pending":(((reqst.getIsApproved())?
                            "Approved":"Denied")+
                            ((reqst.getDateOfApproval()==null)?"": " ("
                            +reqst.getDateOfApproval().getMonthValue()))+"-"+reqst.getDateOfApproval().getDayOfMonth()+"-"+reqst.getDateOfApproval().getYear()+")</td>"));

                    out.print("<td><div id='link-to-tickets'>");
                    out.print("<a href='"+WebLink.URL_HOME+"view-request-detail/?id="+reqst.getId()+"'>");
                    out.print("View Request");
                    out.print("</a></div></td>");
                    out.print("</tr>\n");



                }

            %>
        </table>

    </div>


    <jsp:include page="/static-html/footer.jsp"/>

</div>
</body>
</html>