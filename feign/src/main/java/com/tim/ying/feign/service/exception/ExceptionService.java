package com.tim.ying.feign.service.exception;

import com.tim.ying.feign.service.HelloService;
import org.springframework.stereotype.Component;

@Component
public class ExceptionService implements HelloService{
	@Override
	public String hi(String name) {
		return "server error !!";
	}
}
