package ensembles.app.service;

import javax.ejb.Stateless;
import javax.inject.Inject;

import ensembles.app.entity.Adresse;
import ensembles.app.entity.Profil;
import ensembles.app.repository.RepoProfil;
import ensembles.app.viewmodels.ProfilAgenceViewModel;
import ensembles.app.viewmodels.ProfilClientViewModel;
import ensembles.app.viewmodels.ProfilPartenaireViewModel;
import ensembles.app.viewmodels.ProfilViewModel;


@Stateless
public class ProfilService {
	

	@Inject
	RepoProfil repoProfil;

	@Inject
    ProfilAgenceService profilAgenceService;

    @Inject
    ProfilClientService profilClientService;

    @Inject
    ProfilPartenaireService profilPartenaireService;


    public void saveProfil(ProfilViewModel profilViewModel, String profilType) {
    	
    	Profil profil = null;
    	
        switch (profilType) {
            case "Agence":
                profilAgenceService.saveProfilAgence((ProfilAgenceViewModel) profilViewModel);
                break;
            case "Client":
                profilClientService.saveProfilClient((ProfilClientViewModel) profilViewModel);
                break;
            case "Partenaire":
                profilPartenaireService.saveProfilPartenaire((ProfilPartenaireViewModel) profilViewModel);
                break;
            default:
                throw new IllegalArgumentException("Invalid profil type: " + profilType);
        }
            
       
        profil.setNom(profilViewModel.getNom());
        profil.setEmail(profilViewModel.getEmail());

        Adresse adresse = new Adresse();
        adresse.setNumero(profilViewModel.getNumero());
        adresse.setComplement(profilViewModel.getComplement());
        adresse.setVoie(profilViewModel.getVoie());
        adresse.setCodePostal(profilViewModel.getCodePostal());
        adresse.setVille(profilViewModel.getVille());
        adresse.setPays(profilViewModel.getPays());

      profil.setAdresse(adresse);
		
		repoProfil.save(profil);
    }

    }
	
	
	
	
	

