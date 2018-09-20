package com.nxp.EdgeScale.page;

import org.openqa.selenium.WebElement;

import com.nxp.EdgeScale.Common;
import com.nxp.EdgeScale.base.BasePage;
import com.nxp.EdgeScale.base.DriverBase;
import com.nxp.EdgeScale.util.GetByLocator;
import com.nxp.EdgeScale.util.ProUtil;

public class CreateModelPage extends BasePage {

	public CreateModelPage(DriverBase driverBase) {
		super(driverBase);
	}

	public WebElement getModelNoInput() {
		return element(GetByLocator.getLocator("create_model_modelNo_input"));
	}

	public WebElement getModelNoInputList(String modelNo) {
		ProUtil pro = new ProUtil(Common.ELEMENT);
		String locator = pro.getPro("create_model_modelNo_input_list");
		String locatorType = locator.split(">")[0];
		String locatorValue = locator.split(">")[1];
		String newValue = locatorValue.replace("modelNo", modelNo);
		System.out.println("替换后  ==========" + newValue);
		return element(GetByLocator.getLocator(locatorType, newValue));
	}

	public WebElement getModelTypeInput() {
		return element(GetByLocator.getLocator("create_model_type_input"));
	}

	public WebElement getModelTypeInputList(String type) {
		ProUtil pro = new ProUtil(Common.ELEMENT);
		String locator = pro.getPro("create_model_type_input_list");
		String locatorType = locator.split(">")[0];
		String locatorValue = locator.split(">")[1];
		String newValue = locatorValue.replace("type", type);
		System.out.println("替换后  ==========" + newValue);
		return element(GetByLocator.getLocator(locatorType, newValue));
	}

	public WebElement getModelPlatformInput() {
		return element(GetByLocator.getLocator("create_model_platform_input"));
	}

	public WebElement getModelPlatformInputList(String platform) {
		ProUtil pro = new ProUtil(Common.ELEMENT);
		String locator = pro.getPro("create_model_platform_input_list");
		String locatorType = locator.split(">")[0];
		String locatorValue = locator.split(">")[1];
		String newValue = locatorValue.replace("platform", platform);
		System.out.println("替换后  ==========" + newValue);
		return element(GetByLocator.getLocator(locatorType, newValue));
	}

	public WebElement getModelVendorInput() {
		return element(GetByLocator.getLocator("create_model_vendor_input"));
	}

	public WebElement getModelVendorInputList(String vendor) {
		ProUtil pro = new ProUtil(Common.ELEMENT);
		String locator = pro.getPro("create_model_vendor_input_list");
		String locatorType = locator.split(">")[0];
		String locatorValue = locator.split(">")[1];
		String newValue = locatorValue.replace("vendor", vendor);
		System.out.println("替换后  ==========" + newValue);
		return element(GetByLocator.getLocator(locatorType, newValue));
	}

	public WebElement getModelSubmit() {
		return element(GetByLocator.getLocator("create_model_submit"));
	}
	
	/**
	 * 获取页面右边提示元素
	 * 
	 * @return
	 */
	public WebElement getPageRightNoitce() {
		return element(GetByLocator.getLocator("login_noitce"));
	}

}
