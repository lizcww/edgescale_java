package com.nxp.EdgeScale.business;

import com.nxp.EdgeScale.base.DriverBase;
import com.nxp.EdgeScale.handle.AppDocumentPageHandle;
import com.nxp.EdgeScale.handle.AppPageHandle;

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
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		aph.clickAppDocumentButton();
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		adph.clickAppDocumentContent();
		adph.clearAppDocumentContent();
		adph.sendKeysAppDocumentInput(content);
		adph.clickAppDocumentSubmit();
	}
}
