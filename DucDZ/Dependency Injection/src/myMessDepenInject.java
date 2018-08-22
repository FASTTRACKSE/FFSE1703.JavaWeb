
public class myMessDepenInject {

	public static void main(String[] args) {
		String msg = "xin chao va dmm!";
		String email = "trandraven@gmail.com";
		String phone = "01655144241";
		MessServiceInject inject = null;
		Consumer app = null;
		
		inject = new EmailServiceInject();
		app = inject.getConsumer();
		app.proMess(msg, email);
		
		inject = new EmailServiceInject();
		app = inject.getConsumer();
		app.proMess(msg, phone);
	}

}
