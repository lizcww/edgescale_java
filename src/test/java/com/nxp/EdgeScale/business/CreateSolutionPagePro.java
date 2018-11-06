package com.nxp.EdgeScale.business;

import static org.testng.Assert.assertTrue;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.nxp.EdgeScale.base.DriverBase;
import com.nxp.EdgeScale.handle.CreateSolutionPageHandle;
import com.nxp.EdgeScale.util.GetByLocator;
import com.nxp.EdgeScale.util.ThreadTime;

public class CreateSolutionPagePro {

	public CreateSolutionPageHandle csph;
	public DriverBase driverBase;

	public CreateSolutionPagePro(DriverBase driverBase) {
		this.driverBase = driverBase;
		csph = new CreateSolutionPageHandle(driverBase);
	}

	/**
	 * 创建solution
	 * 
	 * @param modelName
	 * @param solutionName
	 * @param version
	 * @param imageUrl
	 */
	public void createSolution(String modelName, String solutionName, String version, String imageUrl) {
		//Basic info
		csph.clickModelNameInput();
		ThreadTime.sleep(7000);		
		csph.clickModelNameInputList(modelName);
		ThreadTime.sleep(5000);	
		csph.sendKeysSolutionNameInput(solutionName);
		ThreadTime.sleep(5000);	
		csph.sendKeysVersionInput(version);
		ThreadTime.sleep(5000);		
		csph.clickVersionInputList(version);
		ThreadTime.sleep(5000);	
		csph.clickNextButton();		
		ThreadTime.sleep(5000);	
		
		//permission
		csph.clickNext2Button();		
		ThreadTime.sleep(5000);	
		
		//firmware
		csph.sendKeysImageUrlInput(imageUrl);
		ThreadTime.sleep(5000);	
		csph.clickSubmitButton();
		ThreadTime.sleep(5000);
	}
	
	/**
	 * 验证右边提示
	 * 
	 * @param rightNotice
	 */
	public void verifyRightNotice(String rightNotice) {
		WebDriverWait wait = new WebDriverWait(driverBase.driver, 20);
		wait.until(ExpectedConditions.presenceOfElementLocated(GetByLocator.getLocator("login_noitce")));
		String right = csph.getPageRightNotice();
		assertTrue(right.contains(rightNotice));
	}

}
