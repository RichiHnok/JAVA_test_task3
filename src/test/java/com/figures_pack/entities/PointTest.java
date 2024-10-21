package com.figures_pack.entities;

import static org.junit.Assert.assertEquals;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import com.figures_pack.configs.ConfigLoader;

public class PointTest {

	static Point point;

	@BeforeAll
	static void init(){
		point = new Point(3.1234567, 765432.1);
	}

	@Test
	void testGetX() {
		assertEquals(3.123, point.getX(), ConfigLoader.EPSILON);
	}

	@Test
	void testGetY() {
		assertEquals(765432.1, point.getY(), ConfigLoader.EPSILON);
	}

	@Test
	void testToString() {
		assertEquals("Point [x=3.123; y=765432.100]", point.toString());
	}
}
