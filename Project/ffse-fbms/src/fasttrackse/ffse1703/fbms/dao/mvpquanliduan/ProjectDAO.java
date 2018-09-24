package fasttrackse.ffse1703.fbms.dao.mvpquanliduan;

import java.util.List;

import fasttrackse.ffse1703.fbms.entity.mvpquanliduan.Projects;

public interface ProjectDAO {
	public List<Projects> findAll();
	public Projects findById(String id);
	public void addNew(Projects projects);
	public void update(Projects projects);
	public void delete(Projects projects);
	public int checkNameProjects(String nameProjects);
	public int checkMaProjects(String idProjects);
}
