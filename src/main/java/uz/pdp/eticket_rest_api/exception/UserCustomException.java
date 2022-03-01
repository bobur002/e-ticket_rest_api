package uz.pdp.eticket_rest_api.exception;

public class UserCustomException extends RuntimeException {
    public UserCustomException(String message) {
        super(message);
    }
}
