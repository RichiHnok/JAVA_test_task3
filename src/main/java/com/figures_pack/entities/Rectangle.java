package com.figures_pack.entities;

import java.util.List;

import com.figures_pack.exceptions.IncorrectNumberOfPointsHasBeenReceivedAtTheInputException;
import com.figures_pack.exceptions.PlaceholderException;
import com.figures_pack.exceptions.PointsDontFormRectangeleException;
import com.figures_pack.services.GeometryServices;

public class Rectangle extends Shape{

	public Rectangle(List<Point> points) throws
		IncorrectNumberOfPointsHasBeenReceivedAtTheInputException,
		PointsDontFormRectangeleException,
		PlaceholderException
	{
		super(-1);
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

	public Rectangle(int id, List<Point> points)
		throws PointsDontFormRectangeleException,
		IncorrectNumberOfPointsHasBeenReceivedAtTheInputException,
		PlaceholderException
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
		if(this == obj)
			return true;
		if(!(obj instanceof Rectangle))
			return false;
		
		Rectangle otherRec = (Rectangle) obj;
		List<Point> points1 = this.points;
		List<Point> points2 = otherRec.getPoints();
		
		for(Point p1 : points1){
			boolean isPresentInOther = false;
			for(Point p2 : points2){
				if(p1.equals(p2))
					isPresentInOther = true;
			}
			if(!isPresentInOther)
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
		return "Rectangle [id=" + id + ", points=" + points + "]";
	}	
}
