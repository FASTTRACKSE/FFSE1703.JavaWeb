package fasttrackse.ffse1703.fbms.dao.qttl;

import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Join;
import javax.persistence.criteria.Root;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Projections;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import fasttrackse.ffse1703.fbms.entity.qttl.*;

import java.io.File;
import java.util.HashMap;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import org.apache.commons.io.FilenameUtils;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.commons.CommonsMultipartFile;


@Repository
@Transactional(rollbackFor = Exception.class)
public class DocumentDAOImpl implements DocumentDAO {
	@Autowired
	private SessionFactory sessionFactory;

	// list
	@SuppressWarnings({ "unchecked", "deprecation" })
	public List<Document> getAll(Integer offset, Integer maxResults) {
		 return sessionFactory.openSession().createCriteria(Document.class).setFirstResult(offset!=null?offset:0).setMaxResults(maxResults!=null?maxResults:5).list();
	}
	

		public List<QuyenTruyCap> listQuyen() {
			Session session = sessionFactory.getCurrentSession();
			System.out.println("<br 2 />");
			Query<QuyenTruyCap> query = session.createQuery("from QuyenTruyCap", QuyenTruyCap.class);
			List<QuyenTruyCap> list = (List<QuyenTruyCap>) query.list();
			return list;
		}
	
	
	//count
	@SuppressWarnings("deprecation")
	public Long count() {
        return (Long)sessionFactory.openSession()
                .createCriteria(Document.class)
                .setProjection(Projections.rowCount())
                .uniqueResult();
    }

	// list my draft
	public List<Document> getAllDraft() {
		Session session = sessionFactory.getCurrentSession();
		CriteriaBuilder cb = session.getCriteriaBuilder();
		CriteriaQuery<Document> cq = cb.createQuery(Document.class);
		Root<Document> root = cq.from(Document.class);
		Join<Document, Status> MaTrangThaiJoin = root.join("ma_trang_thai");
		cq.select(root).where(cb.equal(MaTrangThaiJoin.get("ma_trang_thai"), "nhap"));
		List<Document> listDraft = session.createQuery(cq).getResultList();
		return listDraft;
	}

	// list pending approve
	public List<Document> getAllPendingApprove() {
		Session session = sessionFactory.getCurrentSession();
		CriteriaBuilder cb = session.getCriteriaBuilder();
		CriteriaQuery<Document> cq = cb.createQuery(Document.class);
		Root<Document> root = cq.from(Document.class);
		Join<Document, Status> MaTrangThaiJoin = root.join("ma_trang_thai");
		cq.select(root).where(cb.equal(MaTrangThaiJoin.get("ma_trang_thai"), "cho_phe_duyet"));
		List<Document> listPendingApprove = session.createQuery(cq).getResultList();
		return listPendingApprove;
	}

	// list public document
	public List<Document> getAllPublicDocument() {
		Session session = sessionFactory.getCurrentSession();
		CriteriaBuilder cb = session.getCriteriaBuilder();
		CriteriaQuery<Document> cq = cb.createQuery(Document.class);
		Root<Document> root = cq.from(Document.class);
		Join<Document, Status> MaTrangThaiJoin = root.join("ma_trang_thai");
		cq.select(root).where(cb.and(cb.equal(MaTrangThaiJoin.get("ma_trang_thai"), "da_phe_duyet"),
				cb.equal(root.get("quyen_truy_cap"), "all")));
		List<Document> listPublicDocument = session.createQuery(cq).getResultList();
		return listPublicDocument;
	}

	// list category
	public List<Category> listCategory() {
		Session session = sessionFactory.getCurrentSession();
		System.out.println("<br 2 />");
		Query<Category> query = session.createQuery("from Category", Category.class);
		List<Category> listCategory = (List<Category>) query.list();
		return listCategory;
	}

	// ----------------- insert --------------//

	// by draft
	public void saveDraft(final Document document) {
		Session session = this.sessionFactory.getCurrentSession();
		System.out.println("<br 3 />");
		session.persist(document);
	}
	
	// by pending approve

	// ---------------//////////////----------------//
	
	//update
	public void updateDocument(final Document document) {
		Session session = this.sessionFactory.getCurrentSession();
		session.update(document);;
	}
	// delete
	public void delete(final int id) {
		Session session = this.sessionFactory.getCurrentSession();
		Document document = findById(id);
		session.remove(document);
	}
	//accept
	public void accept(final int id) {
		Session session = this.sessionFactory.getCurrentSession();
		Document document = findById(id);
		Status st = new Status();
		st.setMa_trang_thai("da_phe_duyet");
		document.setMa_trang_thai(st);
		session.update(document);
		
	}
	//refuse
		public void refuse(final int id) {
			Session session = this.sessionFactory.getCurrentSession();
			Document document = findById(id);
			Status st = new Status();
			st.setMa_trang_thai("tu_choi");
			document.setMa_trang_thai(st);
			session.update(document);
		}
	// find by id
	public Document findById(final int id) {
		Session session = this.sessionFactory.getCurrentSession();
		return session.get(Document.class, id);
	}
	
	//Upload File
	public Map<String, String> uploadfile(@RequestParam(value="file") CommonsMultipartFile commonsMultipartFiles,HttpServletRequest request,ModelMap modelMap) {
		Map<String, String> result = new HashMap<String, String>();
		String nameFile = commonsMultipartFiles.getOriginalFilename();
		String fileExtension = FilenameUtils.getExtension(commonsMultipartFiles.getOriginalFilename());
		
		System.out.println(fileExtension);
		
		result.put("extensionImage", fileExtension);

		System.out.println(nameFile);
		if(!"".equals(nameFile)){
            //Đường dẫn link đến file
			String dirFile = request.getServletContext().getRealPath("upload");
			//In ra đường link dẫn đến file
			System.out.println(dirFile+"/"+nameFile);
			//In đường link dẫn đến thư mục chứa file
			System.out.println(dirFile);
			File fileDir = new File(dirFile);
			if(!fileDir.exists()){
				fileDir.mkdir();				
			}
			try {
				//Upload file lên sever
				commonsMultipartFiles.transferTo(new File(fileDir+File.separator+nameFile));
				result.put("urlImage","/upload/" + nameFile);
				System.out.println("Upload file thành công!");
//				modelMap.addAttribute("filename", nameFile);
			} catch (Exception e) {
				System.out.println(e.getMessage());
				System.out.println("Upload file thất bại!");
			}
		}
		return result;
	}

}