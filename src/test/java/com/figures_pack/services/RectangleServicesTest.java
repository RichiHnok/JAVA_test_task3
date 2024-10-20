package com.figures_pack.services;

import static org.junit.Assert.*;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.Arrays;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import com.figures_pack.configs.ConfigLoader;
import com.figures_pack.entities.Point;
import com.figures_pack.entities.Rectangle;
import com.figures_pack.exceptions.IncorrectNumberOfPointsHasBeenReceivedAtTheInputException;
import com.figures_pack.exceptions.PointsDontFormRectangeleException;
import com.figures_pack.factories.RectangleFactory;

public class RectangleServicesTest {

	public static Rectangle romboid;
	public static Rectangle trapezoid;
	public static Rectangle kvadrat;
	public static Rectangle vpuklyi;

	@BeforeAll
	static void beforeClass() throws PointsDontFormRectangeleException, IncorrectNumberOfPointsHasBeenReceivedAtTheInputException, Exception {
		RectangleFactory factory = new RectangleFactory();
		romboid = factory.createShape(Arrays.asList(
			new Point(0d, 2d),
			new Point(1d, 0d),
			new Point(2d, 2d),
			new Point(1d, 4d)
		));

		trapezoid = factory.createShape(Arrays.asList(
			new Point(0d, 0d),
			new Point(2d, 3d),
			new Point(3d, 3d),
			new Point(3d, 0d)
		));

		kvadrat = factory.createShape(Arrays.asList(
			new Point(0d, 0d),
			new Point(0d, 3d),
			new Point(3d, 3d),
			new Point(3d, 0d)
		));

		vpuklyi = factory.createShape(Arrays.asList(
			new Point(0d, 0d),
			new Point(2d, 1d),
			new Point(3d, 3d),
			new Point(3d, 0d)
		));
	}

	@Test
	void testCalculateArea() throws Exception {
		assertEquals(9d, RectangleServices.calculateArea(kvadrat), ConfigLoader.EPSILON);
		assertEquals(4d, RectangleServices.calculateArea(romboid), ConfigLoader.EPSILON);
		assertEquals(6d, RectangleServices.calculateArea(trapezoid), ConfigLoader.EPSILON);
		assertThrows(Exception.class, () -> RectangleServices.calculateArea(vpuklyi));
	}

	@Test
	void testCalculatePerimeter() throws Exception {
		assertEquals(12d, RectangleServices.calculatePerimeter(kvadrat), ConfigLoader.EPSILON);
		assertEquals(8.944271, RectangleServices.calculatePerimeter(romboid), ConfigLoader.EPSILON);
		assertEquals(10.605551, RectangleServices.calculatePerimeter(trapezoid), ConfigLoader.EPSILON);
		assertEquals(10.47213, RectangleServices.calculatePerimeter(vpuklyi), ConfigLoader.EPSILON);
	}

	@Test
	void testIsConvex() throws Exception {
		assertTrue(RectangleServices.isConvex(kvadrat));
		assertTrue(RectangleServices.isConvex(trapezoid));
		assertTrue(RectangleServices.isConvex(romboid));
		assertFalse(RectangleServices.isConvex(vpuklyi));
	}

	@Test
	void testIsRombe() {
		//TODO
	}

	@Test
	void testIsSquare() throws Exception {
		assertEquals(true, RectangleServices.isSquare(kvadrat));
		assertFalse(RectangleServices.isSquare(trapezoid));
		assertFalse(RectangleServices.isSquare(romboid));
		assertFalse(RectangleServices.isSquare(vpuklyi));
	}

	@Test
	void testIsTrapezoid() {
		//TODO
	}
}
