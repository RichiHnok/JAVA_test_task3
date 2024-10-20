package com.figures_pack.services;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import com.figures_pack.entities.Line;
import com.figures_pack.entities.Point;

public class GeometryServicesTest {

	static Point p00, p03, p21, p22, p23, p30, p33;
	
	@BeforeAll
	static void beforeClass() {
		p00 = new Point(0D, 0D);
		p03 = new Point(0D, 3D);
		p21 = new Point(2d, 1d);
		p22 = new Point(2D, 2D);
		p23 = new Point(2D, 3D);
		p30 = new Point(3D, 0D);
		p33 = new Point(3D, 3D);
	}

	@Test
	public void testDoSegmentsIntersect() {
		assertFalse(GeometryServices.doSegmentsIntersect(p00, p03, p03, p33));
		assertTrue(GeometryServices.doSegmentsIntersect(p00, p33, p03, p30));
	}

	@Test
	void testDoLinesIntersect() throws Exception {
		//TODO
		Line l1p00p03 = new Line(p00, p03);
		Line l2p00p03 = new Line(p00, p03);
		Line l3p30p33 = new Line(p30, p33);
		Line l4p00p33 = new Line(p00, p33);

		assertFalse(GeometryServices.doLinesIntersect(l1p00p03, l2p00p03), "1");
		assertFalse(GeometryServices.doLinesIntersect(l1p00p03, l3p30p33), "2");
		assertTrue(GeometryServices.doLinesIntersect(l1p00p03, l4p00p33), "3");
	}

	@Test
	void testAreLinesParallel() {
		//TODO
	}

	@Test
	void testDoPointsFormRectnagle() throws Exception {
		assertTrue(GeometryServices.doPointsFormRectnagle(
			Arrays.asList(p00, p03, p33, p30)
		), "Square");
		assertTrue(GeometryServices.doPointsFormRectnagle(
			Arrays.asList(p00, p23, p33, p30)
		), "Trapezoid");
		assertTrue(GeometryServices.doPointsFormRectnagle(
			Arrays.asList(p00, p21, p33, p30)
		), "non-Convex Rectangle");

		assertFalse(GeometryServices.doPointsFormRectnagle(
			Arrays.asList(p00, p03, p30, p33)
		), "irregular Rectangle");
		assertFalse(GeometryServices.doPointsFormRectnagle(
			Arrays.asList(p00, p33, p30, p03)
		), "irregular Rectangle");
		assertFalse(GeometryServices.doPointsFormRectnagle(
			Arrays.asList(p00, p22, p33, p23)
		), "3 point On One Line");
	}

	@Test
	void testDoPointsOnTheSameLine() {
		//TODO
	}

	@Test
	void testCalcDistBetweenPoints() {
		//TODO
	}

	@Test
	void testFindLineIntersectionPoint() {
		//TODO
	}

	@Test
	void testIsPointOnLine() {
		//TODO
	}
}
