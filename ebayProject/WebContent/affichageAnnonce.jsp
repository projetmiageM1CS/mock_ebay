<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<link rel="stylesheet" type="text/css" href="css/style.css"/>
<!-- js slide -->
<script src="js/jquery.min.js" charset="utf-8" type="text/javascript"></script>

<script src="js/slides.min.jquery.js" charset="utf-8" type="text/javascript"></script>
<script src="js/functions.js" charset="utf-8" type="text/javascript"></script>
 <title>Affichage d'une Annonce</title>
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
      <% } %>
    </div>
	 <div class="menu">
        <ul>
          <li><a href="mode.jsp"><span>Mode</span></a></li>
          <li><a href="produitsElectro.jsp"><span>Produits Electroniques</span></a></li>
		  <li><a href="livres.jsp"><span>Livres & collections</span></a></li>
        </ul>
      </div>
  </div>
  <div id="content">    
        <div class="confirmation">
		        <p class="info">${ message }</p>    
       		 <div class="recap">
		       		<p class='title'>Récapitulatif de votre annonce ajoutée :</p>
		        	    <p class="imagProd"><img src="image_interface/${ annonce.photoA}" /></p>	
				        <p><span>Titre :</span> ${ annonce.nomA }</p>
				        <p><span>Description: </span> ${ annonce.descriptionA }</p>
			        <p><span>Prix :</span> ${ annonce.prixA} euros</p>
		      
		     </div>      
		       
        </div>
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
            <p class="par1"><span>Vous avez des choses à  nous dire ?</span> nous sommes <br />à  votre écoute du lundi au vendredi de 9h à  17h au<span class="tel">00 00 00 00 00</span></p>
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
          <tr><td><a href="#">Confidentialité</a></td>
            <td><a href="#">Retours et échanges</a></td>
          </tr>
          <tr><td><a href="#">Blog</a></td>
            <td><a href="#">Paiement sécurisé</a></td>
          </tr>
          <tr><td></td><td><a href="#"><img src="images/ico-cb.png" width="34" height="21" alt="cb" /><img src="images/ico-mastercard.png" width="34" height="21" alt="mastercard" /><img src="images/ico-visa.png" width="33" height="21" alt="ico-visa" /><img src="images/ico-paypal.png" width="33" height="21" alt="paypal" /></a></td>
          </tr>
        </tbody>
        </table>
        </div>
         <div class="copyright">
              <p>eSway à Tous droits réservés 2014</p>
              <ul>
              <li><a href="#" title="mentions-légales">Mentions légales</a></li>
              <li><a href="#" title="crédits">Crédits</a></li>
              </ul>
  		</div>
  </div>
 
</div>

</body>
</html>
