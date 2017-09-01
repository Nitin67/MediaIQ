import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.activity.InvalidActivityException;

public class Meeting implements Subject{

	private long meetingId;
	final private Person creator;
	private List<Person> pendingAttendies;
	private List<Person> acceptedAttendies;
	private File attachment;
	private String heading;
	private String detail;
	private TimeSlot slot;
	
	
	public Meeting(String heading, Person creator, TimeSlot slot, List<Person> persons) throws InvalidActivityException {
		this.heading = heading;
		this.creator = creator;
		this.slot = slot;
		acceptedAttendies = new ArrayList<>();
		if(this.slot == null)
			throw new InvalidActivityException();
		if(persons !=null && persons.size() >=1)
			this.setPendingAttendies(persons);
		else
			throw new InvalidActivityException();
		
		notifyObserver();
	}
	
	public void updateMeeting(Meeting meeting){
		setSlot(meeting.getSlot());
		setAcceptedAttendies(meeting.getAcceptedAttendies());
		setPendingAttendies(meeting.getPendingAttendies());
		setHeading(meeting.getHeading());
		notifyObserver();
	}
	public void deleteMeeting(){
		this.slot=null;
		notifyObserver();
	}
	public String getDetail() {
		return detail;
	}

	public void setDetail(String detail) {
		this.detail = detail;
	}

	public TimeSlot getSlot() {
		return slot;
	}

	public void setSlot(TimeSlot slot) {
		this.slot = slot;
	}


	public File getAttachment() {
		return attachment;
	}

	public void setAttachment(File attachment) {
		this.attachment = attachment;
	}

	public String getHeading() {
		return heading;
	}

	public void setHeading(String heading) {
		this.heading = heading;
	}

	public Person getCreator() {
		return creator;
	}

	public long getMeetingId() {
		return meetingId;
	}

	public void setMeetingId(long meetingId) {
		this.meetingId = meetingId;
	}

	@Override
	public void register(Observer o) {
		pendingAttendies.add((Person)o);
		
	}

	@Override
	public void unregister(Observer o) {
		pendingAttendies.remove((Person)o);
	}

	@Override
	public void notifyObserver() {
		for (Iterator iterator = acceptedAttendies.iterator(); iterator.hasNext();) {
			Person person = (Person) iterator.next();
			person.update(slot,  heading, this, Status.ACCEPTED.status);
		}
		for (Iterator iterator = pendingAttendies.iterator(); iterator.hasNext();) {
			Person person = (Person) iterator.next();
			person.update(slot,   heading, this, Status.PENDING.status);
		}
		
	}

	public List<Person> getAcceptedAttendies() {
		return acceptedAttendies;
	}

	public void setAcceptedAttendies(List<Person> acceptedAttendies) {
		this.acceptedAttendies = acceptedAttendies;
	}

	public List<Person> getPendingAttendies() {
		return pendingAttendies;
	}

	public void setPendingAttendies(List<Person> pendingAttendies) {
		this.pendingAttendies = pendingAttendies;
	}
	public void acceptMeeting(Person person){
		pendingAttendies.remove(person);
		acceptedAttendies.add(person);
	}
	public void rejectMeeting(Person person){
		pendingAttendies.remove(person);
	}
}
