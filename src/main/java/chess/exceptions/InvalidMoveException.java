package chess.exceptions;

public class InvalidMoveException extends RuntimeException {
	private static final long serialVersionUID = -6089380907515382982L;

	public InvalidMoveException() {
		super();
	}

	public InvalidMoveException(String message) {
		super(message);
	}

	public InvalidMoveException(Throwable cause) {
		super(cause);
	}

	public InvalidMoveException(String message, Throwable cause) {
		super(message, cause);
	}

	public InvalidMoveException(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

}
