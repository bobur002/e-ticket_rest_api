package uz.pdp.eticket_rest_api.config;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;
import uz.pdp.eticket_model.model.response.ApiExceptionResponse;
import uz.pdp.eticket_rest_api.exception.UserCustomException;

@ControllerAdvice
public class RestExceptionHandler extends ResponseEntityExceptionHandler {

    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(
            MethodArgumentNotValidException ex,
            HttpHeaders headers,
            HttpStatus status,
            WebRequest request) {
        ApiExceptionResponse apiExceptionResponse = new ApiExceptionResponse();
        apiExceptionResponse.setError(ex.getMessage());
        apiExceptionResponse.setStatusCode(HttpStatus.BAD_REQUEST.value());
        return ResponseEntity.ok(apiExceptionResponse);
    }

    @ExceptionHandler(UserCustomException.class)
    public ResponseEntity<Object> handleUserException(UserCustomException exception) {
        ApiExceptionResponse apiExceptionResponse
                = new ApiExceptionResponse();
        apiExceptionResponse.setError(exception.getMessage());
        apiExceptionResponse.setStatusCode(HttpStatus.BAD_REQUEST.value());
        return ResponseEntity.ok(apiExceptionResponse);
    }

}
