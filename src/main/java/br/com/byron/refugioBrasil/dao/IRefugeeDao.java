package br.com.byron.refugioBrasil.dao;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Component;

import br.com.byron.refugioBrasil.domain.Refugee;

@Component
public interface IRefugeeDao extends JpaRepository<Refugee, Long> {

	@Query("SELECT refugee FROM Refugee refugee JOIN refugee.documents docs WHERE docs.number = :number")
	Optional<Refugee> getUniqueRefugee(@Param("number") String number);

}
