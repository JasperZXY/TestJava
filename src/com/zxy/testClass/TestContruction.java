package com.zxy.testClass;

public class TestContruction {
	static class Shape {
		public Shape() {
			System.out.println("before draw");
			draw();
			System.out.println("after draw");
		}
		public void draw() {
			System.out.println("Shape draw");
		}
	}
	static class Circle extends Shape {
		private int radius = 1;
		public Circle(int radius) {
			this.radius = radius;
			System.out.println("radius = " + radius);
		}
		@Override
		public void draw() {
			System.out.println("circle draw,radius=" + radius);
		}
	}
	public static void main(String[] args) {
		Shape shape = new Circle(12);
		shape.draw();
	}

}
