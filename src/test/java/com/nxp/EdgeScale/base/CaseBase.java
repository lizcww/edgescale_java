package com.nxp.EdgeScale.base;

import org.testng.annotations.Listeners;
import com.nxp.EdgeScale.util.TestngListenerScreen;

public class CaseBase {

	private DriverBase driverBase;

	public DriverBase initDriver(String browser) {
		this.driverBase = new DriverBase(browser);
		return driverBase;
	}

	public DriverBase getDriverBase() {
		return driverBase;
	}

}
