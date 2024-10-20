package com.figures_pack.configs;

import java.io.File;
import java.io.FileInputStream;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.text.NumberFormat;
import java.util.Properties;

import com.figures_pack.exceptions.InitializeException;

public final class ConfigLoader{
	
	public static Properties props = null;
	public static final NumberFormat FORMATTER;
	public static final double EPSILON;

	static {
		props = new Properties();
		try (FileInputStream fis = new FileInputStream(new File("src/main/resources/config.properties"))) {
			props.load(fis);
			if(!epsiloValidate(props.getProperty("epsilon")))
				throw new InitializeException();
		} catch (Exception e) {
			throw new InitializeException();
		}
		
		String epsilonString = ConfigLoader.props.getProperty("epsilon");
		EPSILON = Double.parseDouble(epsilonString);

		DecimalFormatSymbols decimalFormatSymbols = new DecimalFormatSymbols();
		decimalFormatSymbols.setDecimalSeparator('.');
		FORMATTER = new DecimalFormat("#" + epsilonString.substring(0, epsilonString.length() - 1) + "0", decimalFormatSymbols);
	}

	private static boolean epsiloValidate(String value){
		if(value.isBlank() || value.isEmpty())
			return false;
		if(!value.matches("([0-9]*[.])?[0-9]+"))
			return false;
		return true;
	}
}
