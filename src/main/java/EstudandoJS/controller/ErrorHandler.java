package EstudandoJS.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ErrorHandler {

    @ExceptionHandler(RuntimeException.class)
    public ResponseEntity<String> operacaoInvalida(RuntimeException e) {
        return new ResponseEntity<>("Deu um: " + e.getMessage(), HttpStatus.BAD_REQUEST);
    }
}
