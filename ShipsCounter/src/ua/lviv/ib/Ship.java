package ua.lviv.ib;

import java.util.List;
import java.util.Set;
import java.util.TreeSet;

public class Ship {

	Set<Point> points;

	public Ship() {
		super();
		points = new TreeSet<>();
	}

	public boolean add(int x, int y) {
		return points.add(new Point(x, y));
	}

	public boolean isInclude(int x, int y) {
		return points.contains(new Point(x, y));
	}

	static boolean isInclude(List<Ship> ships, int x, int y) {
		if (ships.isEmpty())
			return false;
		for (Ship ship : ships) {
			if (ship.isInclude(x, y))
				return true;
		}
		return false;
	}
}
