package com.nxp.EdgeScale.handle;

import com.nxp.EdgeScale.base.DriverBase;
import com.nxp.EdgeScale.page.CreateSolutionPage;
import com.nxp.EdgeScale.page.DevicePage;

public class CreateSolutionPageHandle {

	public DriverBase driver;
	public CreateSolutionPage csp;

	public CreateSolutionPageHandle(DriverBase driverBase) {
		this.driver = driverBase;
		csp = new CreateSolutionPage(driverBase);
	}
	
	public void clickModelNameInput() {
		csp.click(csp.getModelNameInput());
	}
	
	public void clickModelNameInputList(String modelName) {
		csp.click(csp.getModelNameInputList(modelName));
	}
	
	public void sendKeysSolutionNameInput(String solutionName) {
		csp.sendkeys(csp.getSolutionNameInput(), solutionName);
	}
	
	public void sendKeysVersionInput(String version) {
		csp.sendkeys(csp.getVersionInput(), version);
	}
	
	public void clickVersionInputList(String version) {
		csp.click(csp.getVersionInputList(version));
	}
	
	public void clickNextButton() {
		csp.click(csp.getNextButton());
	}
	
	public void clickNext2Button() {
		csp.click(csp.getNext2Button());
	}
	
	public void sendKeysImageUrlInput(String imageUrl) {
		csp.sendkeys(csp.getImageUrlInput(), imageUrl);
	}
	
	public void clickSubmitButton() {
		csp.click(csp.getSubmitButton());
	}
	
	/**
	 * 获取页面右边提示文本
	 * 
	 * @return
	 */
	public String getPageRightNotice() {
		return csp.getPageRightNoitce().getText();
	}

	
}
