package com.example.demo.application;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;

@Component
@Order(Ordered.HIGHEST_PRECEDENCE)
public class CorsFilter implements Filter {
	
	public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain)
			throws IOException, ServletException {
		HttpServletRequest request = (HttpServletRequest) req;
		HttpServletResponse response = (HttpServletResponse) res;
		String method = request.getMethod();

		String origin = request.getHeader("Origin");
		String allowedOrigin = "*";
		
		if (origin != null) {
			allowedOrigin = origin;
		}
		
        response.setHeader("Access-Control-Allow-Origin", allowedOrigin);
        response.setHeader("Vary", "Origin");
        
        response.setHeader("Access-Control-Allow-Methods", "GET, POST, PUT, DELETE, OPTIONS");
        
		response.setHeader("Access-Control-Expose-Headers", "X-Filename");
		
		response.setHeader("Access-Control-Allow-Credentials", "true");
		
		response.setHeader("Access-Control-Allow-Headers",
				"Origin,Accept,X-Requested-With,X-Authentication,Content-Type,Access-Control-Request-Method,Access-Control-Request-Headers,Authorization");

		if ("OPTIONS".equals(method)) {
			response.setStatus(HttpStatus.OK.value());
		} else {
			chain.doFilter(req, res);
		}
	}

	public void init(FilterConfig filterConfig) {
	}

	public void destroy() {
	}
}
