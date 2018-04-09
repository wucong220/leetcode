package leetCode100;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class P149MaxPointsOnALine {
	public static int maxPoints(Point[] points) {
		if (points.length <= 1)
			return points.length;
		Line max = null;
		HashMap<String, Line> lineMap = new HashMap<>();
		for (int i = 0; i < points.length; i++) {
			for (int j = i + 1; j < points.length; j++) {
				String key;
				double a =0;
				double b =0;
				if (points[j].x - points[i].x == 0) {
					key = new String("v" + points[j].x);
				} else {
					BigDecimal aa1 =new BigDecimal(points[j].y - points[i].y);
					BigDecimal aa2 =new BigDecimal(points[j].x - points[i].x);
					BigDecimal aa  =aa1.divide(aa2,10,BigDecimal.ROUND_HALF_DOWN);
					BigDecimal bb1 =new BigDecimal(points[j].x+points[i].x);
					BigDecimal bb2 = new BigDecimal(points[j].y+points[i].y);
					BigDecimal bb = bb2.subtract(aa.multiply(bb1)).divide(new BigDecimal(2),8,BigDecimal.ROUND_HALF_DOWN);
					
					key = new String(aa.toString() + ',' + bb.toString());
				}
				System.out.println(key);
				Line l;
				if (lineMap.containsKey(key)) {
					l = lineMap.get(key);	
					l.points.add(points[j]);
					l.points.add(points[i]);

				} else {
					l = new Line(0, 0);
					l.points = new HashSet<>();
					l.points.add(points[j]);
					l.points.add(points[i]);
					lineMap.put(key, l);
				}
                if(max==null)max=l;
				max = max.points.size()>l.points.size()?max:l;
			}
		}
        Iterator<Point> iterator = max.points.iterator();
        while(iterator.hasNext()){
        	Point p = iterator.next();
        	System.out.println(p.x+","+p.y);
        }
        
		return max.points.size();
	}

	public static void main(String[] args) {
		Point[] fuck = new Point[] { new Point(3, 1), new Point(12, 3),new Point(3,1),new Point(-6,-1) };
		System.out.println(maxPoints(fuck));
	}
}

class Point {
	int x;
	int y;

	Point() {
		x = 0;
		y = 0;
	}

	Point(int a, int b) {
		x = a;
		y = b;
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "(" + x + "," + y + ")";
	}
}

class Line {
	double a;
	double b;
	Set<Point> points;

	Line(double a2, double b2) {
		this.a = a2;
		this.b = b2;
	}

	boolean onLine(int x, int y) {
		if (a * x + b == y)
			return true;
		else
			return false;
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "[a=" + a + "," + "b=" + b + "]";
	}
}