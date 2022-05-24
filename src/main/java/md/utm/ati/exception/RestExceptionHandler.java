package md.utm.ati.exception;

import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.time.LocalDateTime;
import java.util.LinkedHashMap;
import java.util.Map;

@Order(Ordered.HIGHEST_PRECEDENCE)
@ControllerAdvice
public class RestExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(NotFoundException.class)
    protected ResponseEntity<Object> handleEntityNotFound(NotFoundException ex) {

        Map<String, Object> body = new LinkedHashMap<>();
        body.put("message", ex.getMessage());
        body.put("status", HttpStatus.NOT_FOUND);
        body.put("timestamp", LocalDateTime.now());

        return new ResponseEntity<>(body, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(BadRequestException.class)
    protected ResponseEntity<Object> handleEntityBadRequest(BadRequestException ex) {

        Map<String, Object> body = new LinkedHashMap<>();
        body.put("message", ex.getMessage());
        body.put("status", HttpStatus.BAD_REQUEST);
        body.put("timestamp", LocalDateTime.now());

        return new ResponseEntity<>(body, HttpStatus.BAD_REQUEST);
    }
}
