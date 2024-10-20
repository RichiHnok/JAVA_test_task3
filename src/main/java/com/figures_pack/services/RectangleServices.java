package com.figures_pack.services;

import java.util.List;

import com.figures_pack.entities.Line;
import com.figures_pack.entities.Point;
import com.figures_pack.entities.Rectangle;

public class RectangleServices {

	public static boolean isConvex(Rectangle rec) throws Exception{
		List<Point> points = rec.getPoints();
		Line p1p4 = new Line(points.get(0), points.get(3));
		Line p2p3 = new Line(points.get(1), points.get(2));
		if(GeometryServices.findLineIntersectionPoint(p1p4, p2p3).equals(points.get(2)))
			return true;
		return false;
	}

	public static boolean isSquare(Rectangle rec){
		//TODO
		return false;
	}

	public static boolean isRombe(Rectangle rec){
		//TODO
		return false;
	}

	public static boolean isTrapezoid(Rectangle rec){
		//TODO
		return false;
	}
	
	public static double calculateArea(Rectangle rec){
		List<Point> points = rec.getPoints();
		double[] x = new double[4];
		double[] y = new double[4];
		for(int i = 0; i < 4; i++){
			x[i] = points.get(i).getX();
			y[i] = points.get(i).getY();
		}
		double area = Math.abs(x[0]*y[1] + x[1]*y[2] + x[2]*y[3] + x[3]*y[0] - (x[1]*y[0] + x[2]*y[1] + x[3]*y[2] + x[4]*y[3]))/2;
		return area;
	}

	public static double calculatePerimeter(Rectangle rec) throws Exception{
		double perimeter = 0;
		List<Point> points = rec.getPoints();
		for(int i = 0, n = points.size() - 1; i < n; i++){
			perimeter += GeometryServices.calcDistBetweenPoints(points.get(i), points.get(i+1));
		}
		perimeter += GeometryServices.calcDistBetweenPoints(points.getLast(), points.getFirst());
		return perimeter;
	}
}
