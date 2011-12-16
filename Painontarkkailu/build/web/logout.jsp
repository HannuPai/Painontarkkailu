<% session.invalidate(); %>
<html>
  <head>
    <title>Logout</title>
  </head>
  <body>
    <h1>Logout</h1>
    <p>You've successfully logged out.</p>
    <p>
      You can navigate back to <a href="index.jsp">home</a>, 
      but you'll need to login again if you wish to visit:
      <ul>
        <li><a href="secure_page1.jsp">Secure Page One</a></li>
        <li><a href="secure_page2.jsp">Secure Page Two</a></li>
        <li><a href="secure_page3.jsp">Secure Page Three</a></li>
      </ul>
    </p>
  </body>  
</html>