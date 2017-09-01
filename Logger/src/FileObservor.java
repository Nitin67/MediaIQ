
public class FileObservor implements Observor{

	public FileObservor(Subject subject) {
		subject.registerObservor(this);
	}
	@Override
	public void update(Message message) {
		// TODO Auto-generated method stub
		
	}

}
