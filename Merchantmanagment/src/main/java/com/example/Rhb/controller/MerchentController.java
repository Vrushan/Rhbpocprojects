package com.example.Rhb.controller;

import java.util.Arrays;
import java.util.List;

import javax.validation.Valid;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.example.Rhb.ExceptionHandler.ResourceNotfoundException;

import com.example.Rhb.model.MerchantCategeorys;

import com.example.Rhb.repository.MerchentRepository;
import com.example.Rhb.service.MerchentService;

@RestController
@RequestMapping("/RHB")
public class MerchentController {
	
	private static final Logger LOGGER=Logger.getLogger(MerchentController.class);
	
	
	@Autowired
	MerchentService merchentService;
	RestTemplate template;
	
	
	@PostMapping("/savecatageory")
	public String Addnewcatageory(@RequestBody MerchantCategeorys Categeory)
	{
		return merchentService.addcatageory(Categeory);
	}
	@GetMapping("/findall")
	public ResponseEntity<List<MerchantCategeorys>> findall()
	{
		List<MerchantCategeorys> list = merchentService.findall();
		return new ResponseEntity<List<MerchantCategeorys>>(list, HttpStatus.OK);
	}
	
	@GetMapping("/find/{id}")
	public ResponseEntity<MerchantCategeorys> GetcatageoryByid(@PathVariable ("id") Long id) throws ResourceNotfoundException
	{
		MerchantCategeorys Categeory= merchentService.GetcatageoryByid(id);
		
		return new ResponseEntity<MerchantCategeorys>(Categeory, HttpStatus.OK);
	}
	@PutMapping("/update/{id}")
	public ResponseEntity<MerchantCategeorys> Updatecatageory(@PathVariable("id") Long id,@RequestBody MerchantCategeorys catageory ) throws ResourceNotfoundException
	{
		merchentService.UpdateCategeorys(id, catageory);
		
		return new ResponseEntity<MerchantCategeorys>(catageory, HttpStatus.OK);
	}
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<Void> deletecatageory(@PathVariable ("id") Long id) throws ResourceNotfoundException
	{
		merchentService.Deletebyid(id);
		return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
	}
	
	@RequestMapping(value = "/template/biller")
	   public String getProductList() {
	      HttpHeaders headers = new HttpHeaders();
	      headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
	      HttpEntity <String> entity = new HttpEntity<String>(headers);

	      return template.exchange("http://localhost:8082/RHB/findall", HttpMethod.GET, entity, String.class).getBody();
	   }
	
	
	
	
	
	
	
	
	

}
