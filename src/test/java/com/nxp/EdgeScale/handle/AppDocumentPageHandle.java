package com.nxp.EdgeScale.handle;

import com.nxp.EdgeScale.base.DriverBase;
import com.nxp.EdgeScale.page.AppDocumentPage;

public class AppDocumentPageHandle {

	private DriverBase driverBase;
	private AppDocumentPage adp;

	public AppDocumentPageHandle(DriverBase driverBase) {
		this.driverBase = driverBase;
		adp = new AppDocumentPage(driverBase);
	}

	

	public void clickAppDocumentContent() {
		adp.click(adp.getAppDocumentContent());
	}

	public void clearAppDocumentContent() {
		adp.getAppDocumentContent().clear();
	}

	public void sendKeysAppDocumentInput(String content) {
		adp.sendkeys(adp.getAppDocumentInput(), content);
	}

	public void clickAppDocumentSubmit() {
		adp.click(adp.getAppDocumentSubmit());
	}

}
