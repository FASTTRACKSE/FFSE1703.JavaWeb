package phuongtrinhbac1.service;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

@ManagedBean(name = "ptService")
@SessionScoped
public class PhuongTrinhService {
	public String sum(float a, float b) {
		String resuilt;
		if(a==0) {
			if(b==0) {
				resuilt ="Phương trình có vô số nghiệm";
			}else {
				resuilt ="Phương trình có vô nghiệm";
			}
		}else {
			if(b==0) {
				resuilt ="Phương có nghiệm là : 0 ";
			}else {
				resuilt ="Phương có nghiệm là : " + (-b/a);
			}
		}
		return resuilt;
	}
}
