package com.figures_pack.entities;

import java.util.List;

import com.figures_pack.exceptions.IncorrectNumberOfPointsHasBeenReceivedAtTheInputException;
import com.figures_pack.exceptions.PointsDontFormRectangeleException;
import com.figures_pack.services.GeometryServices;

public class Rectangle extends Shape{

	public Rectangle(int id, List<Point> points) throws Exception
	{
		super(id);
		if(points == null){
			throw new NullPointerException();
		}
		if(points.size() != 4){
			throw new IncorrectNumberOfPointsHasBeenReceivedAtTheInputException();
		}
		if(!GeometryServices.doPointsFormRectnagle(points)){
			throw new PointsDontFormRectangeleException();
		}
		this.points = points;
	}
	
	@Override
	public int getId() {
		return super.getId();
	}

	@Override
	public boolean equals(Object obj) {
		// TODO Auto-generated method stub
		return super.equals(obj);
	}

	@Override
	public int hashCode() {
		// TODO Auto-generated method stub
		return super.hashCode();
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return super.toString();
	}
	
}
