package br.com.byron.refugioBrasil.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.byron.refugioBrasil.domain.City;

@Component
public class CityDao implements IDao<City> {
	
	@Autowired
	ICityDao dao;

	@Override
	public City save(City entity) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public City update(City entity) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public City find(City entity) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<City> findAll(City entity) {
		if(entity.getState() != null && entity.getState().getId() != null){
			return dao.getCityByState(entity.getState());
		}
		return null;
	}

	@Override
	public City delete(City entity) {
		// TODO Auto-generated method stub
		return null;
	}

}
