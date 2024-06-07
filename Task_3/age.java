package Task_3;

public class age extends RuntimeException {
	private String msg="enter the positive value";
	
	public age(String msg) {
		super();
		this.msg = msg;
	}
	
	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}
	

	@Override
	public String toString() {
		return "age [msg=" + msg + "]";
	}

	public age() {
		super();
		
	}
}
