package com.figures_pack.entities;

import com.figures_pack.configs.ConfigLoader;
import com.figures_pack.exceptions.AnyValueYException;
import com.figures_pack.other.AreDoublesEqual;

public class Line {
	
	private double a;
	private double b;

	private boolean isVertical;
	private double verticalVal;

	public Line(double a, double b){
		this.a = a;
		this.b = b;
	}

	public Line(Point p1, Point p2) throws Exception{
		if(p1.equals(p2))
			throw new Exception(); //TODO
		double x1 =  p1.getX(), x2 = p2.getX();
		double y1 =  p1.getY(), y2 = p2.getY();
		if(AreDoublesEqual.check(x1 - x2, 0d)){
			isVertical = true;
			verticalVal = x1;
		}else{
			isVertical = false;
			a = (y1 - y2) / (x1 - x2);
			b = (x1*y2 - x2*y1) / (x1 - x2);
		}
	}

	public double getA() {
		return a;
	}

	public void setA(double a) {
		this.a = a;
	}

	public double getB() {
		return b;
	}
	
	public void setB(double b) {
		this.b = b;
	}

	public double getVerticalVal() throws Exception {
		if(!isVertical)
			throw new Exception();//TODO
		return verticalVal;
	}

	@Override
	public String toString() {
		return "Line [a=" + ConfigLoader.FORMATTER.format(a) + ", b=" + ConfigLoader.FORMATTER.format(b) + "]";
	}

	
	public double findY(double x) throws AnyValueYException{
		if(isVertical)
			throw new AnyValueYException(); //TODO
		return a * x + b;
	}

	public double findX(Line line, double y){

		return (y - b) / a;
	}
}
