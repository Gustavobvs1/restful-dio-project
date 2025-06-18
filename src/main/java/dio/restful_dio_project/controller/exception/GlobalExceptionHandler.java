package dio.restful_dio_project.controller.exception;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.NoSuchElementException;

@RestControllerAdvice
public class GlobalExceptionHandler {

    private final Logger logger = LoggerFactory.getLogger(GlobalExceptionHandler.class);

    @ResponseStatus(HttpStatus.CONFLICT)
    @ExceptionHandler(IllegalArgumentException.class)
    public ResponseEntity<String> handleConflict(IllegalArgumentException conflictException) {
        return new ResponseEntity<>(conflictException.getMessage(),  HttpStatus.CONFLICT);
    }

    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ExceptionHandler(NoSuchElementException.class)
    public ResponseEntity<String> handleMissing(NoSuchElementException missingException) {
        return new ResponseEntity<>("Resouce ID not found", HttpStatus.NOT_FOUND);
    }

    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    @ExceptionHandler(Throwable.class)
    public ResponseEntity<String> handleBusinessException(Throwable unexpectedException) {
        var message = "Unexpected server error, see the logs";
        logger.error(message,unexpectedException);
        return new ResponseEntity<>(message,  HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
