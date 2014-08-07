/* DemoEntryServiceFilter.java

	Purpose:
		
	Description:
		
	History:
		Mon, Mar 10, 2014 10:42:26 AM, Created by RaymondChao

Copyright (C) 2014 Potix Corporation. All Rights Reserved.

*/
package org.zkoss.angular.demo;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

import org.zkoss.web.servlet.Servlets;

/**
 * 
 * @author RaymondChao
 */
public class DemoEntryServiceFilter implements Filter {
	
	/* package */static ServletContext servletContext;

	public void init(FilterConfig filterConfig) throws ServletException {
		servletContext = filterConfig.getServletContext();	
	}

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		HttpServletRequest htReq = ((HttpServletRequest) request);

		String uri = htReq.getRequestURI();
		String context = htReq.getContextPath();
		String path = uri.replaceFirst(context, "");
		if (Servlets.isBrowser(request, "ie8-")) {
			Servlets.forward(servletContext, request, response, "/sorry4ie.html");
			return;
		} else if (path != null && path.length() > 1 && path.startsWith("/") &&
				path.indexOf('.') == -1 && !path.contains("/zkau")) {
			Servlets.forward(servletContext, request, response, "/index.xhtml");
			return;
		}
		chain.doFilter(request, response);
	}

	public void destroy() {	
	}
}
