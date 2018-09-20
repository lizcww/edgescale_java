package com.nxp.EdgeScale.page;

import org.openqa.selenium.WebElement;

import com.nxp.EdgeScale.base.BasePage;
import com.nxp.EdgeScale.base.DriverBase;
import com.nxp.EdgeScale.util.GetByLocator;

public class SolutionPage extends BasePage {

	public SolutionPage(DriverBase driverBase) {
		super(driverBase);
	}

	/**
	 * 获取newtag 按钮
	 */
	public WebElement getNewTagButton() {
		return element(GetByLocator.getLocator("solution_newTag_button"));
	}

	/**
	 * 获取newtag 输入框
	 */
	public WebElement getNewTagInput() {
		return element(GetByLocator.getLocator("solution_newTag_input"));
	}

	/**
	 * 获取页面右边提示元素
	 * 
	 * @return
	 */
	public WebElement getPageRightNoitce() {
		return element(GetByLocator.getLocator("login_noitce"));
	}

	/**
	 * 获取delete tag按钮
	 */
	public WebElement getDeleteTagButton() {
		return element(GetByLocator.getLocator("solution_delete_tag_button"));
	}

	public WebElement getSolutionDeleteButton() {
		return element(GetByLocator.getLocator("solution_delete_button"));
	}

	public WebElement getSolutionDeleteConfirmButton() {
		return element(GetByLocator.getLocator("solution_delete_confirmation"));
	}

	// --------------部署solution相关-------------------

	public WebElement getSolutionDeployButton() {
		return element(GetByLocator.getLocator("solution_deploy_button"));
	}

	public WebElement getQueryDeviceButton() {
		return element(GetByLocator.getLocator("deploy_solution_queryDevice_button"));
	}

	public WebElement getDeviceCheckbox() {
		return element(GetByLocator.getLocator("deploy_solution_device_checkbox"));
	}

	public WebElement getNextStepButton() {
		return element(GetByLocator.getLocator("deploy_solution_device_nextStep_button"));
	}

	public WebElement getDeployButton() {
		return element(GetByLocator.getLocator("deploy_solution_device_deploy_button"));
	}

	public WebElement getDownButton() {
		return element(GetByLocator.getLocator("solution_down_image_button"));
	}

	public WebElement getEditButton() {
		return element(GetByLocator.getLocator("solution_edit_button"));
	}

	public WebElement getSolutionPermissionButton() {
		return element(GetByLocator.getLocator("solution_edit_permission_button"));
	}

	public WebElement getSolutionEditSubmitButton() {
		return element(GetByLocator.getLocator("solution_edit_submit_button"));
	}

}
