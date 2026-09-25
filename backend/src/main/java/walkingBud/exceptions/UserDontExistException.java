package walkingBud.exceptions;

public class UserDontExistException extends RuntimeException {
    public UserDontExistException() {
        super("User does not exist");
    }
}
