package com.newroad.acl.filter;

import java.io.IOException;
import java.util.Map;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.newroad.acl.system.entity.Function;
@WebFilter("/system/*")
public class LoginFilter implements Filter {

	@Override
	public void destroy() {

	}

	@SuppressWarnings("unchecked")
	@Override
	public void doFilter(ServletRequest arg0, ServletResponse arg1, FilterChain arg2)
			throws IOException, ServletException {
		//权限过滤器
		HttpServletRequest req=(HttpServletRequest) arg0;
		HttpServletResponse resp=(HttpServletResponse) arg1;
		Map<String, Function> functionsByUrl=(Map<String, Function>) req.getSession().getAttribute("functionsByUrl");
		Map<String, Function> functionsByCode=(Map<String, Function>) req.getSession().getAttribute("functionsByCode");
		String uri=req.getRequestURI();
		System.out.println("uri1="+uri);
		uri=uri.replace(req.getContextPath()+"/", "");
		System.out.println("uri2="+uri);
		System.out.println(functionsByUrl);
		System.out.println(functionsByCode);
		
		//基于uri过滤，实现拦截
		String[] uris= {"system/user/list"};
		Boolean flage=false;
		for(int i=0;i<uris.length;i++) {
			if(uris[i].equals(uri)) {
				flage=true;
			}
		}
		if(flage) {
			arg2.doFilter(req, resp);
			return;
		}
		
		if(functionsByUrl==null || (functionsByUrl != null && functionsByUrl.get(uri) == null)) {
			resp.sendRedirect(req.getContextPath()+"/permissionError.jsp");
		}else {
			//放行
			arg2.doFilter(req, resp);
		}
					
	}

	@Override
	public void init(FilterConfig arg0) throws ServletException {
		// TODO Auto-generated method stub

	}

}
