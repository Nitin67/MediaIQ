
public class ConsoleObservor implements Observor{

	public ConsoleObservor(Subject subject) {
		subject.registerObservor(this);
	}
	@Override
	public void update(Message message) {
		
	}

}
