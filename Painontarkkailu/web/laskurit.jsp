<%-- 
    Document   : laskurit
    Created on : 4.12.2011, 15:15:45
    Author     : Hannu Päiveröinen
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<link href="default.css" rel="stylesheet" type="text/css" title="Tyylipohja www-selaimelle" />
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Kalori- sekä kulutuslaskurit</title>
    </head>
    <body>
        <h1>Kalori- sekä kulutuslaskurit</h1>
    </body>

    <h2>Laske kulutus</h2>
    <form name="kaloriLaskuri"
          action="${pageContext.request.contextPath}/LaskeKulutus"
          method="post">
        Ikä: <input type="text" name="ika" /> <br/>
        <input type="radio" name="sex" value="mies" /> Mies
        <input type="radio" name="sex" value="nainen" /> Nainen<br />
        Sukupuoli: <input type="text" name="sukupuoli" /> <br/>
        Pituus: <input type="text" name="pituus" /> <br/>
        Paino: <input type="text" name="paino" /> <br/>
        Laji:
        <select name="lajiId">
            <c:forEach var="laji" items="${listaLaji}">
                <option value="${laji.id}">${laji.nimi}</option>
            </c:forEach>
        </select><br/>
        Kesto (minuuteissa): <input type="text" name="kestoMinuuteissa"/> <br/>
        <input type="submit" name="Laske"/>
        Kulutuksesi: <input type="text" value="${kulutus}"  name="kulutuksesi"/> <br/>
    </form>

    <a href="../Painontarkkailu">Painontarkkailu</a>
</html>
