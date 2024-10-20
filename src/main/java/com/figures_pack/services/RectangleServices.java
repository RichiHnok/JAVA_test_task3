package com.figures_pack.services;

import java.util.List;

import com.figures_pack.entities.Point;
import com.figures_pack.entities.Rectangle;
import com.figures_pack.other.AreDoublesEqual;

public class RectangleServices {

	public static boolean isConvex(Rectangle rec) throws Exception{
		boolean isPositive = false;
		List<Point> points = rec.getPoints();

		for (int i = 0, n = 4; i < n; i++) {
			Point p1 = points.get(i);
			Point p2 = points.get((i + 1) % n);
			Point p3 = points.get((i + 2) % n);

			double crossProduct = GeometryServices.crossProduct(p1, p2, p3);

			if (i == 0) {
					isPositive = crossProduct > 0;
			} else {
					if ((crossProduct > 0) != isPositive) {
						return false;
					}
			}
		}
		return true;
	}

	public static boolean isSquare(Rectangle rec){
		//TODO
		List<Point> points = rec.getPoints();
		double sideLength = 0;
		for(int i = 0; i < 4; i++){
			if(i == 0){
				sideLength = GeometryServices.calcDistBetweenPoints(points.get(i), points.get(i+1));
			}else if(!AreDoublesEqual.check(
				sideLength,
				GeometryServices.calcDistBetweenPoints(points.get(i%4), points.get((i+1)%4))
			)){
				return false;
			}
		}

		if(!AreDoublesEqual.check(
			GeometryServices.calcDistBetweenPoints(points.get(0), points.get(2)),
			Math.sqrt(2)*sideLength
		)){
			return false;
		}
		return true;
	}

	public static boolean isRombe(Rectangle rec){
		//TODO
		return false;
	}

	public static boolean isTrapezoid(Rectangle rec){
		//TODO
		return false;
	}
	
	public static double calculateArea(Rectangle rec) throws Exception{
		if(!isConvex(rec))
			throw new Exception(); //TODO Затычка. Для впуклого угольника считать площадь тяжело

		List<Point> points = rec.getPoints();
		double[] x = new double[4];
		double[] y = new double[4];
		for(int i = 0; i < 4; i++){
			x[i] = points.get(i).getX();
			y[i] = points.get(i).getY();
		}
		double area = Math.abs(x[0]*y[1] + x[1]*y[2] + x[2]*y[3] + x[3]*y[0] - (x[1]*y[0] + x[2]*y[1] + x[3]*y[2] + x[0]*y[3]))/2;
		return area;
	}

	public static double calculatePerimeter(Rectangle rec) throws Exception{
		double perimeter = 0;
		List<Point> points = rec.getPoints();
		for(int i = 0, n = points.size(); i < n; i++){
			perimeter += GeometryServices.calcDistBetweenPoints(points.get(i%4), points.get((i+1)%4));
		}
		return perimeter;
	}
}
