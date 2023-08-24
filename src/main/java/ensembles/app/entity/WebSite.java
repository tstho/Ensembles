package ensembles.app.entity;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;

import javax.persistence.OneToOne;

@Entity
public class WebSite {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String logo;
	private String imageBackground;
	private Color color;
	private String imageAboutUs;
	private String aboutUs;
	
	
	
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getAboutUs() {
		return aboutUs;
	}
	public String setAboutUs(String aboutUs) {
		return "Parlez de votre Agence";
	}
	public String getLogo() {
		return logo;
	}
	public String setLogo(String logo) {
		return "Chargez votre Logo";
	}
	public String getImage() {
		return imageBackground;
	}
	public void setImage(String image) {
		this.imageBackground = image;
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
	
		

}
