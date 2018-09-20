package com.nxp.EdgeScale.page;

import org.openqa.selenium.WebElement;

import com.nxp.EdgeScale.base.BasePage;
import com.nxp.EdgeScale.base.DriverBase;
import com.nxp.EdgeScale.util.GetByLocator;

public class AppDocumentPage extends BasePage {

	public AppDocumentPage(DriverBase driverBase) {
		super(driverBase);
	}

	
	public WebElement getAppDocumentContent() {
		return element(GetByLocator.getLocator("app_document_content"));
	}

	public WebElement getAppDocumentInput() {
		return element(GetByLocator.getLocator("app_document_input"));
	}

	public WebElement getAppDocumentSubmit() {
		return element(GetByLocator.getLocator("app_document_submint"));
	}

}
