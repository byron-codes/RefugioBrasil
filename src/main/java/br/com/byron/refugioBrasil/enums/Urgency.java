package br.com.byron.refugioBrasil.enums;

public enum Urgency {
	
	MAXIMA("Máxima"),
	MEDIA("Média"),
	MINIMA("Miníma");
	
	private String description;

	Urgency(String description) {
		this.description = description;
	}

	public String getDescription() {
		return description;
	}

}
