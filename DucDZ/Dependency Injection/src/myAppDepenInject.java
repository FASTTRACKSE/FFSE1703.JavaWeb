
public class myAppDepenInject implements Consumer {
	private MessService mesService;

	public myAppDepenInject(MessService svc) {
		this.mesService = svc;
	}

	public void proMess(String msg, String rec) {
		this.mesService.sendMess(msg, rec);
	}

}
