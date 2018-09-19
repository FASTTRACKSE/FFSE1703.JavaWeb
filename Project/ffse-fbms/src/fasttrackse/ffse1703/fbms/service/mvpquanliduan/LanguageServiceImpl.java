package fasttrackse.ffse1703.fbms.service.mvpquanliduan;

import java.util.List;

import fasttrackse.ffse1703.fbms.dao.mvpquanliduan.LanguageDao;
import fasttrackse.ffse1703.fbms.entity.mvpquanliduan.Language;

public class LanguageServiceImpl implements LanguageService {
private LanguageDao languageDao;
	@Override
	public List<Language> getAll() {
		// TODO Auto-generated method stub
		return languageDao.getAll();
	}

	@Override
	public Language getById(int id) {
		// TODO Auto-generated method stub
		return languageDao.getById(id);
	}

	@Override
	public void add(Language language) {
		languageDao.add(language);

	}

	@Override
	public void update(Language language) {
		languageDao.update(language);

	}

	@Override
	public void delete(int id) {
		languageDao.delete(id);

	}

	@Override
	public int checkNameLanguage(String nameLanguage) {
		// TODO Auto-generated method stub
		return languageDao.checkNameLanguage(nameLanguage);
	}

}
