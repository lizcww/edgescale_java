package com.nxp.EdgeScale.page;

import org.openqa.selenium.WebElement;

import com.nxp.EdgeScale.base.BasePage;
import com.nxp.EdgeScale.base.DriverBase;
import com.nxp.EdgeScale.util.GetByLocator;

public class AppEditInfoPage extends BasePage {

	public AppEditInfoPage(DriverBase driverBase) {
		super(driverBase);
	}

	public WebElement getAppEditButton() {
		return element(GetByLocator.getLocator("app_edit_button"));
	}

	public WebElement getAppEditAppNameInput() {
		return element(GetByLocator.getLocator("app_edit_appName_input"));
	}

	public WebElement getAppEditAppDescInput() {
		return element(GetByLocator.getLocator("app_edit_appDesc_input"));
	}

	public WebElement getAppEditNextButton() {
		return element(GetByLocator.getLocator("app_edit_next_button"));
	}

	public WebElement getAppAddDcokerButton() {
		return element(GetByLocator.getLocator("app_add_docker_button"));
	}

	public WebElement getAppAddDcokerSubmitButton() {
		return element(GetByLocator.getLocator("app_add_docker_submit_button"));
	}

	public WebElement getAppChangePermissionButton() {
		return element(GetByLocator.getLocator("app_change_permission_button"));
	}

	public WebElement getAppChangePermissionCheckbox() {
		return element(GetByLocator.getLocator("app_change_permission_checkbox"));
	}

	public WebElement getAppChangePermissionSubmit() {
		return element(GetByLocator.getLocator("app_change_permission_submit"));
	}

}
