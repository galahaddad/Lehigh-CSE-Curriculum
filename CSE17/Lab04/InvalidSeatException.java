
/**
 * InvalidSeatException
 */
public class InvalidSeatException extends Exception{
    private static final long serialVersionUID = 1L;    
    public InvalidSeatException() {
        super("Invalid");
    }
    public InvalidSeatException(String input) {
        super(input);
    }
}