package ensembles.app.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;

@Entity
public class WebSite {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String aboutUs;
//	private BufferedImage logo;
    
//	@Lob
//    private byte[] logo;

	/**
	 * @return the aboutUs
	 */
	public String getAboutUs() {
		return aboutUs;
	}

	/**
	 * @return the id
	 */
	public Long getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(Long id) {
		this.id = id;
	}

	/**
	 * @param aboutUs the aboutUs to set
	 */
	public void setAboutUs(String aboutUs) {
		this.aboutUs = aboutUs;
	}

	/**
	 * @return the logo
	 */
//	public byte[] getLogo() {
//		return logo;
//	}
//
//	/**
//	 * @param logo the logo to set
//	 */
//	public void setLogo(byte[] logo) {
//		this.logo = logo;
//	}

		

}
