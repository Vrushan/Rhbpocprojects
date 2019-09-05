package com.example.RHB.controller;

import java.util.Arrays;
import java.util.List;

import org.apache.log4j.Logger;
import org.apache.log4j.spi.LoggerFactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.util.Assert;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.example.RHB.exception.ResourceNotfoundException;
import com.example.RHB.model.TelcoBiller;
import com.example.RHB.service.Telcoservices;

@RestController
@RequestMapping("/RHB")
public class TelcoController {
	private final Logger logger = Logger.getLogger(TelcoController.class);
	@Autowired
	Telcoservices telcoservices;
	RestTemplate template;
	
	@PostMapping("/savebiller")
	public String AddnewBiller(@RequestBody TelcoBiller Biller)
	{
		return telcoservices.addbiller(Biller);
	}
	@GetMapping("/findall")
	public ResponseEntity<List<TelcoBiller>> findall()
	{
		List<TelcoBiller> list = telcoservices.findall();
		return new ResponseEntity<List<TelcoBiller>>(list, HttpStatus.OK);
	}
	
	@GetMapping("/find/{id}")
	public ResponseEntity<TelcoBiller> GetbillerByid(@PathVariable ("id") Long id) throws ResourceNotfoundException
	{
		TelcoBiller biller= telcoservices.GetTelcoByid(id);
		Assert.isNull(biller, "The id not exists"+ biller.getId());
		
		return new ResponseEntity<TelcoBiller>(biller, HttpStatus.OK);
	}
	@PutMapping("/update/{id}")
	public ResponseEntity<TelcoBiller> Updatebiller(@PathVariable("id") Long id,@RequestBody TelcoBiller biller ) throws ResourceNotfoundException
	{
		telcoservices.Updatebiller(id, biller);
		
		return new ResponseEntity<TelcoBiller>(biller, HttpStatus.OK);
	}
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<Void> deletebiller(@PathVariable ("id") Long id) throws ResourceNotfoundException
	{
		telcoservices.Deletebyid(id);
		return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
	}
	
	@RequestMapping("/Authentication")
    @ResponseBody
    public final String home() {
        final String username = SecurityContextHolder.getContext().getAuthentication().getName();
        logger.info(username);
        return "Welcome, " + username;
    }
	

}
