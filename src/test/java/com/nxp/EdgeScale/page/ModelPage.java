package com.nxp.EdgeScale.page;

import org.openqa.selenium.WebElement;

import com.nxp.EdgeScale.base.BasePage;
import com.nxp.EdgeScale.base.DriverBase;
import com.nxp.EdgeScale.util.GetByLocator;

public class ModelPage extends BasePage {

	public ModelPage(DriverBase driverBase) {
		super(driverBase);
	}

	public WebElement getModelEditButton() {
		return element(GetByLocator.getLocator("model_edit_button"));
	}

	public WebElement getModelDeleteButton() {
		return element(GetByLocator.getLocator("model_delete_button"));
	}

	public WebElement getModelDeleteConfirmButton() {
		return element(GetByLocator.getLocator("model_delete_confirm"));
	}

	/**
	 * 获取页面右边提示元素
	 * 
	 * @return
	 */
	public WebElement getPageRightNoitce() {
		return element(GetByLocator.getLocator("login_noitce"));
	}

	
	// ---------------查找model 相关--------------------
	
	public WebElement getFindByModelInput() {
		return element(GetByLocator.getLocator("find_by_model_input"));
	}

	public WebElement getFindByTypeInput() {
		return element(GetByLocator.getLocator("find_by_type_input"));
	}

	public WebElement getFindByPlatformInput() {
		return element(GetByLocator.getLocator("find_by_platform_input"));
	}

	public WebElement getFindByVendorInput() {
		return element(GetByLocator.getLocator("find_by_vendor_input"));
	}

	public WebElement getFindModelsButton() {
		return element(GetByLocator.getLocator("findModels_button"));
	}

}
