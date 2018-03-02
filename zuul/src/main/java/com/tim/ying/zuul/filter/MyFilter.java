package com.tim.ying.zuul.filter;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

@Component
public class MyFilter extends ZuulFilter{
	private Logger logger = LoggerFactory.getLogger(getClass());

	/**
	 * pre 路由之前
	 * routing 路由之时
	 * post：路由之后
	 * error:发送错误调用
	 * @return
	 */
	@Override
	public String filterType() {
		return "pre";
	}
	@Override
	public int filterOrder() {
		return 0;
	}
	@Override
	public boolean shouldFilter() {
		return true;
	}
	@Override
	public Object run() {
		RequestContext ctx = RequestContext.getCurrentContext();
		HttpServletRequest request = ctx.getRequest();
		logger.info("{} >>> {}",request.getMethod(),request.getRequestURL().toString());
		Object accessToken = request.getParameter("token");
		if(accessToken==null){
			logger.error("token is null ");
			ctx.setSendZuulResponse(false);
			ctx.setResponseStatusCode(401);
			try {
				ctx.getResponse().getWriter().write("token is null or empty");
			} catch (IOException e) {
				return null;
			}
		}
		return null;
	}
}
