
public interface Subject {

	void registerObservor(Observor observor);
	void unregisterObservor(Observor observor);
	void notifyObservor();
	
}
