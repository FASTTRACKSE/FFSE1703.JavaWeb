package Bean;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

@ManagedBean(name= "nam")
@SessionScoped
public class helloBean {
	private String name;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String submit() {
		return "ketqua?faces-redirect=true";
	}
	
}
