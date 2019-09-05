package com.example.Rhb.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.example.Rhb.ExceptionHandler.ResourceNotfoundException;
import com.example.Rhb.client.Authserviceclient;
import com.example.Rhb.model.MerchantCategeorys;
import com.example.Rhb.repository.MerchentRepository;

@Service
public class MerchentService {
	
	@Autowired
	MerchentRepository merchentRepository;
	Authserviceclient authclient;
	
	public MerchantCategeorys GetcatageoryByid(Long id) throws ResourceNotfoundException  
	{
		MerchantCategeorys Categeory = merchentRepository.findById(id).orElseThrow(()->new ResourceNotfoundException("The Resource not found"));
		
		return Categeory;
	}
	
	public List<MerchantCategeorys> findall()
	{
		List<MerchantCategeorys> list = new ArrayList<MerchantCategeorys>();
		merchentRepository.findAll().forEach(e->list.add(e));
		return list;
	}
	
	public synchronized String addcatageory(MerchantCategeorys Categeory)
	{
		authclient.createcatageory(Categeory);
		merchentRepository.save(Categeory);
		return "Saved..!";
		
	}
	
	public MerchantCategeorys UpdateCategeorys(Long id,MerchantCategeorys Categeorys) throws ResourceNotfoundException
	{
		MerchantCategeorys Categeory=merchentRepository.findById(id).orElseThrow(()->new ResourceNotfoundException("The resource not found"));
		Categeory.setMerchentAddress(Categeorys.getMerchentAddress());
		Categeory.setMerchentno(Categeorys.getMerchentno());
		Categeory.setMerchentType(Categeorys.getMerchentType());
		Categeory.setPostalcode(Categeorys.getPostalcode());
		
		return merchentRepository.save(Categeory);
		
	}
	
	public Map<String,Boolean> Deletebyid(Long id) throws ResourceNotfoundException
	{
		merchentRepository.findById(id).orElseThrow(()->new ResourceNotfoundException("The resource not found"));
		
		merchentRepository.deleteById(id);
		 
		 Map<String,Boolean> response = new HashMap<String,Boolean>();
		 response.put("deleted", Boolean.TRUE);
		 return response;
		 
	}
	
	
	
	

}
