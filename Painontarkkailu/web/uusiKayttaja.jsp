<%-- 
    Document   : uusiKayttaja
    Created on : 7.12.2011, 21:33:20
    Author     : Hannu Päiveröinen
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<link href="default.css" rel="stylesheet" type="text/css" title="Tyylipohja www-selaimelle" />
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Uusi Käyttäjä</title>
    </head>
    <body>
        <h1>Tervetuloa luomaan itsellesi profiili</h1>
    </body>
    
    <a href="../Painontarkkailu">Etusivulle</a>
     <h2>Uusi käyttäjä</h2>
            <form name="uusiKayttaja"
                  action="${pageContext.request.contextPath}/LisaaKayttaja"
                  method="post">
                Käyttäjänimi: <input type="text" value="${kayttajanimiApu}" name="kayttajanimi" /> <br/>
                Nimi: <input type="text" value="${nimiApu}" name="nimi" /> <br/>
                Ikä: <input type="text" value="${ikaApu}" name="ika" /> vuotta <br/>
                <input type="radio" name="sex"  value="mies" ${miesApu}/> Mies
                <input type="radio" name="sex" value="nainen" ${nainenApu}/> Nainen<br />
                Pituus: <input type="text" Value="${pituusApu}" name="pituus" /> cm <br/>
                Paino: <input type="text" value="${painoApu}" name="paino" /> kg <br/>
                <input type="submit" name="Lähetä"/>
            </form>
                <p>${varoitus}</p>
</html>
