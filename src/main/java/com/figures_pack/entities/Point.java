package com.figures_pack.entities;

import com.figures_pack.configs.ConfigLoader;
import com.figures_pack.other.AreDoublesEqual;

public class Point {

	private double x;
	private double y;

	public Point(Double x, Double y) {
		this.x = x;
		this.y = y;
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
		if(!AreDoublesEqual.check(x, otherPoint.getX()))
			return false;
		if(!AreDoublesEqual.check(y, otherPoint.getY()))
			return false;
		return true;
	}
	
	@Override
	public int hashCode() {
		return super.hashCode();
	}

	@Override
	public String toString() {
		return "Point [x=" + ConfigLoader.FORMATTER.format(x) + "; y=" + ConfigLoader.FORMATTER.format(y) + "]";
	}
}
