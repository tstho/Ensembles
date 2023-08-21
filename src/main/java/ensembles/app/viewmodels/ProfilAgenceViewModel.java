package ensembles.app.viewmodels;

public class ProfilAgenceViewModel extends ProfilViewModel {

	private String nomSociete;
	private String siretSociete;

	private int numero;
	private String complement;
	private String voie;
	private int codePostal;
	private String ville;
	private String pays;
	
	private String nomResponsableSociete;
	private String prenomResponsableSociete;
	private String emailResponsableSociete;
	private int telephoneResponsableSociete;
	
	
	public String getNomSociete() {
		return nomSociete;
	}
	public void setNomSociete(String nomSociete) {
		this.nomSociete = nomSociete;
	}
	
	
    public String getNomProfil() {
        return nomSociete;
    }

    
    public String getEmailProfil() {
        return emailResponsableSociete;
    }

	
	public int getNumero() {
		return numero;
	}
	public void setNumero(int numero) {
		this.numero = numero;
	}
	public String getComplement() {
		return complement;
	}
	public void setComplement(String complement) {
		this.complement = complement;
	}
	public String getVoie() {
		return voie;
	}
	public void setVoie(String voie) {
		this.voie = voie;
	}
	public int getCodePostal() {
		return codePostal;
	}
	public void setCodePostal(int codePostal) {
		this.codePostal = codePostal;
	}
	public String getVille() {
		return ville;
	}
	public void setVille(String ville) {
		this.ville = ville;
	}
	public String getPays() {
		return pays;
	}
	public void setPays(String pays) {
		this.pays = pays;
	}
	public String getSiretSociete() {
		return siretSociete;
	}
	public void setSiretSociete(String siretSociete) {
		this.siretSociete = siretSociete;
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
