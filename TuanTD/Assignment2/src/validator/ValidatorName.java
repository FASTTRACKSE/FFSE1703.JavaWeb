package validator;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.FacesValidator;
import javax.faces.validator.Validator;
import javax.faces.validator.ValidatorException;

import com.jsf.crud.db.operations.DatabaseOperation;

@FacesValidator("validator.validatorName")
public class ValidatorName implements Validator {
	public DatabaseOperation databaseOperation =new DatabaseOperation();
	
	public void validate(FacesContext facesContext, UIComponent component, Object value) throws ValidatorException {
		int exist = databaseOperation.checkExist(value.toString());
		if(exist == 1) {
//			System.out.println(sinhVienDao.checkExist(value.toString()) + "là số lượng");
//			System.out.println(value.toString());
			FacesMessage msg = new FacesMessage("Mã sinh viên đã tồn tại. Vui lòng nhập lại");
			msg.setSeverity(FacesMessage.SEVERITY_ERROR);
			throw new ValidatorException(msg);
		}
	}
}
