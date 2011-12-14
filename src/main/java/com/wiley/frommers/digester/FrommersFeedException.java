package com.wiley.frommers.digester;

public class FrommersFeedException extends Exception {

    private static final long serialVersionUID = 8582003553996245759L;

	public FrommersFeedException() {
        super();
    }

    public FrommersFeedException(String message, Throwable cause) {
        super(message, cause);
    }

    public FrommersFeedException(String message) {
        super(message);
    }

    public FrommersFeedException(Throwable cause) {
        super(cause);
    }
}