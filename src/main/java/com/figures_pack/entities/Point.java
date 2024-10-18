package com.figures_pack.entities;

import java.text.DecimalFormat;
import java.text.NumberFormat;

import com.figures_pack.configs.PropertiesClass;

public class Point {

	private Double x;
	private Double y;

	private static final NumberFormat FORMATTER;
	private static final double EPSILON;

	static{
		String epsilonString = PropertiesClass.props.getProperty("epsilon");
		EPSILON = Double.parseDouble(epsilonString);
		FORMATTER = new DecimalFormat("#" + epsilonString.substring(0, epsilonString.length() - 1) + "0");
	}

	public Double getX() {
		return x;
	}

	public void setX(Double x) {
		this.x = x;
	}

	public Double getY() {
		return y;
	}

	public void setY(Double y) {
		this.y = y;
	}

	public void setXY(Double x, Double y){
		this.x = x;
		this.y = y;
	}

	@Override
	public boolean equals(Object obj) {
		if(this == obj)
			return true;
		if(obj.getClass() != Point.class)
			return false;
		Point otherPoint = (Point) obj;
		if(Math.abs(this.x - otherPoint.getX()) > EPSILON)
			return false;
		if(Math.abs(this.y - otherPoint.getY()) > EPSILON)
			return false;
		return true;
	}
	
	@Override
	public int hashCode() {
		return super.hashCode();
	}

	@Override
	public String toString() {
		return "Point [x=" + FORMATTER.format(x) + ", y=" + FORMATTER.format(y) + "]";
	}
}
