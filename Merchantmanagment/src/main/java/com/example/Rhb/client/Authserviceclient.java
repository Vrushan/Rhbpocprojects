package com.example.Rhb.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.example.Rhb.model.MerchantCategeorys;

@FeignClient(name="Auth-service")
public interface Authserviceclient {
	
	@RequestMapping(method = RequestMethod.POST, value = "/users", consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
	void createcatageory(MerchantCategeorys catageory);

}
