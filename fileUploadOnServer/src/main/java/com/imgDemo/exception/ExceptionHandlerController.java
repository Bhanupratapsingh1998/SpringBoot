package com.imgDemo.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.multipart.MaxUploadSizeExceededException;

import com.imgDemo.payload.ApiResponse;

@ControllerAdvice
public class ExceptionHandlerController {
	 @ExceptionHandler(FileNotFoundException.class)
	   public ResponseEntity<Object> FileNotFoundException(FileNotFoundException ex) {
		   ApiResponse errorResponse = new ApiResponse();
		   errorResponse.setStatus_code(404);
		   errorResponse.setMessage(ex.getMessage());
	      return new ResponseEntity<Object>(errorResponse, HttpStatus.NOT_FOUND);
	   }
	 @ExceptionHandler(FileStorageException.class)
	   public ResponseEntity<Object> FileStorageException(FileStorageException ex) {
		   ApiResponse errorResponse = new ApiResponse();
		   errorResponse.setStatus_code(400);
		   errorResponse.setMessage(ex.getMessage());
	      return new ResponseEntity<Object>(errorResponse,HttpStatus.BAD_REQUEST);
	   }
	 
	 @ExceptionHandler(MaxUploadSizeExceededException.class)
	    public ResponseEntity<Object>  handleFileUploadExecption(MaxUploadSizeExceededException exception) {
		 ApiResponse errorResponse = new ApiResponse();
		   errorResponse.setStatus_code(404);
		   errorResponse.setMessage("File size limit exceeded. Please make sure the file size is well within 500KB");
	        return new ResponseEntity<Object>(errorResponse, HttpStatus.BANDWIDTH_LIMIT_EXCEEDED);
	    }
	 
	  @ExceptionHandler(ResourceNotFoundException.class)
	   public ResponseEntity<Object> handleUserNotFoundException(ResourceNotFoundException ex) {
		   ApiResponse errorResponse = new ApiResponse();
		   errorResponse.setStatus_code(404);
		   errorResponse.setMessage(ex.getMessage());
	      return new ResponseEntity<Object>(errorResponse, HttpStatus.NOT_FOUND);
	   }
}
