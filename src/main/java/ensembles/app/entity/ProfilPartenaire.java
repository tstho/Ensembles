package ensembles.app.entity;

import java.util.LinkedList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

@Entity
public class ProfilPartenaire {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private String nomPartenaire;
	private String siretPartenaire;
	private String nomResponsablePartenaire;
	private String prenomResponsablePartenaire;
	private String emailResponsablePartenaire;
	private int telephoneResponsablePartenaire;

	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "adresse_id")
	private Adresse adresse;

	@OneToOne
	@JoinColumn(name="user_id")
	private User user;

	@OneToMany(fetch = FetchType.EAGER, mappedBy="profilPartenaire")
	private List<Service> services = new LinkedList<>();

	@Override
	public String toString() {
		return "ProfilPartenaire [id=" + id + ", nomPartenaire=" + nomPartenaire + ", siretPartenaire="
				+ siretPartenaire + ", nomResponsablePartenaire=" + nomResponsablePartenaire
				+ ", prenomResponsablePartenaire=" + prenomResponsablePartenaire + ", emailResponsablePartenaire="
				+ emailResponsablePartenaire + ", telephoneResponsablePartenaire=" + telephoneResponsablePartenaire
				+ ", adresse=" + adresse + ", user=" + user + ", services=" + services + "]";
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
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

	public Adresse getAdresse() {
		return adresse;
	}

	public void setAdresse(Adresse adresse) {
		this.adresse = adresse;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public List<Service> getServices() {
		return services;
	}

	public void setServices(List<Service> services) {
		this.services = services;
	}

	
	

}
