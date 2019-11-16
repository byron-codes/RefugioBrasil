package br.com.byron.refugioBrasil.domain;

import java.time.LocalDate;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import br.com.byron.refugioBrasil.enums.Kinship;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "_dependent")
public class Dependent extends Person {
	
	@Column(name = "arrival_date")
	private LocalDate arrivalDate;
	
	@Enumerated(EnumType.STRING)
	@Column(name = "kinship")
	private Kinship kinship;
	
	@OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.REFRESH)
	@JoinColumn(name = "birth_country")
	private Country birthCountry;

}
