package com.figures_pack.factories;

import java.util.List;

import com.figures_pack.entities.Point;
import com.figures_pack.entities.Shape;

public abstract class ShapeFactory {
	
	public abstract Shape createShape(List<Point> points);
}
