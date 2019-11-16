package br.com.byron.refugioBrasil.domain;

import javax.persistence.Column;

public class City extends DomainEntity{
	@Column(name = "name", length = 100)
	private String name;
}
