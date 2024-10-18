package com.figures_pack.entities;

import java.util.List;

public class Rectangle implements Shape{

	private int id;

	private List<Point> points;

	public Rectangle(int id){
		this.id = id;
	}
	
	@Override
	public int getId() {
		return id;
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
		// TODO Auto-generated method stub
		return super.toString();
	}
	
}
