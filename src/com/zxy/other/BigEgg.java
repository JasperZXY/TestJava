package com.zxy.other;

class Egg {
	protected class Yolk {
		public Yolk() {
			System.out.println("Egg.Yolk()");
		}
	}

	private Yolk y;

	public Egg() {
		System.out.println("New Egg()");
		y = new Yolk();
	}
}

public class BigEgg extends Egg {
	public class Yolk {
		public Yolk() {
			System.out.println("BigEgg.Yolk()");
		}
	}

	public static void main(String[] args) {
		new BigEgg();
	}
}
