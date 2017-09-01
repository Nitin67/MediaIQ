package coding.designpattern.observer;

public interface Subject {
	
	void registerObserver(Observer observer);
	void unregisterObserver(Observer observer);
	void notifyObserver();
}
