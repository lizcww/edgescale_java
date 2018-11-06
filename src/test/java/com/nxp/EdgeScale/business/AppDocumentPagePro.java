package com.nxp.EdgeScale.business;

import com.nxp.EdgeScale.base.DriverBase;
import com.nxp.EdgeScale.handle.AppDocumentPageHandle;
import com.nxp.EdgeScale.handle.AppPageHandle;
import com.nxp.EdgeScale.util.ThreadTime;

public class AppDocumentPagePro {

	private DriverBase driverBase;
	private AppDocumentPageHandle adph;
	private AppPageHandle aph;

	public AppDocumentPagePro(DriverBase driverBase) {
		this.driverBase = driverBase;
		adph = new AppDocumentPageHandle(driverBase);
		aph = new AppPageHandle(driverBase);
	}

	/**
	 * 更改app document
	 * 
	 * @param content
	 */
	public void updateAppDocument(String content) {
		aph.clickMyAppButton();
		ThreadTime.sleep(3000);
		aph.clickAppDocumentButton();
		ThreadTime.sleep(7000);
		adph.clickAppDocumentContent();
		ThreadTime.sleep(3000);
		adph.clearAppDocumentContent();
		adph.sendKeysAppDocumentInput(content);
		adph.clickAppDocumentSubmit();
		ThreadTime.sleep(3000);
	}
}
