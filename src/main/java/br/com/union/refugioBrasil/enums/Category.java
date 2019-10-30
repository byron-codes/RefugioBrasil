package br.com.union.refugioBrasil.enums;

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
