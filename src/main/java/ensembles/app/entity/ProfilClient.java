package ensembles.app.entity;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

@Entity
public  class ProfilClient extends Profil{

	
	@GeneratedValue(strategy = GenerationType.AUTO)

	private Long id;

	private String prenomClient;
	private String nomClient;

	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "adresse_id")	
	private Adresse adresse;
	
	private int telephoneClient;
	private String emailClient;
	
	
	
	 // Méthodes abstraites implémentées

    public String getNomProfil() {
        return nomClient;
    }

    public String getEmailProfil() {
        return emailClient;
    }
	
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
	public Adresse getAdresse() {
		return adresse;
	}
	public void setAdresse(Adresse adresse) {
		this.adresse = adresse;
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
