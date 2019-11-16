package br.com.byron.refugioBrasil.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Table;

import br.com.byron.refugioBrasil.enums.Operators;
import br.com.byron.refugioBrasil.enums.PhoneType;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "_phone")
public class Phone extends DomainEntity {

	@Enumerated(EnumType.STRING)
	@Column(name = "type", nullable = false)
	private PhoneType type;
	
	@Enumerated(EnumType.STRING)
	@Column(name = "operators", nullable = false)
	private Operators operators;

	@Column(name = "idd", length = 4, nullable = false)
	private String idd;

	@Column(name = "number", length = 20, nullable = false)
	private String number;

}
