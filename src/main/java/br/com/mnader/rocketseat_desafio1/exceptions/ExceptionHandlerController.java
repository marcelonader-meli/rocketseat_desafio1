package br.com.mnader.rocketseat_desafio1.exceptions;

import java.util.ArrayList;
import java.util.List;

import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ExceptionHandlerController {
    
    private MessageSource messageSource;

    public ExceptionHandlerController(MessageSource message) {
        this.messageSource = message;
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ErrorMessage> handlerException(Exception ex) {
        return new ResponseEntity<>(new ErrorMessage(ex.getMessage(), null), HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(RuntimeException.class)
    public ResponseEntity<ErrorMessage> handlerRuntimeException(RuntimeException ex) {
        return new ResponseEntity<>(new ErrorMessage(ex.getMessage(), null), HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<List<ErrorMessage>> handlerMethodArgumentNotValidException(MethodArgumentNotValidException ex) {
        List<ErrorMessage> errorList = new ArrayList<ErrorMessage>();
        ex.getBindingResult().getFieldErrors().forEach(err -> {
            String message = messageSource.getMessage(err, LocaleContextHolder.getLocale());
            ErrorMessage error = new ErrorMessage(message, err.getField());
            errorList.add(error);
        });

        return new ResponseEntity<>(errorList, HttpStatus.BAD_REQUEST);
    }
}
