package Test.Hello;

public class HelloWorld {
	private String message;
	public void setMessage(String mes) {
		this.message = mes;
	}
	public void getMessage() {
		System.out.println("Your message : "+message);
	}
}
