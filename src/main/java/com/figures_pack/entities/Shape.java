package com.figures_pack.entities;

import java.util.List;

public class Shape {

	private int id;
	protected List<Point> points;

	public Shape() {
	}

	public Shape(int id) {
		this.id = id;
	}

	public Shape(int id, List<Point> points) {
		this.id = id;
		this.points = points;
	}

	public int getId(){
		return id;
	}

	public List<Point> getPoints() {
		return points;
	}
}
