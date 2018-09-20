package com.nxp.EdgeScale.base;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchWindowException;
import org.openqa.selenium.WebElement;

public class BasePage {
	public DriverBase driverBase;

	public BasePage(DriverBase driverBase) {
		this.driverBase = driverBase;
	}

	/**
	 * 定位Element
	 * 
	 * @param By
	 *            by
	 */
	public WebElement element(By by) {
		WebElement element = driverBase.findElement(by);
		return element;
	}

	/**
	 * 层级定位，通过父节点定位到子节点 需要传入父节点和子节点的by
	 */
	public WebElement nodeElement(By by, By nodeby) {
		WebElement el = this.element(by);
		return el.findElement(nodeby);
	}

	/**
	 * 层级定位传入element，以及子的by
	 *
	 */
	public WebElement nodeElement(WebElement element, By by) {
		return element.findElement(by);
	}

	/**
	 * 定位一组elements
	 */
	public List<WebElement> elements(By by) {
		return driverBase.findElements(by);
	}

	/**
	 * 通过父节点定位一组elements
	 */
	public List<WebElement> elements(WebElement element, By by) {
		return element.findElements(by);
	}

	/**
	 * 封装点击
	 */
	public void click(WebElement element) {
		if (element != null) {
			element.click();
		} else {
			System.out.println("元素没有定位到，点击失败。");
		}
	}

	/**
	 * 封装输入
	 */
	public void sendkeys(WebElement element, String value) {
		if (element != null) {
			element.clear();
			element.sendKeys(value);
		} else {
			System.out.println(element + "元素没有定位到，输入失败" + value);
		}
	}

	/**
	 * 判断元素是否显示
	 */
	public boolean assertElementIs(WebElement element) {
		return element.isDisplayed();
	}

	/**
	 * 获取文本信息
	 */
	public String getText(WebElement element) {
		return element.getText();
	}

	/**
	 * 获取title
	 */
	public String getTitle() {
		return driverBase.getTitle();
	}

	/**
	 * 关闭浏览器
	 */
	public void close() {
		driverBase.close();
	}

	/**
	 * 获取当前窗口所有的windows
	 */
	public List<String> getWindowsHandles() {
		List<String> handles = driverBase.getWindowsHandles();
		return handles;
	}

	/**
	 * 根据title切换新窗口
	 */
	public boolean switchToWindow_Title(String windowTitle) {
		boolean flag = false;
		try {
			String currentHandle = driverBase.getWindowHandle();
			List<String> handles = driverBase.getWindowsHandles();
			for (String s : handles) {
				if (s.equals(currentHandle))
					continue;
				else {
					driverBase.switchWindows(s);
					if (driverBase.getTitle().contains(windowTitle)) {
						flag = true;
						System.out.println("切换windows成功: " + windowTitle);
						break;
					} else
						continue;
				}
			}
		} catch (NoSuchWindowException e) {
			System.out.println("Window: " + windowTitle + " 没找到!!!" + e.fillInStackTrace());
			flag = false;
		}
		return flag;
	}

	/**
	 * action事件
	 */
	public void action(WebElement element) {
		driverBase.action(element);
	}

}
