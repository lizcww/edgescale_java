package com.nxp.EdgeScale.page;

import org.openqa.selenium.WebElement;

import com.nxp.EdgeScale.base.BasePage;
import com.nxp.EdgeScale.base.DriverBase;
import com.nxp.EdgeScale.util.GetByLocator;

public class AppMutipleDeployPage extends BasePage {

	public AppMutipleDeployPage(DriverBase driverBase) {
		super(driverBase);
	}

	public WebElement getAppMutipleDeployCheckbox1() {
		return element(GetByLocator.getLocator("app_mutiple_deploy_checkbox1"));
	}

	public WebElement getAppMutipleDeployCheckbox2() {
		return element(GetByLocator.getLocator("app_mutiple_deploy_checkbox2"));
	}

	public WebElement getAppMutipleDeployNextStepButton() {
		return element(GetByLocator.getLocator("app_mutiple_deploy_nextStep_button"));
	}

	public WebElement getAppMutipleDeployChooseAppCheckbox1() {
		return element(GetByLocator.getLocator("app_mutiple_deploy_chooseApp_checkbox1"));
	}

	public WebElement getAppMutipleDeployChooseAppCheckbox2() {
		return element(GetByLocator.getLocator("app_mutiple_deploy_chooseApp_checkbox2"));
	}

	public WebElement getAppMutipleDeployNextStepDeployConfigButton() {
		return element(GetByLocator.getLocator("app_mutiple_deploy_nextStep_deployConfig_button"));
	}

	public WebElement getAppMutipleDeployNextStepPreviewButton() {
		return element(GetByLocator.getLocator("app_mutiple_deploy_nextStep_preview_button"));
	}

	public WebElement getAppMutipleDeployNextStepDeployButton() {
		return element(GetByLocator.getLocator("app_mutiple_deploy_nextStep_deploy_button"));
	}

}
