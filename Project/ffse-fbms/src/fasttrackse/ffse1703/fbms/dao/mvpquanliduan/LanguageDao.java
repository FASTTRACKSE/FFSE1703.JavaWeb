package fasttrackse.ffse1703.fbms.dao.mvpquanliduan;

import java.util.List;


import fasttrackse.ffse1703.fbms.entity.mvpquanliduan.Language;

public interface LanguageDao {
	public List<Language> getAll();
	public Language getById(int id);
	public void add(Language language);
	public void update(Language language);
	public void delete(int id);
	public int checkNameLanguage(String nameLanguage);
}
