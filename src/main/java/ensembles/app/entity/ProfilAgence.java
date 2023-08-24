package ensembles.app.entity;

import java.util.LinkedList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;


@Entity

public class ProfilAgence {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private String nomSociete;
	private String siretSociete;
	private String nomResponsableSociete;
	private String prenomResponsableSociete;
	private String emailResponsableSociete;
	private int telephoneResponsableSociete;

	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="adresse_id")	
	private Adresse adresse;

	@OneToOne()
	@JoinColumn(name="user_id")
	private User user; 

	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="agency_website")
	private WebSite webSite;
	
	 @OneToMany(mappedBy="profilAgence")
	 private List<Journey> journeys = new LinkedList<>();
	
		
	@Override
	public String toString() {
		return "ProfilAgence [id=" + id + ", nomSociete=" + nomSociete + ", siretSociete=" + siretSociete + ", adresse="
				+ adresse + ", webSite=" + webSite + ", user=" + user + ", nomResponsableSociete="
				+ nomResponsableSociete + ", prenomResponsableSociete=" + prenomResponsableSociete
				+ ", emailResponsableSociete=" + emailResponsableSociete + ", telephoneResponsableSociete="
				+ telephoneResponsableSociete + "]";
	}
	/*
	 * getters & setters
	 */
	public WebSite getWebSite() {
		return webSite;
	}
	public void setWebSite(WebSite webSite) {
		this.webSite = webSite;
	}
	public List<Journey> getJourneys() {
		return journeys;
	}
	public void setJourneys(List<Journey> journeys) {
		this.journeys = journeys;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
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
