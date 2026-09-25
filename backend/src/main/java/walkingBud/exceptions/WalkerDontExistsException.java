package walkingBud.exceptions;

public class WalkerDontExistsException extends RuntimeException {
    public WalkerDontExistsException() {
        super("Walker Dont Exists");
    }
}
