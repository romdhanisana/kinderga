package tn.esprit.esponline.exceptions;

public class SubredditNotFoundException extends RuntimeException {
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public SubredditNotFoundException(String message) {
        super(message);
    }
}
