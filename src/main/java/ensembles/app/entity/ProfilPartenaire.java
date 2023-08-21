package ensembles.app.entity;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

@Entity
public  class ProfilPartenaire extends Profil{

	
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private String nomPartenaire;
	private String siretPartenaire;

	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "adresse_id")
	private Adresse adresse;

	private String nomResponsablePartenaire;
	private String prenomResponsablePartenaire;
	private String emailResponsablePartenaire;
	private int telephoneResponsablePartenaire;
	
	
	
	
	 // Méthodes abstraites implémentées

    @Override
    public String getNomProfil() {
        return nomPartenaire;
    }

    @Override
    public String getEmailProfil() {
        return emailResponsablePartenaire;
    }
	
	

	public Long getId() {
		return id;
	}

	public String getNomPartenaire() {
		return nomPartenaire;
	}

	public String getSiretPartenaire() {
		return siretPartenaire;
	}

	public Adresse getAdresse() {
		return adresse;
	}

	public String getNomResponsablePartenaire() {
		return nomResponsablePartenaire;
	}

	public String getPrenomResponsablePartenaire() {
		return prenomResponsablePartenaire;
	}

	public String getEmailResponsablePartenaire() {
		return emailResponsablePartenaire;
	}

	public int getTelephoneResponsablePartenaire() {
		return telephoneResponsablePartenaire;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public void setNomPartenaire(String nomPartenaire) {
		this.nomPartenaire = nomPartenaire;
	}

	public void setSiretPartenaire(String siretPartenaire) {
		this.siretPartenaire = siretPartenaire;
	}

	public void setAdresse(Adresse adresse) {
		this.adresse = adresse;
	}

	public void setNomResponsablePartenaire(String nomResponsablePartenaire) {
		this.nomResponsablePartenaire = nomResponsablePartenaire;
	}

	public void setPrenomResponsablePartenaire(String prenomResponsablePartenaire) {
		this.prenomResponsablePartenaire = prenomResponsablePartenaire;
	}

	public void setEmailResponsablePartenaire(String emailResponsablePartenaire) {
		this.emailResponsablePartenaire = emailResponsablePartenaire;
	}

	public void setTelephoneResponsablePartenaire(int telephoneResponsablePartenaire) {
		this.telephoneResponsablePartenaire = telephoneResponsablePartenaire;
	}		

}
