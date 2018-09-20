package fasttrackse.ffse1703.fbms.service.quanlyduan;

import java.util.List;

import fasttrackse.ffse1703.fbms.entity.quanlyduan.ProgramingLanguageTeam1;



public interface ProgramingLanguageTeam1Service {
	
	public List<ProgramingLanguageTeam1> getAll();

	public void delete(String maNn);

	public void addNew(ProgramingLanguageTeam1 Nn);

	public ProgramingLanguageTeam1 getById(String maNn);

	public void update(ProgramingLanguageTeam1 Nn);

	public void setIsDelete(String maNn);

}
