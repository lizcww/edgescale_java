package com.nxp.EdgeScale.page;

import org.openqa.selenium.WebElement;

import com.nxp.EdgeScale.base.BasePage;
import com.nxp.EdgeScale.base.DriverBase;
import com.nxp.EdgeScale.util.GetByLocator;

public class VendorPage extends BasePage {

	public VendorPage(DriverBase driverBase) {
		super(driverBase);
	}

	public WebElement getVendorCreateButton() {
		return element(GetByLocator.getLocator("vendor_create_button"));
	}
	
	public WebElement getVendorNameInput() {
		return element(GetByLocator.getLocator("vendor_name_input"));
	}
	
	public WebElement getVendorCreateSubmitInput() {
		return element(GetByLocator.getLocator("vendor_create_submit"));
	}
	
	/**
	 * 获取页面右边提示元素
	 * 
	 * @return
	 */
	public WebElement getPageRightNoitce() {
		return element(GetByLocator.getLocator("login_noitce"));
	}
	
	public WebElement getVendorEditButton() {
		return element(GetByLocator.getLocator("vendor_edit_button"));
	}
	
	public WebElement getVendorDeleteButton() {
		return element(GetByLocator.getLocator("vendor_delete_button"));
	}
	
	public WebElement getVendorDeleteConfirm() {
		return element(GetByLocator.getLocator("vendor_delete_confirm"));
	}
	


}
