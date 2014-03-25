package ebayProject;

import java.io.Serializable;

public class Produit implements Serializable {
	String nomP;
	String descp;
	String imgP;
	int prixP;
	public String getNomP() {
		return nomP;
	}
	public void setNomP(String nomP) {
		this.nomP = nomP;
	}
	public String getDescp() {
		return descp;
	}
	public void setDescp(String descp) {
		this.descp = descp;
	}
	public String getImgP() {
		return imgP;
	}
	public void setImgP(String imgP) {
		this.imgP = imgP;
	}
	public int getPrixP() {
		return prixP;
	}
	public void setPrixP(int prixP) {
		this.prixP = prixP;
	}
	

}
