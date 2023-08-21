package ensembles.app.viewmodels;

public class ProfilPartenaireViewModel extends ProfilViewModel {

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

	
	public String getNomProfil() {
        return nomPartenaire;
    }

 
    public String getEmailProfil() {
        return emailResponsablePartenaire;
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
