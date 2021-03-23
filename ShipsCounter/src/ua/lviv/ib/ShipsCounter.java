package ua.lviv.ib;

import java.util.ArrayList;
import java.util.List;

public class ShipsCounter {
	
	
	static int[][] ships = {
			{0,0,0,0,0,0,0,1,0,0},
			{0,1,0,0,0,0,0,1,0,0},
			{0,1,0,1,1,0,0,0,0,0},
			{0,1,0,1,1,0,0,1,1,1},
			{0,1,0,0,0,0,0,0,0,0},
			{0,0,0,0,0,0,0,0,0,0},
			{1,1,1,1,0,1,0,0,0,0},
			{0,0,0,0,0,0,0,0,0,0},
			{1,1,0,0,0,0,0,1,0,0},
			{1,1,0,0,0,0,0,0,0,1}
			
	};

	public static void main(String[] args) {

		List<Ship> listofships = new ArrayList<>();
		for (int i = 0; i < ships.length; i++)
			for (int j = 0; j < 10; j++) {
				if (ships[i][j] == 0)
					continue;

				boolean isInclude = Ship.isInclude(listofships, i, j);// check point on ships
				if (isInclude)
					continue;
				Ship ship = new Ship();
				listofships.add(ship);

				ship.add(i, j);
				append(ship, i, j);
			}

		System.out.println(listofships.size());
	}

	static void append(Ship ship, int x, int y) {
		int y_1 = y - 1;
		int y1 = y + 1;
		int x1 = x + 1;
		int l = y_1 > 0 ? ships[x][y_1] : 0;
		int r = y1 < ships[x].length ? ships[x][y1] : 0;
		int b = x1 < ships.length ? ships[x1][y] : 0;

		if (l == 1) {
			if (ship.add(x, y_1))
				append(ship, x, y_1);
		}
		if (r == 1) {
			if (ship.add(x, y1))
				append(ship, x, y1);
		}
		if (b == 1) {
			if (ship.add(x1, y))
				append(ship, x1, y);
		}
	}
}
