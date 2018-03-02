package com.tim.ying.feign.service;

import com.tim.ying.feign.service.exception.ExceptionService;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;


@FeignClient(value = "service-hi",fallback = ExceptionService.class)
public interface HelloService {

	/**
	 * 对应的是 client 里面的 requestMapping rest接口格式的调用
	 * @param name
	 * @return
	 * 这里的reuqestParam 里面一定要指定value的值
	 */
	@RequestMapping(value = "/hi",method = RequestMethod.GET)
	String hi(@RequestParam(value="name") String name);
}
