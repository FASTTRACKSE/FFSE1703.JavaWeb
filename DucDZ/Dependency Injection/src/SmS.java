
public class SmS implements MessService{
	public void sendMess(String msg,String rec) {
		System.out.println("SmS sent to "+rec+" with mess = "+msg);
	}
}
