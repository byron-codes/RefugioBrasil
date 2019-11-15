package br.com.byron.refugioBrasil.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.byron.refugioBrasil.domain.Language;
import br.com.byron.refugioBrasil.domain.Refugee;

@Component
public class RefugeeDao extends GenericDao<Refugee> implements IGenericDao<Refugee> {

	private final AddressDao addressDao;
	private final LanguageDao languageDao;

	@Autowired
	RefugeeDao(AddressDao addressDao, LanguageDao languageDao) {
		this.addressDao = addressDao;
		this.languageDao = languageDao;
	}

	@Override
	public Refugee save(Refugee entity) {
		addressDao.save(entity.getAddress());
		for(Language language : entity.getLanguages()) {
			languageDao.save(language);
		}
		return super.save(entity);
	}

}
