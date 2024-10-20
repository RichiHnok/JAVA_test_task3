package com.figures_pack.factories;

import java.util.List;

import com.figures_pack.entities.Point;
import com.figures_pack.entities.Shape;
import com.figures_pack.exceptions.IncorrectNumberOfPointsHasBeenReceivedAtTheInputException;
import com.figures_pack.exceptions.PointsDontFormRectangeleException;

public abstract class ShapeFactory {
	
	public abstract Shape createShape(List<Point> points) throws PointsDontFormRectangeleException,
		IncorrectNumberOfPointsHasBeenReceivedAtTheInputException,
		Exception;
}
