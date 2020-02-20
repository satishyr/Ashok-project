package com.tekleads.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@FeignClient(name = "GREET-SERVICE")
public interface GreetServiceProxyClient {

	@RequestMapping(value = "/getGreetMsg/{name}")
	public String invokeGreetMsg(@PathVariable("name") String name);

}
