package ensembles.app.viewmodels;

import java.util.LinkedList;
import java.util.List;

import ensembles.app.entity.Journey;
import ensembles.app.entity.User;

public class ProfilAgenceViewModel {
	
	private Long id;
	private User user;

	private String nomSociete;
	private String siretSociete;
	private String nomResponsableSociete;
	private String prenomResponsableSociete;
	private String emailResponsableSociete;
	private int telephoneResponsableSociete;

	private Long adresseId;
	
	private int numero;
	private String complement;
	private String voie;
	private int codePostal;
	private String ville;
	private String pays;
	
	private List<Journey> journeys = new LinkedList<>();
	
	

	@Override
	public String toString() {
		return "ProfilAgenceViewModel [id=" + id + ", user=" + user + ", nomSociete=" + nomSociete + ", siretSociete="
				+ siretSociete + ", nomResponsableSociete=" + nomResponsableSociete + ", prenomResponsableSociete="
				+ prenomResponsableSociete + ", emailResponsableSociete=" + emailResponsableSociete
				+ ", telephoneResponsableSociete=" + telephoneResponsableSociete + ", adresseId=" + adresseId
				+ ", numero=" + numero + ", complement=" + complement + ", voie=" + voie + ", codePostal=" + codePostal
				+ ", ville=" + ville + ", pays=" + pays + ", journeys=" + journeys + "]";
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

	public Long getAdresseId() {
		return adresseId;
	}

	public void setAdresseId(Long adresseId) {
		this.adresseId = adresseId;
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

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public List<Journey> getJourneys() {
		return journeys;
	}

	public void setJourneys(List<Journey> journeys) {
		this.journeys = journeys;
	}

	
	
		
}
	
	
	
	
	


