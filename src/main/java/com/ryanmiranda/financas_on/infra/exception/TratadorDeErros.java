package com.ryanmiranda.financas_on.infra.exception;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.NoSuchElementException;
import java.util.stream.Collectors;

@RestControllerAdvice
public class TratadorDeErros {

    @ExceptionHandler(NoSuchElementException.class)
    public ResponseEntity tratarErro404(){
        return ResponseEntity.notFound().build();
    }
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity tratarErro400(MethodArgumentNotValidException ex){
        var erro = ex.getFieldErrors();

        return ResponseEntity.badRequest().body(erro.stream().map(DadosErrosValidacao::new).collect(Collectors.toList()));
    }

    private record DadosErrosValidacao(String campo, String mensagem){

        public DadosErrosValidacao(FieldError fieldError){
            this(fieldError.getField(), fieldError.getDefaultMessage());
        }

    }
}
