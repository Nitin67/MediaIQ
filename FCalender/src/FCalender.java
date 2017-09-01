import java.util.ArrayList;
import java.util.List;

public class FCalender {
	
	private List<Meeting> acceptedMeetings;
	private List<Meeting> pendingMeetings;
	public FCalender() {
		acceptedMeetings= new ArrayList<>();
		pendingMeetings= new ArrayList<>();
	}
	public List<Meeting> getAcceptedMeetings() {
		return acceptedMeetings;
	}
	public void setAcceptedMeetings(List<Meeting> acceptedMeetings) {
		this.acceptedMeetings = acceptedMeetings;
	}
	public List<Meeting> getPendingMeetings() {
		return pendingMeetings;
	}
	public void setPendingMeetings(List<Meeting> pendingMeetings) {
		this.pendingMeetings = pendingMeetings;
	}
	
	
}
