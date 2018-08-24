
public class SmSServiceInject implements MessServiceInject{
	public Consumer getConsumer() {
		return new myAppDepenInject(new SmS());
	}
}
