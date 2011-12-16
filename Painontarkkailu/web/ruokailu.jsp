<%-- 
    Document   : ruoat
    Created on : 3.12.2011, 15:51:20
    Author     : Hannu Päiveröinen
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<link href="default.css" rel="stylesheet" type="text/css" title="Tyylipohja www-selaimelle" />
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Ruokailu</title>
    </head>
    <body>
        <a href="../Painontarkkailu">Etusivulle</a>
        <!-- testataan onko attribuutti "kayttajat" tyhjä //-->
        <c:if test="${not empty lista}">
            <h2>Uusi ateria</h2>
            <!-- jos kayttajat ei ole tyhjä, annetaan mahdollisuus luoda uusia ateriatapahtumia //-->
            <form name="uusiAteria"
                  action="${pageContext.request.contextPath}/LisaaAteria"
                  method="post">
                Kayttaja: <!-- harjoitteelle pitää valita myös käyttäjä //-->
                <select name="kayttajaId">
                    <c:forEach var="kayttaja" items="${lista}">
                        <option value="${kayttaja.id}">${kayttaja.nimi}</option>
                    </c:forEach>
                </select><br/>
                Ruoka:
                <select name="ruokaId">
                    <c:forEach var="ruoka" items="${listaRuoka}">
                        <option value="${ruoka.id}">${ruoka.nimi}</option>
                    </c:forEach>
                </select><br/>
                Päiväys (pp/kk/vvvv): <input type="text" value=${paivays} name="paivays"/> <br/>
                Määrä : <input type="text" name="maara"/> <br/>
                <input type="submit" value="Lähetä"/>
            </form>      
        </c:if>

            <script type="text/javascript">
                <!--//
                function addElements() {
                    var ni = document.getElementById('myDiv');
                    var numi = document.getElementById('theValue');
                    var num = (document.getElementById('theValue').value -1)+ 2;
                    numi.value = num;
                    var newdiv = document.createElement('div');
                    var divIdName = 'my'+num+'Div';
                    newdiv.setAttribute('id',divIdName);
                    newdiv.innerHTML = 'Määrä: ';
                    var newlista = document.getElementById('lista');
                    var uusilista = newlista.cloneNode(true);
                    var newmaara = document.createElement('input');
                    //var sata = '*100g -->';
                    newdiv.appendChild(newmaara);
                    newdiv.appendChild(uusilista);
                    //newdiv.appendChild(sata);
                    ni.appendChild(newdiv) 
                    //-->
            </script>

            <h2>Uusi ruoka</h2>
       
        <form name="uusiRuoka"
              action="${pageContext.request.contextPath}/LisaaRuoka"
              method="post">
            Nimi: <input type="text" name="nimi" value="${ruoannimiApu}" id="nimi"/> <br/>
            Määrä: <input type="text" name="maara" value="${maaraApu}" id="maara"/> *100g -->
            Raaka-aine:
            <select name="raakaaineId" id="lista">
                <c:forEach var="raakaaine" items="${listaRaakaaine}">
                    <option value="${raakaaine.id}">${raakaaine.nimi}</option>
                </c:forEach>
            </select>
            <input type="hidden" value="0" id="theValue" />
             <div id="myDiv"> </div>
             <input type="button" value="Lisää" onclick="addElements()"/><br/> 
                        
            <input type="submit" name="Lähetä"/>
        </form>
        <p>${varoitus}</p>

        <h2>Uusi raaka-aine</h2>
        <form name="uusiRaakaaine"
              action="${pageContext.request.contextPath}/LisaaRaakaaine"
              method="post">
            Nimi: <input type="text" name="nimi" /> <br/>
            Energia: <input type="text" name="energia" /> kcal/100g <br/>
            <input type="submit" name="Lähetä"/>
        </form>
    </body>
</html>
