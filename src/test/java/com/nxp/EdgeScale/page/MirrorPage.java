package com.nxp.EdgeScale.page;

import org.openqa.selenium.WebElement;

import com.nxp.EdgeScale.base.BasePage;
import com.nxp.EdgeScale.base.DriverBase;
import com.nxp.EdgeScale.util.GetByLocator;

public class MirrorPage extends BasePage {

	public MirrorPage(DriverBase driverBase) {
		super(driverBase);
	}

	public WebElement getMirrorCreateButton() {
		return element(GetByLocator.getLocator("mirror_create_button"));
	}

	public WebElement getMirrorCreateNameInput() {
		return element(GetByLocator.getLocator("mirror_create_name_input"));
	}

	public WebElement getMirrorCreateDescInput() {
		return element(GetByLocator.getLocator("mirror_create_desc_input"));
	}

	public WebElement getMirrorCreateSubmit() {
		return element(GetByLocator.getLocator("mirror_create_submit"));
	}

	/**
	 * 获取页面右边提示元素
	 * 
	 * @return
	 */
	public WebElement getPageRightNoitce() {
		return element(GetByLocator.getLocator("login_noitce"));
	}

	// ---------------删除mirror相关------------------

	public WebElement getMirrorDeleteButton() {
		return element(GetByLocator.getLocator("mirror_delete_button"));
	}

	public WebElement getMirrorDeleteConfirm() {
		return element(GetByLocator.getLocator("mirror_delete_confirm"));
	}
	
	public WebElement getMirrorEditButton() {
		return element(GetByLocator.getLocator("mirror_edit_button"));
	}

}
