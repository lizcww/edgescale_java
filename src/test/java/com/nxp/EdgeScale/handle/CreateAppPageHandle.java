package com.nxp.EdgeScale.handle;

import org.openqa.selenium.WebElement;

import com.nxp.EdgeScale.base.DriverBase;
import com.nxp.EdgeScale.page.CreateAppPage;

public class CreateAppPageHandle {

	public DriverBase driver;
	public CreateAppPage cap;

	public CreateAppPageHandle(DriverBase driverBase) {
		this.driver = driverBase;
		cap = new CreateAppPage(driverBase);
	}

	public void sendKeysAppNameInput(String appName) {
		cap.sendkeys(cap.getAppnameInput(), appName);
	}

	public void sendKeysAppDescInput(String desc) {
		cap.sendkeys(cap.getAppDescInput(), desc);
	}

	public void clickAppUploadIcon() {
		cap.click(cap.getAppUploadIcon());
	}

	public WebElement getAppUploadInput() {
		return cap.getAppUploadInput();
	}
	
	public void sendKeysUploadInput(String imagePath) {
		cap.sendkeys(cap.getAppUploadInput(), imagePath);
	}
	
	public void clickSaveButton() {
		cap.click(cap.getAppUploadSave());
	}

	public void clickNextButton() {
		cap.click(cap.getNextButton());
	}

	public void clickRegistryInput() {
		cap.click(cap.getRegistryInput());
	}

	public void clickRegistryList(String registry) {
		cap.click(cap.getRegistryInputList(registry));
	}

	public void sendKeysImageName(String imageName) {
		cap.sendkeys(cap.getImageNameInput(), imageName);
	}

	public void clickSubmitButton() {
		cap.click(cap.getSubmitButton());
	}

	/**
	 * 获取Device页面右边提示文本
	 * 
	 * @return
	 */
	public String getPageRightNotice() {
		return cap.getPageRightNoitce().getText();
	}
	
	public void sendKeysCreateAppVersionInput(String version) {
		cap.sendkeys(cap.getCreateAppVersionInput(), version);
	}
	
	public void clickCreateAppVersionInputList(String version) {
		cap.click(cap.getCreateAppVersionInputList(version));
	}

}
