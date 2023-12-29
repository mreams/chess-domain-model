package main.java.chess.exceptions;

public class NoPieceFoundException extends RuntimeException {
	private static final long serialVersionUID = -6733534163401000528L;

	public NoPieceFoundException(String message, Throwable cause) {
		super(message, cause);
	}

	public NoPieceFoundException(String message) {
		super(message);
	}
	
	public NoPieceFoundException() {
		super();
	}

	public NoPieceFoundException(Throwable cause) {
		super(cause);
	}

	public NoPieceFoundException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}
}
