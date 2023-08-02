package ensembles.app.service;

import javax.ejb.Stateless;
import javax.inject.Inject;

import ensembles.app.entity.Partenaire;
import ensembles.app.entity.User;
import ensembles.app.repository.RepoPartenaire;


@Stateless
public class PartenaireService {
	
	@Inject
	private RepoPartenaire repoPartenaire;
	@Inject
	private Partenaire partenaire;
	
	public RepoPartenaire getRepoPartenaire() {
		return repoPartenaire;
	}
	public void setRepoPartenaire(RepoPartenaire repoPartenaire) {
		this.repoPartenaire = repoPartenaire;
	}
	public Partenaire getPartenaire() {
		return partenaire;
	}
	public void setPartenaire(Partenaire partenaire) {
		this.partenaire = partenaire;
	}

	public void savePartenaire(String nom, String localisation) {
		
		partenaire = new Partenaire();
		partenaire.setLocalisation(localisation);
		partenaire.setNom(nom);
		repoPartenaire.savePartenaire(partenaire);
		
	}
}
