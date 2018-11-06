package com.nxp.EdgeScale.page;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.WebElement;

import com.nxp.EdgeScale.Common;
import com.nxp.EdgeScale.base.BasePage;
import com.nxp.EdgeScale.base.DriverBase;
import com.nxp.EdgeScale.testcase.CreateModel;
import com.nxp.EdgeScale.util.GetByLocator;
import com.nxp.EdgeScale.util.ProUtil;

public class CreateModelPage extends BasePage {
	private static Logger logger = Logger.getLogger(CreateModelPage.class);
	
	public CreateModelPage(DriverBase driverBase) {
		super(driverBase);
		PropertyConfigurator.configure("log4j.properties");
	}

	public WebElement getModelNoInput() {
		return element(GetByLocator.getLocator("create_model_modelNo_input"));
	}

	public WebElement getModelNoInputList(String modelNo) {
		ProUtil pro = new ProUtil(Common.ELEMENT);
		String locator = pro.getPro("create_model_modelNo_input_list");
		String locatorType = locator.split(">")[0];
		String locatorValue = locator.split(">")[1];
		logger.info("ModelNoInputList before replacement: " + locatorValue);
		String newValue = locatorValue.replace("modelNo", modelNo);
		logger.info("ModelNoInputList after replacement: " + newValue);
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
		logger.info("ModelTypeInputList before replacement: " + locatorValue);
		String newValue = locatorValue.replace("type", type);
		logger.info("ModelTypeInputList after replacement: " + newValue);
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
	
	public WebElement getModelPermissionPrivate() {
		return element(GetByLocator.getLocator("create_model_permission_private"));
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
