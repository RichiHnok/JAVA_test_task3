package com.figures_pack.entities;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class PointTest {

	Point point;
	
	@Before
	public void setUp() {
		point = new Point(3.1234567, 765432.1);
	}
	
	@Test
	public void tesToString() {
		Assert.assertEquals(point.toString(), "Point [x=3.123; y=765432.100]");
	}
}
