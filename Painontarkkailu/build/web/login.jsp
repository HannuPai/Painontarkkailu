<html>
  <head>
    <title>Login Page Secure Application</title>
  </head>
  <body>
    <h1>Login Page Secure Application</h1>
    <% 
      String error = request.getParameter("error");
      if (error != null) { 
    %> 
        <p style="color: red">Error: <%=error%>.</p>
    <% 
      } 
    %>
    <form method="post" action="j_security_check">
      <table cellspacing="3">
        <tr>
          <th align="right">Username:</th>
          <td align="left"><input type="text" name="j_username"/></td>
        </tr>
        <tr>
          <th align="right">Password:</th>
          <td align="left"><input type="password" name="j_password"/></td>
        </tr>
        <tr>
          <th align="right">&nbsp;</th>
          <td align="left"><input type="submit" value="Log In"/></td>
        </tr>
      </table>
    </form>
  </body>
</html>
