package com.indusnet.exeption;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.NoHandlerFoundException;

@ControllerAdvice
public class GlobalExceptionHandler {

	
	@ExceptionHandler(UserException.class)
	public ResponseEntity<MyError> myExceptionHandler(UserException ue, WebRequest wr){
		MyError err= new MyError(LocalDateTime.now(),ue.getMessage(), wr.getDescription(false));
		
		return new ResponseEntity<MyError>(err, HttpStatus.BAD_REQUEST);
	}
	
	@ExceptionHandler(ResponceException.class)
	public ResponseEntity<ResponceError> adminExceptionHandler(ResponceException ame, WebRequest wr){
		ResponceError res= new ResponceError(401, "Not Authorized", ame.getMessage());
		return new ResponseEntity<ResponceError>(res, HttpStatus.BAD_REQUEST);
	}
	
//	@ExceptionHandler(NoHandlerFoundException.class)
//	public ResponseEntity<MyError> mynotFoundHandler(NoHandlerFoundException nfe,WebRequest req)  {
//		
//		MyError err=new MyError(LocalDateTime.now(), nfe.getMessage(), req.getDescription(false));
//
//	return new ResponseEntity<MyError>(err,HttpStatus.NOT_FOUND);
//	}
	
	
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseEntity<Map<String, String>> myMANVExceptionHandler(MethodArgumentNotValidException me) {
	
		Map<String, String> errorMap= new HashMap<>();
		me.getBindingResult().getFieldErrors().forEach(error ->
		{
			errorMap.put(error.getField(), error.getDefaultMessage());
		});
		
		//MyError err=new MyError(LocalDateTime.now(),"Validation Error",me.getBindingResult().getFieldError().getDefaultMessage());
	return new ResponseEntity<>(errorMap,HttpStatus.BAD_REQUEST);
	}
	
	
	
//	public ResponseEntity<MyError> myExcHandler(Exception e, WebRequest wr){
//		MyError err=new MyError(LocalDateTime.now(),e.getMessage(), wr.getDescription(false));
//		
//		return new ResponseEntity<MyError>(err, HttpStatus.BAD_REQUEST);
//	}
}
