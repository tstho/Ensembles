package ensembles.app.viewmodels;

public abstract class ProfilViewModel {


	    private String nom;
	    private String email;

	    private int numero;
	    private String complement;
	    private String voie;
	    private int codePostal;
	    private String ville;
	    private String pays;

	    private int telephoneProfil;

	    public String getNom() {
	        return nom;
	    }

	    public String getEmail() {
	        return email;
	    }

	    public int getNumero() {
	        return numero;
	    }

	    public String getComplement() {
	        return complement;
	    }

	    public String getVoie() {
	        return voie;
	    }

	    public int getCodePostal() {
	        return codePostal;
	    }

	    public String getVille() {
	        return ville;
	    }

	    public String getPays() {
	        return pays;
	    }

	    public int getTelephoneProfil() {
	        return telephoneProfil;
	    }

	    public void setNom(String nom) {
	        this.nom = nom;
	    }

	    public void setEmail(String email) {
	        this.email = email;
	    }

	    public void setNumero(int numero) {
	        this.numero = numero;
	    }

	    public void setComplement(String complement) {
	        this.complement = complement;
	    }

	    public void setVoie(String voie) {
	        this.voie = voie;
	    }

	    public void setCodePostal(int codePostal) {
	        this.codePostal = codePostal;
	    }

	    public void setVille(String ville) {
	        this.ville = ville;
	    }

	    public void setPays(String pays) {
	        this.pays = pays;
	    }

	    public void setTelephoneProfil(int telephoneProfil) {
	        this.telephoneProfil = telephoneProfil;
	    }

	    public abstract String getNomProfil();
	    public abstract String getEmailProfil();

	
	}


