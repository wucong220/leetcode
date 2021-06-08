package contest;

import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.Map.Entry;
import java.util.TreeMap;

public class P855ExamRoom {
	public static void main(String[] args) {
		ExamRoom er = new ExamRoom(4);
		System.out.println(er.seat());
		System.out.println(er.seat());
		System.out.println(er.seat());
		System.out.println(er.seat());
		er.leave(1);
		er.leave(3);
		System.out.println(er.seat());
	}
}

class ExamRoom {
	LinkedList<Space> Spaces;
	TreeMap<Integer, Student> students;
	int N = 0;
	int count = 0;
	Comparator<Space> comp = Comparator.comparing(Space::getSpace).reversed().thenComparing(Space::getLow);

	public ExamRoom(int N) {
		Spaces = new LinkedList<Space>();
		students = new TreeMap<>();
		this.N = N;
		Spaces.add(new Space(0, N - 1));
	}

	public int seat() {
		Space spa = Spaces.removeFirst();
		Space leftSpa = new Space(spa.low, spa.middle - 1);
		Space rightSpa = new Space(spa.middle + 1, spa.high);
		Spaces.add(leftSpa);
		Spaces.add(rightSpa);
		Collections.sort(Spaces, comp);
		students.put(spa.middle, new Student(spa.middle, leftSpa, rightSpa));
		if (count > 0) {
			Entry<Integer, Student> higher_stu = students.higherEntry(spa.middle);
			if (higher_stu != null) {
				higher_stu.getValue().leftSpace = rightSpa;
			}

			Entry<Integer, Student> lower_stu = students.lowerEntry(spa.middle);
			if (lower_stu != null) {
				lower_stu.getValue().rightSpace = leftSpa;
			}
		}
		count++;
		return spa.middle;

	}

	public void leave(int p) {
		Student stu = students.remove(p);
		Space spa = new Space(stu.leftSpace.low, stu.rightSpace.high);
		Spaces.remove(stu.leftSpace);
		Spaces.remove(stu.rightSpace);
		Spaces.add(spa);
		Collections.sort(Spaces, comp);
		if (count > 1) {
			Entry<Integer, Student> higher_stu = students.higherEntry(spa.middle);
			if (higher_stu != null) {
				higher_stu.getValue().leftSpace = spa;
			}

			Entry<Integer, Student> lower_stu = students.lowerEntry(spa.middle);
			if (lower_stu != null) {
				lower_stu.getValue().rightSpace = spa;
			}
		}
		count--;
	}

	class Space {
		int low;
		int high;
		int middle;
		int space;

		public Space(int low, int high) {
			super();
			this.low = low;
			this.high = high;

			if ((low == 0 && high >= 0) || (high == N - 1 && low <= N - 1)) {
				this.space = high - low;
				if (low == 0)
					this.middle = low;
				else
					this.middle = high;
			} else {
				this.middle = low + (high - low) / 2;
				this.space = Math.min(high - middle, middle - low);

			}
		}

		public int getSpace() {
			return space;
		}

		public int getLow() {
			return low;
		}

		public void setSpace(int space) {
			this.space = space;
		}

		@Override
		public String toString() {
			return "Space [low=" + low + ", high=" + high + ", middle=" + middle + ", space=" + space + "]";
		}

	}

	class Student {
		int seat;
		Space leftSpace;
		Space rightSpace;

		public Student(int seat, Space leftSpace, Space rightSpace) {
			super();
			this.seat = seat;
			this.leftSpace = leftSpace;
			this.rightSpace = rightSpace;
		}
	}
}
/**
 * Your ExamRoom object will be instantiated and called as such: ExamRoom obj =
 * new ExamRoom(N); int param_1 = obj.seat(); obj.leave(p);
 */