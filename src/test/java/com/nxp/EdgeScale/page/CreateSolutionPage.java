package com.nxp.EdgeScale.page;

import org.openqa.selenium.WebElement;

import com.nxp.EdgeScale.Common;
import com.nxp.EdgeScale.base.BasePage;
import com.nxp.EdgeScale.base.DriverBase;
import com.nxp.EdgeScale.util.GetByLocator;
import com.nxp.EdgeScale.util.ProUtil;

public class CreateSolutionPage extends BasePage{

	public CreateSolutionPage(DriverBase driverBase) {
		super(driverBase);
	}
	
	public WebElement getModelNameInput() {
		return element(GetByLocator.getLocator("create_solution_modelName_input"));
	}
	
	public WebElement getModelNameInputList(String modelName) {
		ProUtil pro = new ProUtil(Common.ELEMENT);
		String locator = pro.getPro("create_solution_modelName_input_list");
		String locatorType = locator.split(">")[0];
		String locatorValue = locator.split(">")[1];
		String newValue = locatorValue.replace("modelName", modelName);
		System.out.println("替换后  ==========" + newValue);
		return element(GetByLocator.getLocator(locatorType, newValue));
	}
	
	public WebElement getSolutionNameInput() {
		return element(GetByLocator.getLocator("create_solution_solutionName_input"));
	}
	
	public WebElement getVersionInput() {
		return element(GetByLocator.getLocator("create_solution_version_input"));
	}
	
	public WebElement getVersionInputList(String version) {
		ProUtil pro = new ProUtil(Common.ELEMENT);
		String locator = pro.getPro("create_solution_version_input_list");
		String locatorType = locator.split(">")[0];
		String locatorValue = locator.split(">")[1];
		String newValue = locatorValue.replace("version", version);
		System.out.println("替换后  ==========" + newValue);
		return element(GetByLocator.getLocator(locatorType, newValue));
	}
	
	public WebElement getNextButton() {
		return element(GetByLocator.getLocator("create_solution_next_button"));
	}
	
	public WebElement getNext2Button() {
		return element(GetByLocator.getLocator("create_solution_next2_button"));
	}
	
	public WebElement getImageUrlInput() {
		return element(GetByLocator.getLocator("create_solution_imageUrl_input"));
	}
	
	public WebElement getSubmitButton() {
		return element(GetByLocator.getLocator("create_solution_submit_button"));
	}
	
	/**
	 * 获取页面右边提示元素
	 * 
	 * @return
	 */
	public WebElement getPageRightNoitce() {
		return element(GetByLocator.getLocator("login_noitce"));
	}
	

}
