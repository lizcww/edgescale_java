package com.nxp.EdgeScale.util;

import org.openqa.selenium.By;

import com.nxp.EdgeScale.Common;

public class GetByLocator {
	public static By getLocator(String key) {
		ProUtil pro = new ProUtil(Common.ELEMENT);
		String locator = pro.getPro(key);
		String locatorType = locator.split(">")[0];
		String locatorValue = locator.split(">")[1];
		if (locatorType.equals("id")) {
			return By.id(locatorValue);
		} else if (locatorType.equals("name")) {
			return By.name(locatorValue);
		} else if (locatorType.equals("tagName")) {
			return By.tagName(locatorValue);
		} else if (locatorType.equals("linkText")) {
			return By.linkText(locatorValue);
		} else if (locatorType.equals("className")) {
			return By.className(locatorValue);
		} else if (locatorType.equals("CSS")) {
			return By.cssSelector(locatorValue);
		} else {
			return By.xpath(locatorValue);
		}
	}

	public static By getLocator(String locatorType, String locatorValue) {
		if (locatorType.equals("id")) {
			return By.id(locatorValue);
		} else if (locatorType.equals("name")) {
			return By.name(locatorValue);
		} else if (locatorType.equals("tagName")) {
			return By.tagName(locatorValue);
		} else if (locatorType.equals("linkText")) {
			return By.linkText(locatorValue);
		} else if (locatorType.equals("className")) {
			return By.className(locatorValue);
		} else if (locatorType.equals("CSS")) {
			return By.cssSelector(locatorValue);
		} else {
			return By.xpath(locatorValue);
		}
	}

}
