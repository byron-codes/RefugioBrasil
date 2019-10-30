package br.com.byron.refugioBrasil.strategy.domain;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;

import br.com.byron.refugioBrasil.domain.DomainEntity;
import br.com.byron.refugioBrasil.strategy.ILocalStrategy;
import br.com.byron.refugioBrasil.strategy.IStrategy;

public class DomainStrategy implements IStrategy<DomainEntity> {

	@Autowired
	Map<String, ILocalStrategy<DomainEntity>> strategy;
	
	String[] saveStrategies = {"register"};
	String[] updateStrategies = {"update"};
	
	@Override
	public String save(DomainEntity entity) {
		return null;
	}

	@Override
	public String update(DomainEntity entity) {
		return null;
	}

	@Override
	public String read(DomainEntity entity) {
		return null;
	}

	@Override
	public String delete(DomainEntity entity) {
		return null;
	}


}
