package com.nxp.EdgeScale.business;

import static org.testng.Assert.assertTrue;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.nxp.EdgeScale.base.DriverBase;
import com.nxp.EdgeScale.handle.MirrorPageHandle;
import com.nxp.EdgeScale.util.GetByLocator;
import com.nxp.EdgeScale.util.ThreadTime;

public class MirrorPagePro {

	public DriverBase driverBase;
	private MirrorPageHandle mph;

	public MirrorPagePro(DriverBase driverBase) {
		this.driverBase = driverBase;
		mph = new MirrorPageHandle(driverBase);
	}

	/**
	 * 创建mirror
	 * 
	 * @param name
	 * @param desc
	 */
	public void createMirror(String name, String desc) {
		mph.clickMirrorCreateButton();
		ThreadTime.sleep(5000);
		mph.sendKeysMirrorCreateNameInput(name);
		mph.sendKeysMirrorCreateDescInput(desc);
		mph.clickMirrorCreateSubmit();
	}

	/**
	 * 验证右边提示
	 * 
	 * @param rightNotice
	 */
	public void verifyRightNotice(String rightNotice) {
		WebDriverWait wait = new WebDriverWait(driverBase.driver, 20);
		wait.until(ExpectedConditions.presenceOfElementLocated(GetByLocator.getLocator("login_noitce")));
		String right = mph.getPageRightNotice();
		assertTrue(right.contains(rightNotice));
	}

	/**
	 * 编辑mirror
	 * 
	 * @param name
	 * @param desc
	 */
	public void editMirror(String name, String desc) {
		mph.clickMirrorEditButton();
		ThreadTime.sleep(5000);
		mph.sendKeysMirrorCreateNameInput(name);
		mph.sendKeysMirrorCreateDescInput(desc);
		mph.clickMirrorCreateSubmit();
	}

	/**
	 * 删除mirror
	 */
	public void deleteMirror() {
		mph.clickMirrorDeleteButton();
		ThreadTime.sleep(5000);
		mph.clickMirrorDeleteConfirm();
	}

}
