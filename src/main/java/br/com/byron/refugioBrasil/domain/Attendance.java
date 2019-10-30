package br.com.byron.refugioBrasil.domain;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "_attendance")
public class Attendance extends DomainEntity {

	@Column(name = "description", length = 250, nullable = false)
	private String description;
	
	@Column(name = "date", nullable = false)
	private LocalDate date;
	
	@Column(name = "value")
	private Double value;
	
	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	private Set<Refugee> refugees = new HashSet<>();
	
}
