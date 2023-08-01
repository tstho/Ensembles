package ensembles.app.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Profil")
public class Profil {
	
	@Id
	@GeneratedValue (strategy= GenerationType.AUTO)
	        private Long id;

			private String Nom;
			
			private String Prenom;
			
			private String Sociéte;
			
			private String Localisation;
			
			private String Adresse;
			
			

			public Profil() {
				super();
			}

			public Profil(Long id, String nom, String prenom, String sociéte, String localisation, String adresse) {
				super();
				this.id = id;
				Nom = nom;
				Prenom = prenom;
				Sociéte = sociéte;
				Localisation = localisation;
				Adresse = adresse;
			}

			public Long getId() {
				return id;
			}

			public void setId(Long id) {
				this.id = id;
			}

			public String getNom() {
				return Nom;
			}

			public void setNom(String nom) {
				Nom = nom;
			}

			public String getPrenom() {
				return Prenom;
			}

			public void setPrenom(String prenom) {
				Prenom = prenom;
			}

			public String getSociéte() {
				return Sociéte;
			}

			public void setSociéte(String sociéte) {
				Sociéte = sociéte;
			}

			public String getLocalisation() {
				return Localisation;
			}

			public void setLocalisation(String localisation) {
				Localisation = localisation;
			}

			public String getAdresse() {
				return Adresse;
			}

			public void setAdresse(String adresse) {
				Adresse = adresse;
			}
			
			
			
			

			
}
