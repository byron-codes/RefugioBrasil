package br.com.byron.refugioBrasil.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;

import br.com.byron.refugioBrasil.domain.State;

@Component
public interface IStateDao extends JpaRepository<State, Long>{

}
