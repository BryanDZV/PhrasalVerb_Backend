package com.bryanzavala.phrasalgame.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ProblemDetail;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/*Un único sitio traduce excepciones a respuestas.
Los controllers quedan sin try/catch, y el front recibe
 siempre el mismo formato de error.*/
@RestControllerAdvice //intercepta los controladores y maneja las excepciones de manera global.
public class GlobalExceptionHandler {
    //intercepta cualquier error exception de los controladores y la maneja
    @ExceptionHandler(GameNotFoundException.class)
    public ProblemDetail handleGameNotFoundException(GameNotFoundException ex){
        return ProblemDetail.forStatusAndDetail(HttpStatus.NOT_FOUND, ex.getMessage());
    }
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ProblemDetail handleValidationErrors(MethodArgumentNotValidException ex) {
        ProblemDetail problem = ProblemDetail.forStatusAndDetail(
                HttpStatus.BAD_REQUEST,
                "Hay errores de validación en los datos enviados"
        );
        problem.setTitle("Error de validación");
        return problem;
    }

}
