package ensembles.app.entity;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

@Entity
public  class ProfilAgence extends Profil {

	
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	private String nomSociete;
	private String siretSociete;

	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="adresse_id")	
	private Adresse adresse;
	
	private String nomResponsableSociete;
	private String prenomResponsableSociete;
	private String emailResponsableSociete;
	private int telephoneResponsableSociete;
	
	 // Méthodes abstraites implémentées

    @Override
    public String getNomProfil() {
        return nomSociete;
    }

    @Override
    public String getEmailProfil() {
        return emailResponsableSociete;
    }
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getNomSociete() {
		return nomSociete;
	}
	public void setNomSociete(String nomSociete) {
		this.nomSociete = nomSociete;
	}
	public String getSiretSociete() {
		return siretSociete;
	}
	public void setSiretSociete(String siretSociete) {
		this.siretSociete = siretSociete;
	}
	public Adresse getAdresse() {
		return adresse;
	}
	public void setAdresse(Adresse adresse) {
		this.adresse = adresse;
	}
	public String getNomResponsableSociete() {
		return nomResponsableSociete;
	}
	public void setNomResponsableSociete(String nomResponsableSociete) {
		this.nomResponsableSociete = nomResponsableSociete;
	}
	public String getPrenomResponsableSociete() {
		return prenomResponsableSociete;
	}
	public void setPrenomResponsableSociete(String prenomResponsableSociete) {
		this.prenomResponsableSociete = prenomResponsableSociete;
	}
	public String getEmailResponsableSociete() {
		return emailResponsableSociete;
	}
	public void setEmailResponsableSociete(String emailResponsableSociete) {
		this.emailResponsableSociete = emailResponsableSociete;
	}
	public int getTelephoneResponsableSociete() {
		return telephoneResponsableSociete;
	}
	public void setTelephoneResponsableSociete(int telephoneResponsableSociete) {
		this.telephoneResponsableSociete = telephoneResponsableSociete;
	}
	
	

}
