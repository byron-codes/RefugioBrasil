package br.com.byron.refugioBrasil.domain;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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

	@ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@JoinColumn(name = "city")
	private City city;

	@Enumerated(EnumType.STRING)
	@Column(name = "type", nullable = false)
	private HomeType homeType;

}
