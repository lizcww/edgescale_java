package com.nxp.EdgeScale.base;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

public class CaseBase {

	public DriverBase driverBase;
	private static Logger logger = Logger.getLogger(CaseBase.class);

	public DriverBase initDriver(String browser) {
		PropertyConfigurator.configure("log4j.properties");
		this.driverBase = new DriverBase(browser);
		logger.info("get a driverBase instance for " + browser);
		return driverBase;
	}

	public DriverBase getDriverBase() {
		return driverBase;
	}

}
