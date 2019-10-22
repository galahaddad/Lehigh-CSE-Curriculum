public class InvalidDateException extends Exception{
    private static final long serialVersionUID = 1L;    
    public InvalidDateException() {
        super("Invalid Date.");
    }
    public InvalidDateException(String input) {
        super(input);
    }
}