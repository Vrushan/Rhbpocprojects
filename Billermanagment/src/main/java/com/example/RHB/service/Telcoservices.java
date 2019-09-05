package com.example.RHB.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.transaction.Synchronization;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.RHB.exception.ResourceNotfoundException;
import com.example.RHB.model.TelcoBiller;
import com.example.RHB.repository.Telcorepository;

@Service
public class Telcoservices {
	
	@Autowired
	Telcorepository telcorepository;
	
	public TelcoBiller GetTelcoByid(Long id) throws ResourceNotfoundException  
	{
		TelcoBiller biller = telcorepository.findById(id).orElseThrow(()->new ResourceNotfoundException("The Resource not found"));
		
		return biller;
	}
	
	public List<TelcoBiller> findall()
	{
		List<TelcoBiller> list = new ArrayList<TelcoBiller>();
		telcorepository.findAll().forEach(e->list.add(e));
		return list;
	}
	
	public synchronized String addbiller(TelcoBiller biller)
	{
		telcorepository.save(biller);
		return "Saved..!";
		
	}
	
	public TelcoBiller Updatebiller(Long id,TelcoBiller telcoBiller) throws ResourceNotfoundException
	{
		TelcoBiller biller=telcorepository.findById(id).orElseThrow(()->new ResourceNotfoundException("The resource not found"));
		biller.setBillerAddress(telcoBiller.getBillerAddress());
		biller.setBillername(telcoBiller.getBillername());
		biller.setEmail(telcoBiller.getEmail());
		biller.setState(telcoBiller.getState());
		
		return telcorepository.save(biller);
		
	}
	
	public Map<String,Boolean> Deletebyid(Long id) throws ResourceNotfoundException
	{
		telcorepository.findById(id).orElseThrow(()->new ResourceNotfoundException("The resource not found"));
		
		 telcorepository.deleteById(id);
		 
		 Map<String,Boolean> response = new HashMap<String,Boolean>();
		 response.put("deleted", Boolean.TRUE);
		 return response;
		 
	}
	
	

}
