package ensembles.app.entity;

public enum Color {

	ROUGE("#FF0000"), VERT("#00FF00"), BLEU("#0000FF"), JAUNE("#FFFF00");

	private String codeCouleur;

	Color(String codeCouleur) {
		this.codeCouleur = codeCouleur;
	}

	public String getCodeCouleur() {
		return codeCouleur;
	}
}
