<% Class.forName("org.postgresql.Driver"); %>
<% java.sql.Connection con = java.sql.DriverManager.getConnection("jdbc:postgresql://localhost:5432/bdebayproject","postgres","poste789");%>
<% java.sql.Statement statement = con.createStatement(); %>
<% java.sql.ResultSet rs; %>

<%@ page language="java" contentType="text/html; charset=utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<link rel="stylesheet" type="text/css" href="css/style.css"/>
<!-- js slide -->
<script src="js/jquery.min.js" charset="utf-8" type="text/javascript"></script>

<script src="js/slides.min.jquery.js" charset="utf-8" type="text/javascript"></script>
<script src="js/functions.js" charset="utf-8" type="text/javascript"></script>
<title>eSway-Produits</title>
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
     
      <div class="bloc-right">
        <div class="compte">
        <h3>Mon compte</h3>
        <p>Bienvenue Mlle Ouali<a href="#"><img src="images/ico-delete.png" width="15" height="15" alt="delete" /></a></p>
        </div>
       <!--<div class="panier">
        <h3>Mon panier<span class="prix-total">299,90 â¬</span></h3>
        <p>Articles<span class="nbr-article">8</span></p>
        </div>-->
      </div>
    </div>
	 <div class="menu">
        <ul>
          <li><a href="mode.jsp"><span>Mode</span></a></li>
          <li><a href="produitsElectro.jsp"><span>Produits Ã©lectroniques</span></a></li>
		  <li><a href="livres.jsp"><span>Livres & collections</span></a></li>
        </ul>
      </div>
  </div>
  <div id="content">
    
	<div class="bloc-right-listing">
		<div class="menu-left">
			<ul>
				<li><a href="#">Femme</a>
				  <ul>
                  	<li><a href="#">Manteau, blouson</a></li>
				    <li><a href="#">Robe</a></li>
				    <li><a href="#">Jean</a></li>
				    <li><a href="#">Pantalon</a></li>
				    <li><a href="#">Pull</a></li>
				    <li><a href="#">Chemise</a></li>
				    <li><a href="#">Vétement sport femme</a></li>
				    <li><a href="#">Chaussures</a></li>
				    <li><a href="#">Vétement de grossess</a></li>
				  </ul>
				
			  </li>
				<li><a href="#">Homme</a></li>
				<li><a href="#">Enfant Bébé</a></li>				
			</ul>
			
		
		</div>
		
		
		<div class="promos">
			<div class="title">
			<h2>Promos : Mode</h2>
		</div>
		<a href=""><img src="images/promos.jpg" width="190" height="180" alt="tee-shirt" /></a>
		</div>
	</div>
	<div class="listing">
      <div class="title">
        <h2>Mode : Polo </h2>
      </div>
      <div class="fiche-produit">
      <form name="actionForm" action="CreateProduitServlet" method ="Post">
      <%  rs = statement.executeQuery("SELECT * FROM produit where idprdt = 766"); %>
      <% while (rs.next())
			{ %>
			<p class="imgprod"><img src="<%= rs.getString("imgprdt") %>" width="300" height="350" alt="tee-shirt" /></p>
			
			<div class="description">
			
			<h3><%= rs.getString("nomprdt") %></h3>
			<p><span>Description :</span><%= rs.getString("descprdt") %></p>
			<p><span>Prix :</span><%= rs.getString("prix") %> euros </p>
			
			<% } %> 
			<a class = "add" href="">Ench&eacute;rir</a>
			</div>
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
            <p class="par1"><span>Vous avez des choses Ã  nous dire ?</span> nous sommes <br />Ã  votre Ã©coute du lundi au vendredi de 9h Ã  17h au<span class="tel">00 00 00 00 00</span></p>
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
          <tr><td><a href="#">ConfidentialitÃ©</a></td>
            <td><a href="#">Retours et Ã©changes</a></td>
          </tr>
          <tr><td><a href="#">Blog</a></td>
            <td><a href="#">Paiement sÃ©curisÃ©</a></td>
          </tr>
          <tr><td></td><td><a href="#"><img src="images/ico-cb.png" width="34" height="21" alt="cb" /><img src="images/ico-mastercard.png" width="34" height="21" alt="mastercard" /><img src="images/ico-visa.png" width="33" height="21" alt="ico-visa" /><img src="images/ico-paypal.png" width="33" height="21" alt="paypal" /></a></td>
          </tr>
        </tbody>
        </table>
        </div>
         <div class="copyright">
              <p>eSway Â© Tous droits rÃ©servÃ©s 2014</p>
              <ul>
              <li><a href="#" title="mentions-lÃ©gales">Mentions lÃ©gales</a></li>
              <li><a href="#" title="crÃ©dits">CrÃ©dits</a></li>
              </ul>
  		</div>
  </div>
 
</div>
</body>
</html>
