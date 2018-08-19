package utils;


/** ExceptionUtility wraps standered java checked exceptions and sets the cause of exception and lets user know the cause of exception
 *
 * @author Ajit Vedpathak
 */


public class ExceptionUtility extends Exception {
    ErrorCodes errorCode;
    //String message = "File is not present at the location";

    public ExceptionUtility(ErrorCodes errorCode) {
        super();

        this.errorCode = errorCode;
    }

    public ExceptionUtility(ErrorCodes errorCode, String message) {
        super(message);
        this.errorCode = errorCode;
    }

    public ExceptionUtility(ErrorCodes errorCode, String message, Exception cause) {
        super(message, cause);
        this.errorCode = errorCode;
    }

	public ExceptionUtility(int noSuchElement) {
		super(String.valueOf(noSuchElement));
	}

}
