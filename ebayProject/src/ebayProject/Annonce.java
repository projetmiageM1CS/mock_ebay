package ebayProject;

import java.io.Serializable;

public class Annonce implements Serializable {

		private String nomA;
		private String descriptionA;
		private int prixA;
		private String photoA;
		public String getNomA() {
			return nomA;
		}
		public void setNomA(String nomA) {
			this.nomA = nomA;
		}
		public String getDescriptionA() {
			return descriptionA;
		}
		public void setDescriptionA(String descriptionA) {
			this.descriptionA = descriptionA;
		}
		public int getPrixA() {
			return prixA;
		}
		public void setPrixA(int prixA) {
			this.prixA = prixA;
		}
		public String getPhotoA() {
			return photoA;
		}
		public void setPhotoA(String photoA) {
			this.photoA = photoA;
		}
		
	}
		