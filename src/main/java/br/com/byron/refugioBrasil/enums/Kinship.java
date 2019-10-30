package br.com.byron.refugioBrasil.enums;

public enum Kinship {

	PAI("Pai"), 
	MAE("Mãe"), 
	COMPANHEIRO("Companheiro(a)"), 
	CUNHADO("Cunhado(a)"), 
	SOGRO("Sogro(a)"), 
	FILHO("Filho(a)"),
	NETO("Neto(a)"), 
	OUTRO("Outro");

	private String description;

	Kinship(String description) {
		this.description = description;
	}

	public String getDescription() {
		return description;
	}

}
