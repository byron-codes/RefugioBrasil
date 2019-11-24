package br.com.byron.refugioBrasil.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import br.com.byron.refugioBrasil.domain.City;
import br.com.byron.refugioBrasil.domain.State;

public interface ICityDao extends JpaRepository<City, Long> {

	@Query("SELECT city FROM City city WHERE city.state = :state")
	List<City> getCityByState(@Param("state") State state);
	
}
