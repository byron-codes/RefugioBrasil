package br.com.byron.refugioBrasil.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
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
@Table(name = "_state")
public class State extends DomainEntity {
	
	@Column(name = "name", length = 100)
	private String name;

	@Column(name = "initials", length = 100)
	private String initials;
	
}
