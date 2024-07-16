package de.ait.shop41.exception_handling;

import de.ait.shop41.exception_handling.exceptions.ProductNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
// зависит от этой анотации - этот метод не зависит от того, какой контроллер вызвал метод
@RequiredArgsConstructor
public class AdviceExceptionController {

    // этот метод не зависит от того, какой контроллер вызвал метод
    @ExceptionHandler(ProductNotFoundException.class)
    public ResponseEntity<ApiExceptionInfo> productNotFoundHandler(Exception e) {
        System.out.println("3 вариант");
        return new ResponseEntity<ApiExceptionInfo>(new ApiExceptionInfo(e.getMessage()), HttpStatus.NOT_FOUND);
    }

}
