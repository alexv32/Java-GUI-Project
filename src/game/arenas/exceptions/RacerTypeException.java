package game.arenas.exceptions;
/**
 * @author shmuel moha 204568323
 * @author alex weizman 314342064
 *
 */
public class RacerTypeException extends Exception {

	
	private static final long serialVersionUID = 1L;

	public RacerTypeException() {
	 super();
	}
	/**
	 * shows an exception message
	 * @param message
	 */
	public RacerTypeException(String message) {
		super(message);
		
	}
	/**
	 * throw an exception cause
	 * @param cause
	 */
	public RacerTypeException(Throwable cause) {
		super(cause);
		
	}
	public RacerTypeException(String message, Throwable cause) {
		super(message,cause);
		
	}


}
