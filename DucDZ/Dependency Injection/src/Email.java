
public class Email implements MessService{
	public void sendMess(String msg, String rec) {
		System.out.println("Email sent to "+rec+" with Message = "+msg);
	}
}
