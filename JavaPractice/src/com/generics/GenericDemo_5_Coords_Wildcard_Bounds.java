package com.generics;

public class GenericDemo_5_Coords_Wildcard_Bounds {

	public static void main(String[] args) {
		// problem : creating methods for showing 3d and 2d coords
		// without upper bounds showXYZ can even take even 2d coords which will not
		// have any z coord in them
		//solution : using boudned wildcards in all methods to restrict the minimum upper bound for parameters

		TwoD[] twoDcoords = {
				new TwoD(1, 2),
				new TwoD(5, 2),
				new TwoD(3, -1),
				new TwoD(1, 0)
		};

		Coords<TwoD> twoDCoords = new Coords<>(twoDcoords);
		showXY(twoDCoords);
		// showXYZ(twoDCoords);//mthod not applicable for type ? extends TwoD since it
		// only allows ? extends Three
		// showAll(twoDCoords);//mthod not applicable for type ? extends TwoD since it
		// only allows ? extends FourD

		FourD[] fourDcoords = {
				new FourD(0, 1, 90, 0),
				new FourD(10, 1, 2, 80),
				new FourD(0, 13, -2, 89)
		};

		Coords<FourD> fourDCoords = new Coords<>(fourDcoords);
		showXY(fourDCoords);
		showXYZ(fourDCoords);
		showAll(fourDCoords);
	}

	public static void showXY(Coords<?> c) {
		System.out.println("X Y coordinates");
		for (int i = 0; i < c.coords.length; i++) {
			System.out.println(c.coords[i].x + " " + c.coords[i].y);
		}
	}

	public static void showXYZ(Coords<? extends ThreeD> c) {
		System.out.println("X Y Z coordinates");
		for (int i = 0; i < c.coords.length; i++) {
			System.out.println(c.coords[i].x + " " + c.coords[i].y + " " + c.coords[i].z);
		}
	}

	public static void showAll(Coords<? extends FourD> c) {
		System.out.println("X Y Z T coordinates");
		for (int i = 0; i < c.coords.length; i++) {
			System.out.println(c.coords[i].x + " " + c.coords[i].y + " " + c.coords[i].z + " " + c.coords[i].t);
		}
	}

}

class Coords<T extends TwoD> {
	T[] coords;

	public Coords(T[] coords) {
		super();
		this.coords = coords;
	}

}

class TwoD {
	int x, y;

	public TwoD(int x, int y) {
		super();
		this.x = x;
		this.y = y;
	}
}

class ThreeD extends TwoD {
	int z;

	public ThreeD(int x, int y, int z) {
		super(x, y);
		this.z = z;
	}
}

class FourD extends ThreeD {

	int t;

	public FourD(int x, int y, int z, int t) {
		super(x, y, z);
		this.t = t;
	}

}
