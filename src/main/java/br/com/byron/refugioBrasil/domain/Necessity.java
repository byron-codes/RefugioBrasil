package br.com.byron.refugioBrasil.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Table;

import br.com.byron.refugioBrasil.enums.Situation;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "_necessity")
public class Necessity extends DomainEntity {
	
	@Column(name = "description", length = 150)
	private String description;
	
	@Column(name = "food")
	private Boolean food = false;
	
	@Column(name = "home")
	private Boolean home = false;
	
	@Column(name = "medicine")
	private Boolean medicine = false;
	
	@Enumerated(EnumType.STRING)
	@Column(name = "situation")
	private Situation situation;

}
