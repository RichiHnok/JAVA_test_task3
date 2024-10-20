package com.figures_pack.services;

import java.util.List;

import com.figures_pack.entities.Line;
import com.figures_pack.entities.Point;
import com.figures_pack.exceptions.AnyValueYException;
import com.figures_pack.other.AreDoublesEqual;

public class GeometryServices {
	
	public static boolean doSegmentsIntersect(Point A, Point B, Point C, Point D){
		double d1 = crossProduct(A, B, C);
		double d2 = crossProduct(A, B, D);
		double d3 = crossProduct(C, D, A);
		double d4 = crossProduct(C, D, B);

		if (((d1 > 0 && d2 < 0) || (d1 < 0 && d2 > 0)) &&
			((d3 > 0 && d4 < 0) || (d3 < 0 && d4 > 0))) {
			return true;
		}
		return false;
	}

	private static double crossProduct(Point A, Point B, Point C) {
		double ABx = B.getX() - A.getX();
		double ABy = B.getY() - A.getY();
		double ACx = C.getX() - A.getX();
		double ACy = C.getY() - A.getY();
		return ABx * ACy - ABy * ACx;
	}
		
	public static boolean doLinesIntersect(Line l1, Line l2){
		if(AreDoublesEqual.check(l1.getA(), l2.getA()))
			return false;
		return true;
	}

	public static boolean areLinesParallel(Line l1, Line l2){
		if(! AreDoublesEqual.check(l1.getA(), l2.getA()))
			return false;
		if(! AreDoublesEqual.check(l1.getB(), l2.getB()))
			return false;
		return true;
	}

	public static boolean isPointOnLine(Point point, Line line) throws Exception{
		try {
			if(AreDoublesEqual.check(line.findY(point.getX()), point.getY()))
				return true;
		} catch (AnyValueYException e) {
			if(AreDoublesEqual.check(point.getX(), line.getVerticalVal()))
				return true;
		}
		return false;
	}

	public static Point findLineIntersectionPoint(Line l1, Line l2) throws Exception{
		if(!doLinesIntersect(l1, l2))
			throw new Exception(); //TODO Сделать отдельный Exception
		double a1 = l1.getA(), a2 = l2.getA();
		double b1 = l1.getB(), b2 = l2.getB();
		double x = (b2 - b1) / (a1 - a2);
		double y = (a1*b2 - b1 * a2) / (a1 - a2);
		return new Point(x, y);
	}

	public static double calcDistBetweenPoints(Point p1, Point p2){
		double x1 = p1.getX(), x2 = p2.getX();
		double y1 = p1.getY(), y2 = p2.getY();
		double distance = Math.sqrt(Math.pow((x2 - x1),2) + Math.pow((y2 - y1),2));
		return distance;
	}
	
	public static boolean doPointsFormRectnagle(List<Point> points) throws Exception{
		if(points.size() < 2 || points.size() > 4)
			throw new Exception(); //TODO Сделать конкретное исключение
		//DONE+ Никакие три точки не должны лежать на одной прямой
		for(int i = 0; i < 4; i++){
			Point p1 = points.get(i%4);
			Point p2 = points.get((i+1)%4);
			Point p3 = points.get((i+2)%4);
			Point p4 = points.get((i+3)%4);
			// Line l = new Line(points.get(i%4), points.get((i+1)%4));
			// if(isPointOnLine(points.get((i+2)%4), l) || isPointOnLine(points.get((i+3)%4), l))
			// 	return false;
			Line l = new Line(p1, p2);
			boolean b1 = isPointOnLine(p3, l);
			boolean b2 = isPointOnLine(p4, l);
			if(b1 || b2)
				return false;
		}
		//DONE+ Стороны не должны пересекаться
		if(doSegmentsIntersect(points.get(1), points.get(2), points.get(0), points.get(3))||
			doSegmentsIntersect(points.get(1), points.get(0), points.get(2), points.get(3))
		) {
			return false;	
		}
		return true;
	}

	public static boolean arePointsOnTheSameLine(List<Point> points) throws Exception{
		if(points.size() < 2)
			throw new Exception(); //TODO Сделать конкретное исключение
		
		Line line = new Line(points.get(0), points.get(1));
		for(int i = 2, n = points.size(); i < n; i++){
			if(!isPointOnLine(points.get(i), line))
				return false;
		}
		return true;
	}
}
