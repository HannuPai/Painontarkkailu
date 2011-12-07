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
    
     <h2>Uusi käyttäjä</h2>
            <form name="uusiKayttaja"
                  action="${pageContext.request.contextPath}/LisaaKayttaja"
                  method="post">
                Käyttäjänimi: <input type="text" name="kayttajanimi" /> <br/>
                Nimi: <input type="text" name="nimi" /> <br/>
                Ikä: <input type="text" name="ika" /> vuotta <br/>
                <input type="radio" name="sex" value="mies" /> Mies
                <input type="radio" name="sex" value="nainen" /> Nainen<br />
                Pituus: <input type="text" name="pituus" /> cm <br/>
                Paino: <input type="text" name="paino" /> kg <br/>
                <input type="submit" name="Lähetä"/>
            </form>
</html>
