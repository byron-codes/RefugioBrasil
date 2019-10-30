package br.com.byron.refugioBrasil.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Table;

import br.com.byron.refugioBrasil.enums.HomeType;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "_address")
public class Address extends DomainEntity {

	@Column(name = "street", length = 100, nullable = false)
	private String street;

	@Column(name = "number")
	private int number;

	@Column(name = "complement", length = 25)
	private String complement;

	@Column(name = "cep", length = 10, nullable = false)
	private String cep;

	@Column(name = "city", length = 50, nullable = false)
	private String city;

	@Column(name = "state", length = 25, nullable = false)
	private String state;

	@Enumerated(EnumType.STRING)
	@Column(name = "type", nullable = false)
	private HomeType homeType;

}
