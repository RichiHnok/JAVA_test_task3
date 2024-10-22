package com.figures_pack.entities;

import com.figures_pack.configs.ConfigLoader;
import com.figures_pack.exceptions.AnyValueYException;
import com.figures_pack.exceptions.PlaceholderException;
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

	public Line(Point p1, Point p2) throws PlaceholderException{
		if(p1.equals(p2))
			throw new PlaceholderException(); //TODO Placeholder Excpetion
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

	public double getA() throws AnyValueYException {
		if(isVertical)
			throw new AnyValueYException();
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

	public double getVerticalVal() throws PlaceholderException {
		if(!isVertical)
			throw new PlaceholderException();//TODO Placeholder Excpetion
		return verticalVal;
	}
	
	public double findY(double x) throws AnyValueYException{
		if(isVertical)
			throw new AnyValueYException(); //TODO Доделать это исключение
		return a * x + b;
	}

	public double findX(Line line, double y){

		return (y - b) / a;
	}

	@Override
	public boolean equals(Object obj) {
		if(this == obj)
			return true;
		if(obj.getClass() != Line.class)
			return false;
		Line otherLine = (Line) obj;
		if(this.isVertical != otherLine.isVertical)
			return false;
		if(isVertical){
			return AreDoublesEqual.check(this.verticalVal, otherLine.verticalVal);
		}else{
			try {
				if(!AreDoublesEqual.check(a, otherLine.getA()))
					return false;
			} catch (AnyValueYException e) {
			}
			if(!AreDoublesEqual.check(b, otherLine.getB()))
				return false;
		}
		return true;
	}

	@Override
	public int hashCode() {
		// TODO Auto-generated method stub
		return super.hashCode();
	}

	@Override
	public String toString() {
		return "Line [a=" + ConfigLoader.FORMATTER.format(a) + ", b=" + ConfigLoader.FORMATTER.format(b) + "]";
	}	
}
