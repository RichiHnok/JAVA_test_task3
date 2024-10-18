package com.figures_pack.factories;

import java.util.List;

import com.figures_pack.entities.Point;
import com.figures_pack.entities.Rectangle;
import com.figures_pack.entities.Shape;

public class RectangleFactory extends ShapeFactory{

	private static int rectanglesCreated = 0;

	@Override
	public Shape createShape(List<Point> points) {
		Shape newRectangle = new Rectangle(++rectanglesCreated);
		return newRectangle;
	}
}
