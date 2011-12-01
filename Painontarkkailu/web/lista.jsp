<%-- 
    Document   : lista
    Created on : 18.11.2011, 19:17:10
    Author     : Hannu Päiveröinen
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Painontarkkailu</title>
    </head>
    <body>
        <h1>Hello ${viesti}!</h1>
        <a href="../Painontarkkailu">Painontarkkailu</a>
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
                Kesto (minuuteissa): <input type="text" name="kestoMinuuteissa"/> <br/>
                Päiväys (pp/kk/vvvv): <input type="text" name="paivays"/> <br/>
                Syke: <input type="text" name="syke"/> <br/>
                Kommentti: <input type="text" name="kommentti"/> <br/>
                <input type="submit" value="Lähetä"/>
            </form>      
        </c:if>
        
        <c:forEach var="kayttaja" items="${lista}" >
            ${kayttaja.nimi} <br/>
        </c:forEach>
            
            <h2>Uusi käyttäjä</h2>
            <form name="uusiKayttaja"
                  action="${pageContext.request.contextPath}/LisaaKayttaja"
                  method="post">
                Käyttäjänimi: <input type="text" name="kayttajanimi" /> <br/>
                Nimi: <input type="text" name="nimi" /> <br/>
                Ikä: <input type="text" name="ika" /> <br/>
                Sukupuoli: <input type="text" name="sukupuoli" /> <br/>
                Pituus: <input type="text" name="pituus" /> <br/>
                Paino: <input type="text" name="paino" /> <br/>
                <input type="submit" name="Lähetä"/>
            </form>
        <c:forEach var="laji" items="${listaLaji}" >
            ${laji.nimi} <br/>
        </c:forEach>
            
            <h2>Uusi laji</h2>
            <form name="uusiLaji"
                  action="${pageContext.request.contextPath}/LisaaLaji"
                  method="post">
                Nimi: <input type="text" name="nimi" /> <br/>
                Kulutus: <input type="text" name="kulutus" /> <br/>
                <input type="submit" name="Lähetä"/>
         </form>
    </body>
</html>
