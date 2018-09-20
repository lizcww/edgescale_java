package com.nxp.EdgeScale.handle;

import org.openqa.selenium.Keys;

import com.nxp.EdgeScale.base.DriverBase;
import com.nxp.EdgeScale.page.LoginPage;
import com.nxp.EdgeScale.page.SolutionPage;

public class SolutionPageHandle {

	public DriverBase driverBase;
	public SolutionPage sp;

	public SolutionPageHandle(DriverBase driverBase) {
		this.driverBase = driverBase;
		sp = new SolutionPage(driverBase);
	}

	public void clickNewTagButton() {
		sp.click(sp.getNewTagButton());
	}

	public void sendKeysNewTagInput(String tag) {
		sp.sendkeys(sp.getNewTagInput(), tag);
	}

	public void sendEnterNewTagInput() {
		sp.getNewTagInput().sendKeys(Keys.ENTER);
	}

	/**
	 * 获取页面右边提示文本
	 * 
	 * @return
	 */
	public String getPageRightNotice() {
		return sp.getPageRightNoitce().getText();
	}

	public void clickDeleteTagButton() {
		sp.click(sp.getDeleteTagButton());
	}
	
	public void clickSolutionDeleteButton() {
		sp.click(sp.getSolutionDeleteButton());
	}
	
	public void clickSolutionDeleteConfirmButton() {
		sp.click(sp.getSolutionDeleteConfirmButton());
	}
	
	// --------------部署solution相关-------------------
	
	public void clickSolutionDeployButton() {
		sp.click(sp.getSolutionDeployButton());
	}
	
	public void clickQueryDeviceButton() {
		sp.click(sp.getQueryDeviceButton());
	}
	
	public void clickDeviceCheckbox() {
		sp.click(sp.getDeviceCheckbox());
	}

	public void clickNextStepButton() {
		sp.click(sp.getNextStepButton());
	}
	
	public void clickDeployButton() {
		sp.click(sp.getDeployButton());
	}
	
	public void clickDownButton() {
		sp.click(sp.getDownButton());
	}
	
	public void clickEditButton() {
		sp.click(sp.getEditButton());
	}
	
	public void clickSolutionPermissionButton() {
		sp.click(sp.getSolutionPermissionButton());
	}
	
	public void clickSolutionEditSubmitButton() {
		sp.click(sp.getSolutionEditSubmitButton());
	}

}
