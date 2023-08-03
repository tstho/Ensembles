package ensembles.app.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class ProfilAgence {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private String nomSociete;
	private String siretSociete;
	private int numeroSociete;
	private String complementSociete;
	private String voieSociete;
	private int codePostalSociete;
	private String villeSociete;
	private String departementSociete;
	private String paysSociete;
	private String nomResponsableSociete;
	private String prenomResponsableSociete;
	private String emailResponsableSociete;
	private int telephoneResponsableSociete;

	public Long getId() {
		return id;
	}

	public String getNomSociete() {
		return nomSociete;
	}

	public String getSiretSociete() {
		return siretSociete;
	}

	public int getNumeroSociete() {
		return numeroSociete;
	}

	public String getComplementSociete() {
		return complementSociete;
	}

	public String getVoieSociete() {
		return voieSociete;
	}

	public int getCodePostalSociete() {
		return codePostalSociete;
	}

	public String getVilleSociete() {
		return villeSociete;
	}

	public String getDepartementSociete() {
		return departementSociete;
	}

	public String getPaysSociete() {
		return paysSociete;
	}

	public String getNomResponsableSociete() {
		return nomResponsableSociete;
	}

	public String getPrenomResponsableSociete() {
		return prenomResponsableSociete;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public void setNomSociete(String nomSociete) {
		this.nomSociete = nomSociete;
	}

	public void setSiretSociete(String siretSociete) {
		this.siretSociete = siretSociete;
	}

	public void setNumeroSociete(int numeroSociete) {
		this.numeroSociete = numeroSociete;
	}

	public void setComplementSociete(String complementSociete) {
		this.complementSociete = complementSociete;
	}

	public void setVoieSociete(String voieSociete) {
		this.voieSociete = voieSociete;
	}

	public void setCodePostalSociete(int codePostalSociete) {
		this.codePostalSociete = codePostalSociete;
	}

	public void setVilleSociete(String villeSociete) {
		this.villeSociete = villeSociete;
	}

	public void setDepartementSociete(String departementSociete) {
		this.departementSociete = departementSociete;
	}

	public void setPaysSociete(String paysSociete) {
		this.paysSociete = paysSociete;
	}

	public void setNomResponsableSociete(String nomResponsableSociete) {
		this.nomResponsableSociete = nomResponsableSociete;
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
