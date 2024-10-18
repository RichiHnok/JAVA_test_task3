package com.figures_pack.configs;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

public class PropertiesClass{
	
	public static Properties props = null;

	static {
		props = new Properties();
		try (FileInputStream fis = new FileInputStream(new File("src/main/resources/config.properties"))) {
			props.load(fis);
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
}
