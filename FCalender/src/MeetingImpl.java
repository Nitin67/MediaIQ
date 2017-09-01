import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.activity.InvalidActivityException;

public class MeetingImpl implements MeetingInterface{

	@Override
	public boolean createMeeting(Person creator, TimeSlot slot, List<Person> attendies, String heading) throws InvalidActivityException {
		new Meeting(heading, creator, slot, attendies);
		return true;
	}

	@Override
	public boolean updateMeeting(Meeting meeting) {
		meeting.updateMeeting(meeting);
		return true;
	}

	@Override
	public boolean deleteMeeting(Meeting meeting) {
		meeting.deleteMeeting();
		return true;
	}

	public static void main(String[] args) throws InvalidActivityException {
		Person person= new Person();
		person.setName("Flip1");
		person.setId(0);
		
		Person person1= new Person();
		person1.setId(1);
		
		Person person2= new Person();
		person2.setId(2);
		
		 TimeSlot slot = new TimeSlot();
		 slot.setStartTime(new Date());
		 slot.setEndTime(new Date());
		 List<Person> attendies = new ArrayList<>();
		 attendies.add(person2);
		 attendies.add(person1);
		 Meeting meeting=new Meeting("Testing meeting", person, slot, attendies);
		 
		 System.out.println(person1.getCalender().getPendingMeetings());
		 System.out.println(person1.getCalender().getAcceptedMeetings());
		 System.out.println(person2.getCalender().getPendingMeetings());
		 System.out.println(person2.getCalender().getAcceptedMeetings());
	}
}
