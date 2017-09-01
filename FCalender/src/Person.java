import java.util.Iterator;
import java.util.List;

public class Person implements Observer{
	private String name;
	private long id;
	private FCalender calender = new FCalender();
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public FCalender getCalender() {
		return calender;
	}
	public void setCalender(FCalender calender) {
		this.calender = calender;
	}

	@Override
	public void update(TimeSlot slot, String heading, Meeting meeting, String status) {
		if(slot == null){
			if(status == Status.ACCEPTED.status)
				calender.getAcceptedMeetings().remove(meeting);
			else if(status == Status.PENDING.status)
				calender.getPendingMeetings().remove(meeting);
			
			sendMail("Meeting cancelled", slot, heading);
		}
		else
		{
			if(status.equals(Status.ACCEPTED.status)){
				if(!calender.getAcceptedMeetings().contains(meeting)){
					calender.getAcceptedMeetings().add(meeting);
				}
			}
			else if(status.equals(Status.PENDING.status)){
				if(!calender.getPendingMeetings().remove(meeting)){
					calender.getPendingMeetings().add(meeting);
				}
			}
			sendMail("Meeting udpated", slot, heading);
		}
			
		
		
	}
	public void sendMail(String message, TimeSlot slot, String heading){
		System.out.println(this.id+ ":" + message + slot + heading);
	}
	
	public void updatePendingMeeting(){
		List<Meeting> meetings = calender.getPendingMeetings();
		for (Iterator iterator = meetings.iterator(); iterator.hasNext();) {
			Meeting meeting = (Meeting) iterator.next();
			
			meeting.acceptMeeting(this);
			meeting.getAcceptedAttendies().add(this);
			meeting.updateMeeting(meeting);
		}
	}
	
}
