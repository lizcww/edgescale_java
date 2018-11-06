package com.nxp.EdgeScale.util;

public class ThreadTime {
	public static void sleep(long time) {
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
