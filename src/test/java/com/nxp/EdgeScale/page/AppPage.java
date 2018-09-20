package com.nxp.EdgeScale.page;

import org.openqa.selenium.WebElement;

import com.nxp.EdgeScale.base.BasePage;
import com.nxp.EdgeScale.base.DriverBase;
import com.nxp.EdgeScale.util.GetByLocator;

public class AppPage extends BasePage {

	public AppPage(DriverBase driverBase) {
		super(driverBase);
	}

	public WebElement getMyAppButton() {
		return element(GetByLocator.getLocator("my_app_button"));
	}

	public WebElement getAppDeleteButton() {
		return element(GetByLocator.getLocator("app_delete_button"));
	}

	public WebElement getAppDeleteConfirmationButton() {
		return element(GetByLocator.getLocator("app_delete_confirmation"));
	}

	/**
	 * 获取app页面右边提示元素
	 * 
	 * @return
	 */
	public WebElement getPageRightNoitce() {
		return element(GetByLocator.getLocator("login_noitce"));
	}

	/**
	 * 获取app deploy 按钮
	 * 
	 * @return
	 */
	public WebElement getAppDelopyButton() {
		return element(GetByLocator.getLocator("app_deploy_button"));
	}

	/**
	 * 获取app deploy device选择框
	 * 
	 * @return
	 */
	public WebElement getAppDelopyDeviceCheckbox() {
		return element(GetByLocator.getLocator("app_deploy_device_checkbox"));
	}

	/**
	 * 获取deployApp按钮
	 * 
	 * @return
	 */
	public WebElement getDeployAppButton() {
		return element(GetByLocator.getLocator("app_deploy_deployApp_button"));
	}

	/**
	 * 获取app document按钮
	 * 
	 * @return
	 */
	public WebElement getAppDocumentButton() {
		return element(GetByLocator.getLocator("app_document_button"));
	}

	/**
	 * 获取页面顶部提示元素
	 * 
	 * @return
	 */
	public WebElement getDevicePageTopNotice() {
		return element(GetByLocator.getLocator("device_page_top_notice"));
	}

	/**
	 * 获取公共商店中的app部署按钮
	 * 
	 * @return
	 */
	public WebElement getPublicAppDeploy() {
		return element(GetByLocator.getLocator("app_public_deploy"));
	}

	public WebElement getAppBatchDeployButton() {
		return element(GetByLocator.getLocator("app_batch_deploy_button"));
	}

	public WebElement getAppDetailButton() {
		return element(GetByLocator.getLocator("app_detail_button"));
	}

}
