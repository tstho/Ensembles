package ensembles.app.viewmodels;

import javax.faces.bean.ManagedBean;

@ManagedBean
public class PartenaireViewModel {
	
	private String Nom;

	private String Localisation;

	public String getNom() {
		return Nom;
	}

	public void setNom(String nom) {
		Nom = nom;
	}

	public String getLocalisation() {
		return Localisation;
	}

	public void setLocalisation(String localisation) {
		Localisation = localisation;
	}

}
