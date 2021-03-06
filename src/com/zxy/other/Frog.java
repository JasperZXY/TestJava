package com.zxy.other;

class DoBaseFinalization {
	public static boolean flag = false;
}

class Characteristic {
	String s;

	Characteristic(String c) {
		s = c;
		System.out.println("Creating Characteristic " + s);
	}

	@Override
	protected void finalize() {
		System.out.println("finalizing Characteristic " + s);
	}
}

class LivingCreature {
	Characteristic p = new Characteristic("is alive");

	LivingCreature() {
		System.out.println("LivingCreature()");
	}

	@Override
	protected void finalize() {
		System.out.println("LivingCreature finalize");
		// Call base-class version LAST!
		if (DoBaseFinalization.flag)
			try {
				super.finalize();
			} catch (Throwable t) {
			}
	}
}

class Animal extends LivingCreature {
	Characteristic p = new Characteristic("has heart");

	Animal() {
		System.out.println("Animal()");
	}

	@Override
	protected void finalize() {
		System.out.println("Animal finalize");
		if (DoBaseFinalization.flag)
			try {
				super.finalize();
			} catch (Throwable t) {
			}
	}
}

class Amphibian extends Animal {
	Characteristic p = new Characteristic("can live in water");

	Amphibian() {
		System.out.println("Amphibian()");
	}

	@Override
	protected void finalize() {
		System.out.println("Amphibian finalize");
		if (DoBaseFinalization.flag)
			try {
				super.finalize();
			} catch (Throwable t) {
			}
	}
}

public class Frog extends Amphibian {
	Frog() {
		System.out.println("Frog()");
	}

	@Override
	protected void finalize() {
		System.out.println("Frog finalize");
		if (DoBaseFinalization.flag)
			try {
				super.finalize();
			} catch (Throwable t) {
			}
	}

	public static void main(String[] args) {
		DoBaseFinalization.flag = true;
//		if (args.length != 0 && args[0].equals("finalize"))
//		else
//			System.out.println("not finalizing bases");
		new Frog(); // Instantly becomes garbage
		System.out.println("bye!");
		// Must do this to guarantee that all
		// finalizers will be called:
		System.runFinalizersOnExit(true);
	}
} // /:~

