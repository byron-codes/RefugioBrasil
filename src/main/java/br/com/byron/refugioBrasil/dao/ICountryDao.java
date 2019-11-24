package br.com.byron.refugioBrasil.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.byron.refugioBrasil.domain.Country;

public interface ICountryDao extends JpaRepository<Country, Long> {

}
