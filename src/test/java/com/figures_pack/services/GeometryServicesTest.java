package com.figures_pack.services;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import com.figures_pack.configs.ConfigLoader;
import com.figures_pack.entities.Line;
import com.figures_pack.entities.Point;

public class GeometryServicesTest {

	static Point p00, p03, p21, p22, p23, p30, p33, p01, p02, p13;
	static Line l1p00p03, l2p00p03, l3p30p33, l4p00p33, l5p13p22;
	
	@BeforeAll
	static void beforeClass() throws Exception {
		p00 = new Point(0D, 0D);
		p03 = new Point(0D, 3D);
		p21 = new Point(2d, 1d);
		p22 = new Point(2D, 2D);
		p23 = new Point(2D, 3D);
		p30 = new Point(3D, 0D);
		p33 = new Point(3D, 3D);
		p01 = new Point(0D, 1D);
		p02 = new Point(0D, 2D);
		p13 = new Point(1D, 3D);

		l1p00p03 = new Line(p00, p03);
		l2p00p03 = new Line(p00, p03);
		l3p30p33 = new Line(p30, p33);
		l4p00p33 = new Line(p00, p33);
		l5p13p22 = new Line(p13, p22);
	}

	@Test
	public void testDoSegmentsIntersect() {
		assertFalse(GeometryServices.doSegmentsIntersect(p00, p03, p03, p33));
		assertTrue(GeometryServices.doSegmentsIntersect(p00, p33, p03, p30));
	}

	@Test
	void testDoLinesIntersect() throws Exception{
		assertFalse(GeometryServices.doLinesIntersect(l1p00p03, l2p00p03));
		assertFalse(GeometryServices.doLinesIntersect(l1p00p03, l3p30p33));
		assertTrue(GeometryServices.doLinesIntersect(l1p00p03, l4p00p33));
	}

	@Test
	void testAreLinesParallel() throws Exception{
		assertFalse(GeometryServices.areLinesParallel(l1p00p03, l2p00p03));
		assertTrue(GeometryServices.areLinesParallel(l1p00p03, l3p30p33));
		assertFalse(GeometryServices.areLinesParallel(l1p00p03, l4p00p33));
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
	void testArePointsOnTheSameLine() throws Exception{
		assertThrows(Exception.class,() -> GeometryServices.arePointsOnTheSameLine(
			Arrays.asList()
		));
		assertThrows(Exception.class,() -> GeometryServices.arePointsOnTheSameLine(
			Arrays.asList(p00)
		));
		assertTrue(GeometryServices.arePointsOnTheSameLine(
			Arrays.asList(p00, p01)
		));
		assertTrue(GeometryServices.arePointsOnTheSameLine(
			Arrays.asList(p00, p01, p02)
		));
		assertTrue(GeometryServices.arePointsOnTheSameLine(
			Arrays.asList(p00, p01, p02, p03)
		));
		assertFalse(GeometryServices.arePointsOnTheSameLine(
			Arrays.asList(p00, p01, p21)
		));
	}

	@Test
	void testCalcDistBetweenPoints() {
		assertEquals(0d, GeometryServices.calcDistBetweenPoints(p00, p00), ConfigLoader.EPSILON);
		assertEquals(3d, GeometryServices.calcDistBetweenPoints(p00, p30), ConfigLoader.EPSILON);
		assertEquals(3d, GeometryServices.calcDistBetweenPoints(p00, p03), ConfigLoader.EPSILON);
		assertEquals(3*Math.sqrt(2), GeometryServices.calcDistBetweenPoints(p00, p33), ConfigLoader.EPSILON);
	}

	@Test
	void testFindLineIntersectionPoint() throws Exception {
		assertThrows(Exception.class, () -> GeometryServices.findLinesIntersectionPoint(l1p00p03, l2p00p03));
		assertThrows(Exception.class, () -> GeometryServices.findLinesIntersectionPoint(l1p00p03, l3p30p33));

		assertEquals(p00, GeometryServices.findLinesIntersectionPoint(l1p00p03, l4p00p33));
		assertEquals(p33, GeometryServices.findLinesIntersectionPoint(l4p00p33, l3p30p33));
		assertEquals(p22, GeometryServices.findLinesIntersectionPoint(l4p00p33, l5p13p22));
	}

	@Test
	void testIsPointOnLine() throws Exception {
		assertTrue(GeometryServices.isPointOnLine(p00, l1p00p03));
		assertTrue(GeometryServices.isPointOnLine(p02, l1p00p03));
		assertTrue(GeometryServices.isPointOnLine(p03, l1p00p03));
		assertFalse(GeometryServices.isPointOnLine(p30, l1p00p03));

		assertTrue(GeometryServices.isPointOnLine(p00, l4p00p33));
		assertTrue(GeometryServices.isPointOnLine(p33, l4p00p33));
		assertTrue(GeometryServices.isPointOnLine(p22, l4p00p33));
		assertFalse(GeometryServices.isPointOnLine(p21, l4p00p33));
	}
}
