package com.nxp.EdgeScale.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.nxp.EdgeScale.Common;
import com.nxp.EdgeScale.base.BasePage;
import com.nxp.EdgeScale.base.DriverBase;
import com.nxp.EdgeScale.util.GetByLocator;
import com.nxp.EdgeScale.util.ProUtil;

public class CreateDevicePage extends BasePage {

	public CreateDevicePage(DriverBase driverBase) {
		super(driverBase);
	}

	public WebElement getSNInput() {
		return element(GetByLocator.getLocator("device_SN_input"));
	}

	public WebElement getGenerateDeviceIDNoButton() {
		return element(GetByLocator.getLocator("generate_device_id_NO_button"));
	}

	public WebElement getModelInput() {
		return element(GetByLocator.getLocator("device_model_input"));
	}

	public WebElement getDeviceModelList(String modelName) {
		ProUtil pro = new ProUtil(Common.ELEMENT);
		String locator = pro.getPro("device_model_list");
		String locatorType = locator.split(">")[0];
		String locatorValue = locator.split(">")[1];
		String newValue = locatorValue.replace("modelName", modelName);
		System.out.println("替换后  ==========" + newValue);
		return element(GetByLocator.getLocator(locatorType, newValue));
	}

	public WebElement getSubmitButton() {
		return element(GetByLocator.getLocator("create_device_submit_button"));
	}
	
	public WebElement getCancelDownloadCertificate() {
		return element(GetByLocator.getLocator("create_device_cancel_download_certificate"));
	}

	public WebElement getNotice() {
		return element(GetByLocator.getLocator("login_noitce"));
	}

}
