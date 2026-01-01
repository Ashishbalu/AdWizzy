package adWizzy.backend.exception;

import adWizzy.backend.dto.ApiErrorResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(AiGenerationException.class)
    public ResponseEntity<ApiErrorResponse> handleAiException(AiGenerationException ex){

        ApiErrorResponse apiErrorResponse = new ApiErrorResponse(
                "Error",
                ex.getMessage()
        );

        return new ResponseEntity<>(apiErrorResponse, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    public ResponseEntity<ApiErrorResponse> handleGenericException(Exception e){
        ApiErrorResponse apiErrorResponse = new ApiErrorResponse(
                "Error",
                "Somethng went wrong. Please try again later."
        );
        return new ResponseEntity<>(apiErrorResponse, HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
