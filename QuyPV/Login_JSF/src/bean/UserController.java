package bean;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;

import com.sun.xml.internal.messaging.saaj.packaging.mime.MessagingException;
import com.sun.xml.internal.ws.protocol.soap.MessageCreationException;

import dao.DAO;

@ManagedBean(name= "userController")
@SessionScoped
public class UserController {
	DAO userDao = new DAO();
	private  FacesContext facesContex;
	public  HttpSession session;
	public String checkLogin(String user, String pass) {
		int kt = userDao.check(user, pass);
		
		if(kt == 1) {

			facesContex = FacesContext.getCurrentInstance();
			session = (HttpSession) facesContex.getExternalContext().getSession(false);
			
			session.setAttribute("userName", user);
			System.out.println("session " + session.getAttribute("userName"));
			return "admin?faces-redirect=true";
		} else {
			FacesContext faceContext = FacesContext.getCurrentInstance();
			FacesMessage facemessage = new FacesMessage("Sai tên Tài khoản hoặc mật khẩu");
			faceContext.addMessage(null, facemessage);
	
			return "index?faces-redirect=true";
		}
		
		
	}
	
	public String logout() {
		
		session.invalidate();
		return "index?faces-redirect=true";
	}
	
	public String go() {
		System.out.println("session " + session.getAttribute("userName"));
		return "a?faces-redirect=true";
	}
}
