<%-- 
    Document   : lista
    Created on : 18.11.2011, 19:17:10
    Author     : Hannu Päiveröinen
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<link href="default.css" rel="stylesheet" type="text/css" title="Tyylipohja www-selaimelle" />
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Painontarkkailu</title>
    </head>
    <body>
        
        <a href="../Painontarkkailu">Etusivulle</a>
        <!-- testataan onko attribuutti "kayttajat" tyhjä //-->
        <c:if test="${not empty lista}">
            <h2>Uusi harjoite</h2>
            <!-- jos kayttajat ei ole tyhjä, annetaan mahdollisuus luoda uusia harjotteita //-->
            <form name="uusiHarjoite"
                  action="${pageContext.request.contextPath}/LisaaHarjoite"
                  method="post">
                Kayttaja: <!-- harjoitteelle pitää valita myös käyttäjä //-->
                <select name="kayttajaId">
                    <c:forEach var="kayttaja" items="${lista}">
                        <option value="${kayttaja.id}">${kayttaja.nimi}</option>
                    </c:forEach>
                </select><br/>
                Laji: <!-- harjoitteelle pitää valita myös laji //-->
                <select name="lajiId">
                    <c:forEach var="laji" items="${listaLaji}">
                        <option value="${laji.id}">${laji.nimi}</option>
                    </c:forEach>
                </select><br/>
                Kesto : <input type="text" value="${kestoApu}" name="kestoMinuuteissa"/> minuuttia. <br/>
                Päiväys (pp/kk/vvvv): <input type="text" value="${paivays}" name="paivays"/> <br/>
                Keskimääräinen syke: <input type="text" value="${sykeApu}" name="syke"/> (0 jos ei tiedossa) <br/>
                Kommentti: <input type="text" value="${kommenttiApu}"  name="kommentti"/> <br/>
                <input type="submit" value="Lähetä"/>
            </form>     
                <p>${varoitus}</p> 
        </c:if>
        
           
        
            <h2>Uusi laji</h2>
            <form name="uusiLaji"
                  action="${pageContext.request.contextPath}/LisaaLaji"
                  method="post">
                Nimi: <input type="text" value="${nimiApu}" name="nimi" /> <br/>
                Kulutus: <input type="text" value="${kulutusApu}" name="kulutus" /> kcal/h<br/>
                <input type="submit" name="Lähetä"/>
         </form>
                <p>${varoitus}</p> 
    </body>
</html>