package validator;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.FacesValidator;
import javax.faces.validator.Validator;
import javax.faces.validator.ValidatorException;

import bean.DAO;

@FacesValidator("validator.validatorMaSv")
public class ValidatorMaSv implements Validator {
	public DAO sinhVienDao = new DAO();
	
	public void validate(FacesContext facesContext, UIComponent component, Object value) throws ValidatorException {
		int exist = sinhVienDao.checkExist(value.toString());
		if(exist == 1) {
//			System.out.println(sinhVienDao.checkExist(value.toString()) + "là số lượng");
//			System.out.println(value.toString());
			FacesMessage msg = new FacesMessage("Mã sinh viên đã tồn tại. Vui lòng nhập lại");
			msg.setSeverity(FacesMessage.SEVERITY_ERROR);
			throw new ValidatorException(msg);
		}
	}
}
