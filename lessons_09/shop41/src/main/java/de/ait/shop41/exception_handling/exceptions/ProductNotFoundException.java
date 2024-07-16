package de.ait.shop41.exception_handling.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.NOT_FOUND, reason = "Product not found")
public class ProductNotFoundException extends GeneralApiException{
    public ProductNotFoundException(String message){
        super(message);
    }
}
