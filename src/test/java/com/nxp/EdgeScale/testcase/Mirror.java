package com.nxp.EdgeScale.testcase;

import java.util.concurrent.TimeUnit;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import com.nxp.EdgeScale.Common;
import com.nxp.EdgeScale.Url;
import com.nxp.EdgeScale.base.CaseBase;
import com.nxp.EdgeScale.base.DriverBase;
import com.nxp.EdgeScale.business.MirrorPagePro;
import com.nxp.EdgeScale.util.HandleCookie;
import com.nxp.EdgeScale.util.ProUtil;
import com.nxp.EdgeScale.util.ThreadTime;

public class Mirror extends CaseBase {

	private DriverBase driverBase;
	private MirrorPagePro mirrorPagePro;
	private HandleCookie handleCookie;

	private static Logger logger = Logger.getLogger(Mirror.class);

	@BeforeClass(alwaysRun = true)
	public void init() {
		PropertyConfigurator.configure("log4j.properties");
		this.driverBase = initDriver(Common.BROWSER);
		driverBase.driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		mirrorPagePro = new MirrorPagePro(driverBase);
		handleCookie = new HandleCookie(driverBase);
		driverBase.get(Url.BASE_URL + Url.MIRROR);
		handleCookie.setCookie_commonUser1();
		driverBase.get(Url.BASE_URL + Url.MIRROR);
		ThreadTime.sleep(5000);
	}

	@Test(groups = {"createMirror"})
	public void testCreateMirror() {
		logger.info("创建mirror开始");
		ProUtil proUtil = new ProUtil(Common.PARAMETER);
		mirrorPagePro.createMirror(proUtil.getPro("mirrorName"), proUtil.getPro("mirror_description"));
		logger.info("创建mirror结束");
		mirrorPagePro.verifyRightNotice(new ProUtil(Common.PARAMETER).getPro("login_success_notice"));
		logger.info("创建mirror成功");
	}

	@Test(groups = {"deleteMirror"})
	public void testDeleteMirror() {
		logger.info("删除mirror开始");
		mirrorPagePro.deleteMirror();
		logger.info("删除mirror结束");
		mirrorPagePro.verifyRightNotice(new ProUtil(Common.PARAMETER).getPro("login_success_notice"));
		logger.info("删除mirror成功");
	}

	@Test(groups = {"editMirror"})
	public void testEditMirror() {
		logger.info("修改mirror开始");
		ProUtil proUtil = new ProUtil(Common.PARAMETER);
		mirrorPagePro.editMirror(proUtil.getPro("edit_mirrorName"), proUtil.getPro("edit_mirror_description"));
		logger.info("修改mirror结束");
		mirrorPagePro.verifyRightNotice(new ProUtil(Common.PARAMETER).getPro("login_success_notice"));
		logger.info("修改mirror成功");
	}

	@AfterClass(alwaysRun = true)
	public void close() {
		driverBase.close();
	}

}
