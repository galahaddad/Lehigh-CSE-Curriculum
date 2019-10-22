public class InvalidTimeException extends Exception{
    private static final long serialVersionUID = 1L;    
    public InvalidTimeException() {
        super("Invalid Time.");
    }
    public InvalidTimeException(String input) {
        super(input);
    }
}