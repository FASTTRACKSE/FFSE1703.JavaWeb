package fasttrackse.ffse1703.fbms.dao.quanlyduan;

import java.util.List;

import fasttrackse.ffse1703.fbms.entity.quanlyduan.ProgramingLanguageTeam1;

public interface ProgramingLanguageTeam1Dao {
	
	public List<ProgramingLanguageTeam1> getAll();

	public void addNew(ProgramingLanguageTeam1 Nn);

	public void update(ProgramingLanguageTeam1 maNn);

	public void delete(String maNn);

	public ProgramingLanguageTeam1 getById(String maNn);

	public void setIsDelete(String maNn);
}
