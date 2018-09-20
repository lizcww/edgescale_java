package com.nxp.EdgeScale.util;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import com.nxp.EdgeScale.Common;

public class ProUtil {
	private Properties prop;
	private String filePaht;

	/**
	 * 构造方法
	 */
	public ProUtil(String filePath) {
		this.filePaht = filePath;
		this.prop = readProperties();
	}

	/**
	 * 读取配置文件
	 */
	private Properties readProperties() {
		Properties properties = new Properties();
		try {
			InputStream inputStream = new FileInputStream(filePaht);
			BufferedInputStream in = new BufferedInputStream(inputStream);
			properties.load(in);

		} catch (IOException e) {
			e.printStackTrace();
		}
		return properties;
	}

	/**
	 * 根据key读取关键字内容
	 */
	public String getPro(String key) {
		if (prop.containsKey(key)) {
			String username = prop.getProperty(key);
			return username;
		} else {
			System.out.println("你获取key值不对");
			return "";
		}
	}

	/**
	 * 写入内容
	 */
	public void writePro(String key, String value) {
		Properties pro = new Properties();
		try {
			FileOutputStream file = new FileOutputStream(filePaht,true);
			pro.setProperty(key, value);
			pro.store(file, key);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

//	/**
//	 * 替换配置文件中value中的内容
//	 * 
//	 * @param key
//	 * @param replace
//	 * @param newContent
//	 */
//	public void replaceContent(String key, String replace, String newContent) {
//		ProUtil pro = new ProUtil(Common.ELEMENT);
//		String locator = pro.getPro(key);
//		String locatorType = locator.split(">")[0];
//		String locatorValue = locator.split(">")[1];
//		String newValue = locatorValue.replace(replace, newContent);
//		pro.writePro(key, locatorType + ">" + newValue);
//		System.out.println("替换后  ==========" + pro.getPro(key));
//	}

}
