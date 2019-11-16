package br.com.byron.refugioBrasil.domain;

import javax.persistence.Column;

public class State extends DomainEntity{
	@Column(name = "name", length = 100)
	private String name;
	
	@Column(name = "initals", length = 100)
	private String initals;
}
