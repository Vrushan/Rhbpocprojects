package com.example.RHB.exception;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import static org.springframework.http.HttpStatus.INTERNAL_SERVER_ERROR;

import java.util.Date;

import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;

@Data
@Getter
@Setter
@NoArgsConstructor
public class Exceptiondetails {
	
	private Date Timestamp;
	private String message;
	private String details;
	
	public Exceptiondetails(Date Timestamp, String message, String details) {
		super();
		this.Timestamp = Timestamp;
		this.message = message;
		this.details = details;
	}
	
	
	

}
