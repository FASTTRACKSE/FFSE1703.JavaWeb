
public class EmailServiceInject implements MessServiceInject{
	public Consumer getConsumer() {
		return new myAppDepenInject(new Email());
	}
}
