<p>
  [<a href="index.xhtml">Home</a>]
  [<a href="lista.jsp">One</a>]
  [<a href="secure_page2.jsp">Two</a>]
  [<a href="secure_page3.jsp">Three</a>]
  <% if (request.getUserPrincipal() != null) { %>
    [<a href="logout.jsp">Logout</a>]
    <br/>
    Welcome <strong><%=request.getUserPrincipal().getName()%></strong>!
  <% } %>
</p>