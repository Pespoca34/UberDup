package walkingBud.exceptions;

public class AlreadyExistUser extends RuntimeException {

    public AlreadyExistUser() {
        super("User already exists");
    }
}
