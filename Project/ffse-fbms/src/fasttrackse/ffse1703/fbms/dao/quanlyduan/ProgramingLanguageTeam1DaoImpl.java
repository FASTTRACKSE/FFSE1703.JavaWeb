package fasttrackse.ffse1703.fbms.dao.quanlyduan;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import fasttrackse.ffse1703.fbms.entity.quanlyduan.ProgramingLanguageTeam1;


@Repository
public class ProgramingLanguageTeam1DaoImpl implements ProgramingLanguageTeam1Dao{
	
	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public List<ProgramingLanguageTeam1> getAll() {
		Session session = this.sessionFactory.getCurrentSession();
		return session.createQuery("from ProgramingLanguageTeam1 where isDelete =0",ProgramingLanguageTeam1.class).list();
	}


	@Override
	public void addNew(ProgramingLanguageTeam1 Nn) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void update(ProgramingLanguageTeam1 maNn) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(String maNn) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public ProgramingLanguageTeam1 getById(String maNn) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setIsDelete(String maNn) {
		// TODO Auto-generated method stub
		
	}



}
