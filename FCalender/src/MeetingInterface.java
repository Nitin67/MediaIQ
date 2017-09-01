import java.util.List;

import javax.activity.InvalidActivityException;

public interface MeetingInterface {
	
	boolean createMeeting(Person creator, TimeSlot slot, List<Person> attendies, String heading) throws InvalidActivityException;
	boolean updateMeeting(Meeting meeting);
	boolean deleteMeeting(Meeting meetingId);
}
