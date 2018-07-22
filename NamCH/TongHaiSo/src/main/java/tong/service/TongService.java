package tong.service;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

@ManagedBean(name ="tb")
@SessionScoped
public class TongService {
	public int sum(int a,int b) {
		return a+b;
	}
}
