package fasttrackse.ffse1703.fbms.service.qttl;

import java.util.List;
import java.util.Map;


import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import fasttrackse.ffse1703.fbms.dao.qttl.*;
import fasttrackse.ffse1703.fbms.entity.qttl.*;

@Service
public class DocumentServiceImpl implements DocumentService {

	@Autowired
	private DocumentDAO documentDAO;

	// list
	@Transactional
	public List<Document> getAll(Integer offset, Integer maxResult) {
		return documentDAO.getAll(offset, maxResult);
	}
	
	//count
	public Long count() {
        return documentDAO.count();
    }
	//finbyid
	public Document findById(int id){
		return documentDAO.findById(id);
	}
	
	// list my draft
	public List<Document> getAllDraft(){
		return documentDAO.getAllDraft();
	}
	
	// list pending approve
	public List<Document> getAllPendingApprove(){
		return documentDAO.getAllPendingApprove();
	}
	
	//list public document
	public List<Document> getAllPublicDocument(){
		return documentDAO.getAllPublicDocument();
	}
			 
	//------------    insert    --------------------//
	// by draft
	public void saveDraft(Document document) {
		documentDAO.saveDraft(document);
	}
	// by pending approve
	
	//---------------------------------------------//
	
	//delete
	public void delete(int id) {
		documentDAO.delete(id);
	}
	
	//accept
	public void accept(int id) {
		documentDAO.accept(id);
	}
	//refuse 
		public void refuse(int id) {
			documentDAO.refuse(id);
		}	
	
	//update
	public void updateDocument(Document document) {
		documentDAO.updateDocument(document);
	}

	// list category
	public List<Category> listCategory() {
		return documentDAO.listCategory();
	}
	
	//upload file 
	public Map<String, String> uploadfile(@RequestParam(value="file") CommonsMultipartFile commonsMultipartFiles,HttpServletRequest request,ModelMap modelMap) {
		return documentDAO.uploadfile(commonsMultipartFiles, request, modelMap);
	}
	@Override
	@Transactional
	public List<QuyenTruyCap> listQuyen(){
		return documentDAO.listQuyen();
	}

}