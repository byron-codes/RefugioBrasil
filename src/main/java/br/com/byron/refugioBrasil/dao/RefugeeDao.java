package br.com.byron.refugioBrasil.dao;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Base64;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.byron.refugioBrasil.domain.Refugee;

@Component
public class RefugeeDao implements IDao<Refugee> {

	@Autowired
	IRefugeeDao dao;

	@Override
	public Refugee save(Refugee entity) {
		Refugee refugee = dao.saveAndFlush(entity);
//		byte[] data = Base64.getDecoder().decode(entity.getImage().getFile());
//
//		try {
//			OutputStream stream = new FileOutputStream("c:/refugioBrasil/" + refugee.getImage().getId() + ".jpg");
//			stream.write(data);
//			stream.close();
//		} catch (IOException e) {
//			e.printStackTrace();
//		}

		return refugee;
	}

	@Override
	public Refugee update(Refugee entity) {
		entity.setLastUpdate(LocalDateTime.now());
		return dao.saveAndFlush(entity);
	}

	@Override
	public Refugee find(Refugee entity) {
		Optional<Refugee> returnEntity = dao.findById(entity.getId());
		if (returnEntity != null && returnEntity.isPresent() && returnEntity.get().getStatus()) {
			return returnEntity.get();
		}
		return null;
	}

	@Override
	public List<Refugee> findAll(Refugee entity) {
		List<Refugee> entities = new ArrayList<Refugee>();
		for (Refugee entityA : dao.findAll()) {
			if (entityA.getStatus()) {
				entities.add(entityA);
			}
		}
		return entities;
	}

	@Override
	public Refugee delete(Refugee entity) {
		Optional<Refugee> refugee = dao.findById(entity.getId());
		if (refugee != null && refugee.isPresent()) {
			refugee.get().setStatus(false);
			return dao.saveAndFlush(entity);
		}
		return null;
	}

}
