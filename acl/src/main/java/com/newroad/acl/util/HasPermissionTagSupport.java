package com.newroad.acl.util;

import java.util.Map;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.TagSupport;

import org.apache.commons.lang.StringUtils;

import com.newroad.acl.system.entity.Function;

@SuppressWarnings("serial")
public class HasPermissionTagSupport extends TagSupport {
	
	private String funcCode;
	
	public String getFuncCode() {
		return funcCode;
	}

	public void setFuncCode(String funcCode) {
		this.funcCode = funcCode;
	}

	@SuppressWarnings("unchecked")
	@Override
	public int doStartTag() throws JspException {
		
		//当标签没有该属性，抛出异常
		if(StringUtils.isBlank(funcCode)) {
			throw new RuntimeException("当前标签没有funcCode属性");
		}
		//从session获得用户的权限信息
		Map<String, Function> map=(Map<String, Function>) pageContext.getSession().getAttribute("functionsByCode");
		if(map == null ) {
			return SKIP_BODY ;
		}
		if(map.get(funcCode)!=null) {
			return EVAL_BODY_INCLUDE;
		}
		return SKIP_BODY;
	}
	
	@Override
	public int doEndTag() throws JspException {
		return super.doEndTag();
	}

}
