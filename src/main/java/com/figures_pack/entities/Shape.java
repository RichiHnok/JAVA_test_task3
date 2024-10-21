package com.figures_pack.entities;

import java.util.List;

public class Shape {

	protected int id;
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

	@Override
	public boolean equals(Object obj) {
		// TODO Auto-generated method stub
		return super.equals(obj);
	}

	@Override
	public int hashCode() {
		// TODO Auto-generated method stub
		return super.hashCode();
	}

	@Override
	public String toString() {
		return "Shape [id=" + id + ", points=" + points + "]";
	}
}
