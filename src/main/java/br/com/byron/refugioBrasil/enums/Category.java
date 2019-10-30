package br.com.byron.refugioBrasil.enums;

public enum Category {
	
	MORADIA("Moradia"),
	ALIMENTO("Alimento"),
	REMEDIO("Remédio"),
	OUTRO("Outro");
	
	private String description;

	Category(String description) {
		this.description = description;
	}

	public String getDescription() {
		return description;
	}

}
