package br.com.byron.refugioBrasil.viewHelper;

import java.time.LocalDate;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ProfessionVH extends GenericVH {

	private String description;

	private LocalDate startDate;

	private LocalDate endDate;

	private boolean current;

	private boolean recommendation;

	private CountryVH country;
}
