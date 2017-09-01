
public enum Status {

	ACCEPTED("accepted"), REJECTED("rejected"), PENDING("pending");
	public String status;
	private Status(String status) {
		this.status = status;
	}
}
