package Task_3;

public class id extends RuntimeException {
	private String msg="id most be in unique";

	public id(String msg) {
		super();
		this.msg = msg;
	}
 
	@Override
	public String toString() {
		return "id [msg=" + msg + "]";
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	public id() {
		super();
		
	}
	
}
