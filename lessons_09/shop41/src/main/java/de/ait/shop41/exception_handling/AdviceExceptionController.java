package de.ait.shop41.exception_handling;

import de.ait.shop41.exception_handling.exceptions.ProductNotFoundException;
import de.ait.shop41.exception_handling.exceptions.ValidationErrorsResponse;
import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.List;

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

    // перехватываем этот экзепшен, что бы далее его обрабатывать
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ValidationErrorsResponse> validateExceptionsHandler(MethodArgumentNotValidException e, HttpServletRequest req) {
        // HttpServletRequest req - spring возвращает url, из запроса который пришол на сервер

        List<ValidationError> list = e.getBindingResult()
                .getAllErrors()
                .stream()
                .map(objectError -> (FieldError) objectError)
                .map(ValidationError::of)
                .toList();

        ValidationErrorsResponse validationErrors = new ValidationErrorsResponse(req.getMethod(),req.getServletPath(), "Validation errors", list);

        return new ResponseEntity<>(validationErrors, HttpStatus.BAD_REQUEST);

//        System.out.println("--------" + e.getMessage());
//        return new ResponseEntity<>(e.getMessage().toString(), HttpStatus.I_AM_A_TEAPOT);
    }

}
