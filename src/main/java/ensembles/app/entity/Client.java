package ensembles.app.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Client")
public class Client {

		@Id
		@GeneratedValue (strategy= GenerationType.AUTO)
		
		        private Long Id;

				private String Nom;
				
				private String Prenom;
				
				private String Email;
				
				private String Sociéte;
				
				private String Adresse;
				
				

				public Client() {
					super();
				}

				public Client(Long id, String nom, String prenom, String email, String sociéte, String adresse) {
					super();
					Id = id;
					Nom = nom;
					Prenom = prenom;
					Email = email;
					Sociéte = sociéte;
					Adresse = adresse;
				}

				public Long getId() {
					return Id;
				}

				public void setId(Long id) {
					this.Id = id;
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

				public String getEmail() {
					return Email;
				}

				public void setEmail(String email) {
					this.Email = email;
				}

				public String getSociéte() {
					return Sociéte;
				}

				public void setSociéte(String sociéte) {
					Sociéte = sociéte;
				}

				public String getAdresse() {
					return Adresse;
				}

				public void setAdresse(String adresse) {
					Adresse = adresse;
				}
				
				

}
