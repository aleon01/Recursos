package co.edu.unicundi.recursosInvestigacion.exception;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.HttpMediaTypeNotSupportedException;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.MissingPathVariableException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import co.edu.unicundi.recursosInvestigacion.dto.ErrorDTO;



@ControllerAdvice
@RestController
public class ExceptionResponse extends ResponseEntityExceptionHandler{
	
	@ExceptionHandler(ModelNotFoundException.class)
	public ResponseEntity<ErrorDTO> filtroModelNotFoundException(ModelNotFoundException ex, WebRequest request){
		ex.printStackTrace();
		ErrorDTO exp = new ErrorDTO("404", "NOT FOUND", ex.getMessage(), request.getDescription(false));
		return new ResponseEntity<ErrorDTO>(exp, HttpStatus.NOT_FOUND); 
	}
	
	@ExceptionHandler(ArithmeticException.class)
	public ResponseEntity<ErrorDTO> filtroAritmeticException(ArithmeticException ex, WebRequest request){
		ex.printStackTrace();
		ErrorDTO exp = new ErrorDTO(HttpStatus.INTERNAL_SERVER_ERROR.value() + "", HttpStatus.INTERNAL_SERVER_ERROR.toString(), ex.getMessage(), request.getDescription(false));
		return new ResponseEntity<ErrorDTO>(exp, HttpStatus.INTERNAL_SERVER_ERROR); 
	}
	
	@ExceptionHandler(Exception.class)
	public ResponseEntity<ErrorDTO> filtroException(Exception ex, WebRequest request){
		ex.printStackTrace();
		ErrorDTO exp = new ErrorDTO("500", "INTERNAL SERVER ERROR", ex.getMessage(), "Por Averiguar");
		return new ResponseEntity<ErrorDTO>(exp, HttpStatus.INTERNAL_SERVER_ERROR); 
	}

	@Override
	protected ResponseEntity<Object> handleHttpRequestMethodNotSupported(HttpRequestMethodNotSupportedException ex,
			HttpHeaders headers, HttpStatus status, WebRequest request) {
		// TODO Auto-generated method stub
		return super.handleHttpRequestMethodNotSupported(ex, headers, status, request);
	}

	@Override
	protected ResponseEntity<Object> handleHttpMediaTypeNotSupported(HttpMediaTypeNotSupportedException ex,
			HttpHeaders headers, HttpStatus status, WebRequest request) {
		// TODO Auto-generated method stub
		return super.handleHttpMediaTypeNotSupported(ex, headers, status, request);
	}

	@Override
	protected ResponseEntity<Object> handleMissingPathVariable(MissingPathVariableException ex, HttpHeaders headers,
			HttpStatus status, WebRequest request) {
		// TODO Auto-generated method stub
		return super.handleMissingPathVariable(ex, headers, status, request);
	}

	@Override
	protected ResponseEntity<Object> handleHttpMessageNotReadable(HttpMessageNotReadableException ex,
			HttpHeaders headers, HttpStatus status, WebRequest request) {
		// TODO Auto-generated method stub
		return super.handleHttpMessageNotReadable(ex, headers, status, request);
	}

	@Override
	protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex,
			HttpHeaders headers, HttpStatus status, WebRequest request) {
		// TODO Auto-generated method stub
		
		ex.getBindingResult().getFieldErrors().forEach(fieldError ->{
			System.out.println(fieldError.getRejectedValue() + " " + fieldError.getField() + " " + fieldError.getDefaultMessage());
		});
		
		ErrorDTO exp = new ErrorDTO(HttpStatus.BAD_REQUEST.value() + "", HttpStatus.BAD_REQUEST.toString(), ex.getMessage(), request.getDescription(false));
		return new ResponseEntity<Object>(exp, HttpStatus.BAD_REQUEST); 
	}
}
