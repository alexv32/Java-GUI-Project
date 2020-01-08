package game.arenas.exceptions;
/**
 * @author shmuel moha 204568323
 * @author alex weizman 314342064
 *
 */
public class RacerLimitException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public RacerLimitException() {
		
	}
	/**
	 * shows an exception message
	 * @param arg0
	 */
	public RacerLimitException(String arg0) {
		super(arg0);
		
	}
	/**
	 * throw an exception cause
	 * @param cause
	 */
	public RacerLimitException(Throwable cause) {
		super(cause);
		
	}
	
	public RacerLimitException(String message, Throwable cause) {
		super(message, cause);
	}

	public RacerLimitException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
		
	}

}
