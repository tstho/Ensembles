package ensembles.app.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class ProfilClient {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	
	private Long id; 
	
	

		private String prenomClient;
		private String nomClient;
		private String voie; 
		private int codepostal;
		private String ville; 
		private String Pays;
		private int telephoneClient;
		private String emailClient;
		
		
		
		public Long getId() {
			return id;
		}
		public void setId(Long id) {
			this.id = id;
		}
		public String getPrenomClient() {
			return prenomClient;
		}
		public void setPrenomClient(String prenomClient) {
			this.prenomClient = prenomClient;
		}
		public String getNomClient() {
			return nomClient;
		}
		public void setNomClient(String nomClient) {
			this.nomClient = nomClient;
		}
		public String getVoie() {
			return voie;
		}
		public void setVoie(String voie) {
			this.voie = voie;
		}
		public int getCodepostal() {
			return codepostal;
		}
		public void setCodepostal(int codepostal) {
			this.codepostal = codepostal;
		}
		public String getVille() {
			return ville;
		}
		public void setVille(String ville) {
			this.ville = ville;
		}
		public String getPays() {
			return Pays;
		}
		public void setPays(String pays) {
			Pays = pays;
		}
		public int getTelephoneClient() {
			return telephoneClient;
		}
		public void setTelephoneClient(int telephoneClient) {
			this.telephoneClient = telephoneClient;
		}
		public String getEmailClient() {
			return emailClient;
		}
		public void setEmailClient(String emailClient) {
			this.emailClient = emailClient;
		}
		
	}

	


