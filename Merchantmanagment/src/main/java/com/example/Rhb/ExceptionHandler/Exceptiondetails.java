package com.example.Rhb.ExceptionHandler;

import java.util.Date;

import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

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
