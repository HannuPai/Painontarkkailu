<%-- 
    Document   : logon
    Created on : 16.12.2011, 10:10:25
    Author     : Hannu Päiveröinen
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <title>Kirjautumissivu</title>
</head>

<h2>Kirjaudu sisään:</h2>
<br><br>
<form action="j_security_check" method=post>
    <p><strong>Anna käyttäjänimesi: </strong>
    <input type="text" name="j_username" size="25">
    <p><p><strong>Anna salasanasi: </strong>
    <input type="password" size="15" name="j_password">
    <p><p>
    <input type="submit" value="Submit">
    <input type="reset" value="Reset">
</form>
</html>
