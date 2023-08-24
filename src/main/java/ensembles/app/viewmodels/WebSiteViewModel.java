package ensembles.app.viewmodels;

import ensembles.app.entity.Color;

public class WebSiteViewModel {

	
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

	
	
}
