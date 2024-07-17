package de.ait.shop41.exception_handling.exceptions;

import de.ait.shop41.exception_handling.ValidationError;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ValidationErrorsResponse {

    private String method;
    private String url;
    private String message;
    private List<ValidationError> validationErrors;

}
