package com.nxp.EdgeScale.page;

import org.openqa.selenium.WebElement;

import com.nxp.EdgeScale.base.BasePage;
import com.nxp.EdgeScale.base.DriverBase;
import com.nxp.EdgeScale.util.GetByLocator;

/**
 * 注册页面
 * 
 * @author nxf46859
 *
 */
public class ApplyPage extends BasePage {

	public ApplyPage(DriverBase driverBase) {
		super(driverBase);
	}

	/**
	 * 获取FistName输入框
	 */
	public WebElement getFistNameInput() {
		return element(GetByLocator.getLocator("first_name_input"));
	}

	/**
	 * 获取LastName输入框
	 */
	public WebElement getLastNameInput() {
		return element(GetByLocator.getLocator("last_name_input"));
	}

	/**
	 * 获取email输入框
	 */
	public WebElement getEmailInput() {
		return element(GetByLocator.getLocator("email_input"));
	}

	/**
	 * 获取CompanyName输入框
	 */
	public WebElement getCompanyNameInput() {
		return element(GetByLocator.getLocator("company_name_input"));
	}

	/**
	 * 获取提交按钮
	 */
	public WebElement getSubmitButton() {
		return element(GetByLocator.getLocator("register_submit_button"));
	}

	/**
	 * 获取提示element
	 */
	public WebElement getNotice() {
		return element(GetByLocator.getLocator("register_notice"));
	}
	
	
}
