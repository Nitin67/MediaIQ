
public class DBObservor implements Observor{

	public DBObservor(Subject subject) {
		subject.registerObservor(this);
	}
	
	@Override
	public void update(Message message) {
		
	}

}
