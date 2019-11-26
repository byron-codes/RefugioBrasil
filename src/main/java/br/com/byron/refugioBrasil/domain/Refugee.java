package br.com.byron.refugioBrasil.domain;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.springframework.format.annotation.DateTimeFormat;

import br.com.byron.refugioBrasil.enums.MaritalStatus;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "_refugee")
public class Refugee extends Person {

	@Column(name = "email")
	private String email;

	@Column(name = "arrival_date")
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private LocalDate arrivalDate;

	@Enumerated(EnumType.STRING)
	@Column(name = "marital_status")
	private MaritalStatus maritalStatus;

	@Column(name = "cpp")
	private Boolean cpp;

	@OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@JoinColumn(name = "necessity")
	private Necessity necessity;

	@OneToOne(cascade = CascadeType.MERGE, fetch = FetchType.LAZY)
	@JoinColumn(name = "birth_country")
	private Country birthCountry;

	@OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@JoinColumn(name = "address")
	private Address address;

	@OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@JoinColumn(name = "image")
	private Image image;

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	private List<Profession> professions = new ArrayList<Profession>();

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	private List<Language> languages = new ArrayList<Language>();

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	private List<Academic> academics = new ArrayList<Academic>();

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	private List<Phone> phones = new ArrayList<Phone>();

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	private List<Dependent> dependents = new ArrayList<Dependent>();

}
