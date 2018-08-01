package model.bean;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.ValidatorException;

import model.dao.StudentDAO;
@ManagedBean
@SessionScoped
public class Validator {
	public void checkEmail(FacesContext facesContext, UIComponent component, Object value) throws ValidatorException {
		int check = StudentDAO.checkEmail(value.toString());
		if(check >= 1) {
			FacesMessage msg = new FacesMessage("Email đã tồn tại. Vui lòng nhập lại");
			msg.setSeverity(FacesMessage.SEVERITY_ERROR);
			throw new ValidatorException(msg);
		}
	} 
	
}
