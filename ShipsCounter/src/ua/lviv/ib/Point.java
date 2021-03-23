package ua.lviv.ib;


public class Point implements Comparable<Point>{
	private int x;
	private int y;

	public Point(int x, int y) {
		super();
		this.x = x;
		this.y = y;
	}

	@Override
	public int compareTo(Point o) {
		int res = Integer.compare(this.x, o.x);
		if (res == 0)
			res = Integer.compare(this.y, o.y);
		return res;
	}
}
