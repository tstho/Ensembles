package ensembles.app.viewmodels;

import java.util.LinkedList;
import java.util.List;

import ensembles.app.entity.Service;
import ensembles.app.entity.User;

public class ProfilPartenaireViewModel {

	private Long Id;
	private User user;
	
	private String nomPartenaire;
	private String siretPartenaire;
	private String nomResponsablePartenaire;
	private String prenomResponsablePartenaire;
	private String emailResponsablePartenaire;
	private int telephoneResponsablePartenaire;
	
	private Long adresseId;

	private int numero;
	private String complement;
	private String voie;
	private int codePostal;
	private String ville;
	private String pays;
	
	private List<Service> services = new LinkedList<>();
	
	public Long getId() {
		return Id;
	}
	public void setId(Long id) {
		Id = id;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public String getNomPartenaire() {
		return nomPartenaire;
	}
	public void setNomPartenaire(String nomPartenaire) {
		this.nomPartenaire = nomPartenaire;
	}
	public String getSiretPartenaire() {
		return siretPartenaire;
	}
	public void setSiretPartenaire(String siretPartenaire) {
		this.siretPartenaire = siretPartenaire;
	}
	public String getNomResponsablePartenaire() {
		return nomResponsablePartenaire;
	}
	public void setNomResponsablePartenaire(String nomResponsablePartenaire) {
		this.nomResponsablePartenaire = nomResponsablePartenaire;
	}
	public String getPrenomResponsablePartenaire() {
		return prenomResponsablePartenaire;
	}
	public void setPrenomResponsablePartenaire(String prenomResponsablePartenaire) {
		this.prenomResponsablePartenaire = prenomResponsablePartenaire;
	}
	public String getEmailResponsablePartenaire() {
		return emailResponsablePartenaire;
	}
	public void setEmailResponsablePartenaire(String emailResponsablePartenaire) {
		this.emailResponsablePartenaire = emailResponsablePartenaire;
	}
	public int getTelephoneResponsablePartenaire() {
		return telephoneResponsablePartenaire;
	}
	public void setTelephoneResponsablePartenaire(int telephoneResponsablePartenaire) {
		this.telephoneResponsablePartenaire = telephoneResponsablePartenaire;
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
	public List<Service> getServices() {
		return services;
	}
	public void setServices(List<Service> services) {
		this.services = services;
	}

	
	

}
