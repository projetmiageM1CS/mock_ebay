<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<link rel="stylesheet" type="text/css" href="css/style.css"/>
<!-- js slide -->
<script src="js/jquery.min.js" charset="utf-8" type="text/javascript"></script>

<script src="js/slides.min.jquery.js" charset="utf-8" type="text/javascript"></script>
<script src="js/functions.js" charset="utf-8" type="text/javascript"></script>
<title>eSway-Authentification</title>
</head>
<body>
<div id="globale">
  <div id="header">
    <h1 class="logo"><img src="images/logo.png" width="150" height="70" alt="logo" /></h1>
    <div class="right-bloc">
      <div class="first-menu">
		<ul>
          <li><a href="inscription.jsp"><span>S'inscrire</span></a></li>
          <li><a href="authentification.jsp"><span>Se connecter</span></a></li>
		  <li><a href="createAnnonce.jsp"><span>vendez-ici</span></a></li> 
        </ul>
      </div>
     
      <% if (session.getAttribute( "utilisateurConnecte" ) != null) { %>
      
      <div class="bloc-right">
        <div class="compte">
        <h3>Mon compte</h3>
        <p>Bienvenue <%= session.getAttribute( "utilisateurConnecte" ) %><a href="#"><img src="images/ico-delete.png" width="15" height="15" alt="delete" /></a></p>
        </div>
       		
      </div>
      <% }%>
    	  
      
    </div>
	 <div class="menu">
        <ul>
          <li><a href="mode.jsp"><span>Mode</span></a></li>
          <li><a href="produitsElectro.jsp"><span>Produits Electroniques</span></a></li>
		  <li><a href="livres.jsp"><span>Livres & collections</span></a></li>
        </ul>
      </div>
  </div>
  
  <%if(request.getAttribute("etat")=="nonConnecte") {%>
  	<script language="javascript">
    	  	alert ("Vous n' �tes pas encore inscrit inscrivez d abord");
    	  </script>
  <%} %>
  <div id="content">
  	 <p class="info">${ message }</p>
	 <p class="accroche">Connectez-vous rapidement et ajouter votre annonce eSway :</p>
     <form method="post" action="ConnexionServlet" class="login">
    <p>
      <label for="login">Email:</label>
      <input type="text" name="emailuser" id="login" value="name@example.com">
    </p>

    <p>
      <label for="password">Password:</label>
      <input type="password" name="password" id="password" value="4815162342">
    </p>

    <p class="login-submit">
      <button type="submit" class="login-button">Login</button>
    </p>

    <p class="forgot-password"><a href="index.jsp">Mot de passe oubli� ?</a></p>
  </form>
	
  </div>
</div>
<div id="footer-globale"> 
  <div id="footer">
  		<div class="footer-left">
                <div class="newsletter"><h3><span>News <span class="colors">& </span> eSway</span></h3>
                        <p>Vous manquez de news?<br />eSway va vous en donner !</p>
                        <form action="#"  method="post" name="newsletter">
                        <input type="text" name="txt-news" value="" class="txt-news"/>
                        <input type="submit" value="ok" name="ok" class="bouton" />
                        </form>
                </div>
                <div class="actualite">
                        <h3>DEVENIR FAN ET PARTAGER</h3><ul><li><img src="images/fb2.png" width="28" height="28" alt="facebook" /></li>
                        <li><img src="images/twit2.png" width="28" height="28" alt="twitter" /></li>
                        <li><img src="images/interest2.png" width="28" height="27" alt="pinterest" /></li>
                        </ul>
                </div>
        </div>	
        <div class="footer-center">
            <h3><span>Contact</span></h3>
            <p class="par1"><span>Vous avez des choses � nous dire ?</span> nous sommes <br />A� votre �coute du lundi au vendredi de 9h � 17h au<span class="tel">00 00 00 00 00</span></p>
        </div>
        <div class="footer-right">
        <table>
        <thead><tr><th>A propos</th><th>Services</th></tr></thead>
        <tbody>
          <tr><td><a href="#">Contact</a></td>
            <td><a href="#">Contact</a></td>
          </tr>
          <tr><td><a href="#">CGU</a></td>
            <td><a href="#">CGU</a></td>
          </tr>
          <tr><td><a href="#">Recrutement</a></td>
            <td><a href="#">Livraison</a></td>
          </tr>
          <tr><td><a href="#">Confidentialit�</a></td>
            <td><a href="#">Retours et �changes</a></td>
          </tr>
          <tr><td><a href="#">Blog</a></td>
            <td><a href="#">Paiement s�curis�</a></td>
          </tr>
          <tr><td></td><td><a href="#"><img src="images/ico-cb.png" width="34" height="21" alt="cb" /><img src="images/ico-mastercard.png" width="34" height="21" alt="mastercard" /><img src="images/ico-visa.png" width="33" height="21" alt="ico-visa" /><img src="images/ico-paypal.png" width="33" height="21" alt="paypal" /></a></td>
          </tr>
        </tbody>
        </table>
        </div>
         <div class="copyright">
              <p>eSway Tous droits r�serv�s 2014</p>
              <ul>
              <li><a href="#" title="mentions-l�gales">Mentions l�gales</a></li>
              <li><a href="#" title="cr�dits">Cr�dits</a></li>
              </ul>
  		</div>
  </div>
 
</div>
</body>
</html>
