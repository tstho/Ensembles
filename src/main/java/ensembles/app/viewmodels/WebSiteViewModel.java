package ensembles.app.viewmodels;

import javax.faces.bean.ManagedBean;

import ensembles.app.entity.Color;
import ensembles.app.entity.ProfilAgence;

@ManagedBean
public class WebSiteViewModel {

	private Long id; 
	private String logo;
	private String imageBackground;
	private Color color;
	private String imageAboutUs;
	private String aboutUs;
	private ProfilAgence profilAgence;
	
	
	
	@Override
	public String toString() {
		return "WebSiteViewModel [id=" + id + ", logo=" + logo + ", imageBackground=" + imageBackground + ", color="
				+ color + ", imageAboutUs=" + imageAboutUs + ", aboutUs=" + aboutUs + ", profilAgence=" + profilAgence
				+ "]";
	}
	/*
	 * getters & setters
	 */
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getLogo() {
		return logo;
	}
	public void setLogo(String logo) {
		this.logo = logo;
	}
	public String getImageBackground() {
		return imageBackground;
	}
	public void setImageBackground(String imageBackground) {
		this.imageBackground = imageBackground;
	}
	public Color getColor() {
		return color;
	}
	public void setColor(Color color) {
		this.color = color;
	}
	public String getImageAboutUs() {
		return imageAboutUs;
	}
	public void setImageAboutUs(String imageAboutUs) {
		this.imageAboutUs = imageAboutUs;
	}
	public String getAboutUs() {
		return aboutUs;
	}
	public void setAboutUs(String aboutUs) {
		this.aboutUs = aboutUs;
	}
	public ProfilAgence getProfilAgence() {
		return profilAgence;
	}
	public void setProfilAgence(ProfilAgence profilAgence) {
		this.profilAgence = profilAgence;
	}

	
	
}
