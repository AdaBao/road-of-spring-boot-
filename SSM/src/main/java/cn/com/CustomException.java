package cn.com;

public class CustomException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1956335123L;
	
	private String message;
	public CustomException(String message) {
		this.message=message;
	}
	
	public String getMessage() {
		return this.message;
	}

}
