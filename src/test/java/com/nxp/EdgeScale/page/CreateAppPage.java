package com.nxp.EdgeScale.page;

import org.openqa.selenium.WebElement;

import com.nxp.EdgeScale.Common;
import com.nxp.EdgeScale.base.BasePage;
import com.nxp.EdgeScale.base.DriverBase;
import com.nxp.EdgeScale.util.GetByLocator;
import com.nxp.EdgeScale.util.ProUtil;

public class CreateAppPage extends BasePage {

	public CreateAppPage(DriverBase driverBase) {
		super(driverBase);
	}

	public WebElement getAppnameInput() {
		return element(GetByLocator.getLocator("create_app_appName_input"));
	}

	public WebElement getAppDescInput() {
		return element(GetByLocator.getLocator("create_app_description_input"));
	}

	public WebElement getAppUploadIcon() {
		return element(GetByLocator.getLocator("create_app_uploadIcon"));
	}

	public WebElement getAppUploadIcon2() {
		return element(GetByLocator.getLocator("create_app_uploadIcon2"));
	}

	public WebElement getAppUploadInput() {
		return element(GetByLocator.getLocator("create_app_uploadImage_input"));
	}

	public WebElement getAppUploadSave() {
		return element(GetByLocator.getLocator("create_app_uploadImage_save"));
	}

	public WebElement getNextButton() {
		return element(GetByLocator.getLocator("create_app_next_button"));
	}

	public WebElement getRegistryInput() {
		return element(GetByLocator.getLocator("create_app_registry_input"));
	}

	public WebElement getRegistryInputList(String registry) {
		ProUtil pro = new ProUtil(Common.ELEMENT);
		String locator = pro.getPro("create_app_registry_input_list");
		String locatorType = locator.split(">")[0];
		String locatorValue = locator.split(">")[1];
		String newValue = locatorValue.replace("registry", registry);
		System.out.println("替换后  ==========" + newValue);
		return element(GetByLocator.getLocator(locatorType, newValue));
	}

	public WebElement getImageNameInput() {
		return element(GetByLocator.getLocator("create_app_imageName_input"));
	}

	public WebElement getVersionInput() {
		return element(GetByLocator.getLocator("create_app_imageName_input"));
	}

	public WebElement getSubmitButton() {
		return element(GetByLocator.getLocator("create_app_submit_button"));
	}

	/**
	 * 获取create app页面右边提示元素
	 * 
	 * @return
	 */
	public WebElement getPageRightNoitce() {
		return element(GetByLocator.getLocator("login_noitce"));
	}

	public WebElement getCreateAppVersionInput() {
		return element(GetByLocator.getLocator("create_app_version_input"));
	}

	public WebElement getCreateAppVersionInputList(String version) {
		ProUtil pro = new ProUtil(Common.ELEMENT);
		String locator = pro.getPro("create_app_version_input_list");
		String locatorType = locator.split(">")[0];
		String locatorValue = locator.split(">")[1];
		String newValue = locatorValue.replace("version", version);
		System.out.println("替换后  ==========" + newValue);
		return element(GetByLocator.getLocator(locatorType, newValue));
	}

}
