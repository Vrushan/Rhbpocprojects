package com.example.Rhb;


import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.example.Rhb.model.MerchantCategeorys;
import com.example.Rhb.repository.MerchentRepository;
import com.example.Rhb.service.MerchentService;
import com.google.common.base.Verify;

@RunWith(SpringRunner.class)
@SpringBootTest
public class MerchantmanagmentApplicationTests {
	
	@InjectMocks
	MerchentService merchentservice;
	
	@Mock
	MerchentRepository merchentRepository;
	
	@Before
	public void init()
	{
		MockitoAnnotations.initMocks(this);
	}

	@Test
	public void getallcatageorytest()
	{
		List<MerchantCategeorys> list = new ArrayList<MerchantCategeorys>();
		MerchantCategeorys catageory1=new MerchantCategeorys(1,"Hotel","Bukitjalil","6059876458","560048");
		MerchantCategeorys catageory2=new MerchantCategeorys(2,"Retail","Bukitjalil","609875645","560049");
		
		list.add(catageory1);
		list.add(catageory2);
		
		when(merchentRepository.findAll()).thenReturn(list);
		
		List<MerchantCategeorys> catageorylist=merchentservice.findall();
		
		assertEquals(2, catageorylist.size());
		
		verify(merchentRepository, times(1)).findAll();
		
	}
	@Test
	public void create()
	{
		MerchantCategeorys catageory1=new MerchantCategeorys(1,"Hotel","Bukitjalil","6059876458","560048");
		merchentservice.addcatageory(catageory1);
		verify(merchentservice, times(1)).addcatageory(catageory1);
		
	}
	

}
