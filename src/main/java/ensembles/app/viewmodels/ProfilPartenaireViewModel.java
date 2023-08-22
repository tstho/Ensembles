package ensembles.app.viewmodels;

import ensembles.app.entity.User;

public class ProfilPartenaireViewModel {

private Long Id;
	
	public Long getId() {
		return Id;
	}
	public void setId(Long id) {
		Id = id;
	}
	
	private Long adresseId;
	public Long getAdresseId() {
		return adresseId;
	}
	public void setAdresseId(Long adresseId) {
		this.adresseId = adresseId;
	}
	private String nomPartenaire;
	private String siretPartenaire;

	private int numero;
	private String complement;
	private String voie;
	private int codePostal;
	private String ville;
	private String pays;

	private String nomResponsablePartenaire;
	private String prenomResponsablePartenaire;
	private String emailResponsablePartenaire;
	private int telephoneResponsablePartenaire;
	
	private User user;
	
	

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public String getNomPartenaire() {
		return nomPartenaire;
	}

	public String getSiretPartenaire() {
		return siretPartenaire;
	}

	public int getNumero() {
		return numero;
	}

	public String getComplement() {
		return complement;
	}

	public String getVoie() {
		return voie;
	}

	public int getCodePostal() {
		return codePostal;
	}

	public String getVille() {
		return ville;
	}

	public String getPays() {
		return pays;
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

	public void setNomPartenaire(String nomPartenaire) {
		this.nomPartenaire = nomPartenaire;
	}

	public void setSiretPartenaire(String siretPartenaire) {
		this.siretPartenaire = siretPartenaire;
	}

	public void setNumero(int numero) {
		this.numero = numero;
	}

	public void setComplement(String complement) {
		this.complement = complement;
	}

	public void setVoie(String voie) {
		this.voie = voie;
	}

	public void setCodePostal(int codePostal) {
		this.codePostal = codePostal;
	}

	public void setVille(String ville) {
		this.ville = ville;
	}

	public void setPays(String pays) {
		this.pays = pays;
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
