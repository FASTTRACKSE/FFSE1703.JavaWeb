package fasttrackse.ffse1703.fbms.dao.mvpquanliduan;

import java.util.List;

import fasttrackse.ffse1703.fbms.entity.mvpquanliduan.Nhiemvu;


public interface NhiemVuDao {
	public void add(Nhiemvu nhiemVu);

	public Nhiemvu getByID(int id);

	public List<Nhiemvu> getByDuAn(String idProjects);
	
	public List<Nhiemvu> getByDuAn(String idProjects, String search,int start,int maxRows);

	public void update(Nhiemvu nhiemVu);

	public void delete(int id);
	
	public List<Nhiemvu> getByMaNhanVien(String idNv);
	 
	public int countNhiemvu(String idProjects, String search);
	
}
