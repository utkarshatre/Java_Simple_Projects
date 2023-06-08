package customexception;

public class StudentnotfoundException extends RuntimeException{
	private String message;
	public StudentnotfoundException(String message) {
		this.message=message;
	}
	@Override
	public String getMessage() {
		return message;
	}
}
