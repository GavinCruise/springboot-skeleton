package com.dai7.controller;

import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * @description 基础类
 */
public class BaseAppController {

//	/**
//	 * @description 获取当前登录用户信息
//	 */
//	protected UserInfo getCurrentUserInfo() {
//		return (UserInfo)session().getAttribute("userInfo");
//	}
//
//
//	/**
//	 * @description 获取当前登录人ID
//	 */
//	protected int getCurrentUserId() {
//		UserInfo userInfo = (UserInfo)session().getAttribute("userInfo");
//        return userInfo.getId();
//	}
//
//
//	/**
//	 *
//	 * @description 获取当前用户所在企业id
//	 */
//	protected int getCurrentUserEnterpriseId() {
//        UserInfo userInfo = (UserInfo)session().getAttribute("userInfo");
//        return userInfo.getEnterpriseId();
//	}


	/**
	 * 获取IP
	 */
	public String getIp() {
        HttpServletRequest request = request();
		String ip = request.getHeader("x-forwarded-for");
		if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
			ip = request.getHeader("Proxy-Client-IP");
		}
		if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
			ip = request.getHeader("WL-Proxy-Client-IP");
		}
		if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
			ip = request.getRemoteAddr();
		}
		
		//modify by yangql 2017-03-25 x-forwarded-for可能会产生多个ip相连接问题
		if(ip!=null && ip.contains(",") && ip.split(",").length >= 1 ) {
			return ip.split(",")[0];
		}
		else {
			return "";
		}
		
	}

	public static String getDomain(){
        return request().getServerName();
    }

    public static HttpServletRequest request(){
        ServletRequestAttributes servletRequestAttributes = (ServletRequestAttributes) RequestContextHolder.currentRequestAttributes();
        return servletRequestAttributes.getRequest();
    }

    public static HttpSession session(){
        ServletRequestAttributes servletRequestAttributes = (ServletRequestAttributes) RequestContextHolder.currentRequestAttributes();
        return servletRequestAttributes.getRequest().getSession();
    }

}