package com.figures_pack.factories;

import java.util.List;

import com.figures_pack.entities.Point;
import com.figures_pack.entities.Rectangle;
import com.figures_pack.entities.Shape;
import com.figures_pack.exceptions.IncorrectNumberOfPointsHasBeenReceivedAtTheInputException;
import com.figures_pack.exceptions.PointsDontFormRectangeleException;

public class RectangleFactory extends ShapeFactory{

	private int rectanglesCreated = 0;

	@Override
	public Shape createShape(List<Point> points) throws PointsDontFormRectangeleException,
		IncorrectNumberOfPointsHasBeenReceivedAtTheInputException,
		Exception
	{
		Shape newRectangle = new Rectangle(rectanglesCreated++, points);
		return newRectangle;
	}
}
