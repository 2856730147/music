package com.lh.advice;
 
import java.io.IOException;
 
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletResponse;
 
public class SimpleCORSFilter implements Filter {
 
	@Override
	public void destroy() {
 
	}
 
	@Override
	public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain) throws IOException, ServletException {
		HttpServletResponse response = (HttpServletResponse) res;
		//允许跨域访问，通过response对象写回一些跨域访问的头信息
//		response.setHeader("Access-Control-Allow-Origin", "*");
//		//允许请求的方法
//		response.setHeader("Access-Control-Allow-Methods", "GET,POST,PUT,DELETE");
//
//		response.setHeader("Access-Control-Expose-Headers", "Token");
//
//		response.setHeader("Access-Control-Allow-Headers", "Token");
//
//		response.setHeader("Access-Control-Allow-Credentials", "true");
		chain.doFilter(req, res);

	}
 
	@Override
	public void init(FilterConfig arg0) throws ServletException {
 
	}
}