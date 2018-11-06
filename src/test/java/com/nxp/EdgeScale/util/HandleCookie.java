package com.nxp.EdgeScale.util;

import java.util.Set;

import org.openqa.selenium.Cookie;

import com.nxp.EdgeScale.Common;
import com.nxp.EdgeScale.base.DriverBase;

public class HandleCookie {
	public DriverBase driver;
	public ProUtil pro;

	public HandleCookie(DriverBase driver) {
		this.driver = driver;
		pro = new ProUtil(Common.COOKIE);
	}

	public void setCookie_commonUser1() {
		String token = pro.getPro("token_common_user_1");
		Cookie cookie = new Cookie("token", token, Common.WEB_BASE, "/", null);
		String username = pro.getPro("username_common_user_1");
		Cookie cookie2 = new Cookie("username", username, Common.WEB_BASE, "/", null);
		driver.setCookie(cookie);
		driver.setCookie(cookie2);
	}
	
	public void setCookie_rootUser1() {
		String token = pro.getPro("token_root_user_1");
		Cookie cookie = new Cookie("token", token, Common.WEB_BASE, "/", null);
		String username = pro.getPro("username_root_user_1");
		Cookie cookie2 = new Cookie("username", username, Common.WEB_BASE, "/", null);
		driver.setCookie(cookie);
		driver.setCookie(cookie2);
	}

	/**
	 * 获取cookie
	 */
	public void writeCookie() {
		Set<Cookie> cookies = driver.getCookie();
		for (Cookie cookie : cookies) {
			if (cookie.getName().equals("token")) {
				pro.writePro(cookie.getName(), cookie.getValue());
			}
		}
	}
}
