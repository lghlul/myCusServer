package customer.supu.exception;

public class msgException extends Exception{
	/**
	 *
	 */
	private static final long serialVersionUID = 101291982108L;
    private String message;

    public msgException(String message){
        super(message);
        this.message=message;
    }


    public String getMessage() {
        return message;
    }


    public void setMessage(String message) {
        this.message = message;
    }
}


