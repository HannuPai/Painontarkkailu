<%-- 
    Document   : logonError
    Created on : 16.12.2011, 10:18:35
    Author     : Hannu Päiveröinen
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <title>Kirjautuminen epäonnistui</title>
</head>
<body>
    <c:url var="url" value="/index.jsp"/>
    <h2>Käyttäjänimi tai salasana väärin.</h2>

    <p>Syötä käyttäjänimi tai salasana, jotka ovat tämän ohjelman rekisterin tiedossa.
        For this application, this means a user that has been created in the 
    <code>file</code> realm and has been assigned to the <em>group</em> of 
    <code>user</code>.  Click here to <a href="${url}">Try Again</a></p>
</body>
</html>
