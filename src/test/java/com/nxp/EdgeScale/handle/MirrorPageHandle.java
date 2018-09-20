package com.nxp.EdgeScale.handle;

import com.nxp.EdgeScale.base.DriverBase;
import com.nxp.EdgeScale.page.MirrorPage;

public class MirrorPageHandle {

	public DriverBase driverBase;
	public MirrorPage mp;

	public MirrorPageHandle(DriverBase driverBase) {
		this.driverBase = driverBase;
		mp = new MirrorPage(driverBase);
	}

	public void clickMirrorCreateButton() {
		mp.click(mp.getMirrorCreateButton());
	}

	public void sendKeysMirrorCreateNameInput(String name) {
		mp.sendkeys(mp.getMirrorCreateNameInput(), name);
	}

	public void sendKeysMirrorCreateDescInput(String desc) {
		mp.sendkeys(mp.getMirrorCreateDescInput(), desc);
	}

	public void clickMirrorCreateSubmit() {
		mp.click(mp.getMirrorCreateSubmit());
	}

	/**
	 * 获取页面右边提示文本
	 * 
	 * @return
	 */
	public String getPageRightNotice() {
		return mp.getPageRightNoitce().getText();
	}
	
	// ---------------删除mirror相关------------------
	
	public void clickMirrorDeleteButton() {
		mp.click(mp.getMirrorDeleteButton());
	}
	
	public void clickMirrorDeleteConfirm() {
		mp.click(mp.getMirrorDeleteConfirm());
	}
	
	public void clickMirrorEditButton() {
		mp.click(mp.getMirrorEditButton());
	}

}
