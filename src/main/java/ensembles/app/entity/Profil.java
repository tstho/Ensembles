package ensembles.app.entity;


import javax.persistence.*;

@Entity

public abstract class Profil {


	    @Id
	    @GeneratedValue(strategy = GenerationType.TABLE)
	    private Long id;

	    
	    private String nom;
	    private String email;

	    @OneToOne(cascade = CascadeType.ALL)
	    @JoinColumn(name="adresse_id")
	    private Adresse adresse;

	    private int telephoneProfil;

	    
	    protected Profil() {
	      
	    }

	    protected Profil(String nom, String email, Adresse adresse, int telephoneProfil) {
	        this.nom = nom;
	        this.email = email;
	        this.adresse = adresse;
	        this.telephoneProfil = telephoneProfil;
	    }

	    // Méthodes abstraites
	    
	    public abstract String getNomProfil();
	    public abstract String getEmailProfil();
	    

	    
	    public Long getId() {
	        return id;
	    }

	    public String getNom() {
	        return nom;
	    }

	    public void setNom(String nom) {
	        this.nom = nom;
	    }

	    public String getEmail() {
	        return email;
	    }

	    public void setEmail(String email) {
	        this.email = email;
	    }

	    public Adresse getAdresse() {
	        return adresse;
	    }

	    public void setAdresse(Adresse adresse) {
	        this.adresse = adresse;
	    }

	    public int getTelephoneProfil() {
	        return telephoneProfil;
	    }

	    public void setTelephoneProfil(int telephoneProfil) {
	        this.telephoneProfil = telephoneProfil;
	    }

	    

}
