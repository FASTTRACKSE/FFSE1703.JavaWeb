package bean;

import org.springframework.stereotype.Component;

@Component
public class HocKi1 implements HocKi {
	public String hocKi() {
		return "Mời Bạn đi học buổi tối từ 18h30 đến 21h30";
	}
}
