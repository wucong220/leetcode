package contest;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;

public class P871MinimumNumberofRefuelingStops_T {
	class State {
		int position;
		int gas;
		int refuel;

		/*
		 * (non-Javadoc)
		 * 
		 * @see java.lang.Object#hashCode()
		 */
		@Override
		public int hashCode() {
			final int prime = 31;
			int result = 1;
			result = prime * result + getOuterType().hashCode();
			result = prime * result + gas;
			result = prime * result + position;
			result = prime * result + refuel;
			return result;
		}

		/*
		 * (non-Javadoc)
		 * 
		 * @see java.lang.Object#equals(java.lang.Object)
		 */
		@Override
		public boolean equals(Object obj) {
			if (this == obj)
				return true;
			if (obj == null)
				return false;
			if (getClass() != obj.getClass())
				return false;
			State other = (State) obj;
			if (!getOuterType().equals(other.getOuterType()))
				return false;
			if (gas != other.gas)
				return false;
			if (position != other.position)
				return false;
			if (refuel != other.refuel)
				return false;
			return true;
		}

		private P871MinimumNumberofRefuelingStops getOuterType() {
			return P871MinimumNumberofRefuelingStops.this;
		}

		public State(int position, int gas, int ref) {
			super();
			this.position = position;
			this.gas = gas;
			this.refuel = ref;
		}

		/*
		 * (non-Javadoc)
		 * 
		 * @see java.lang.Object#toString()
		 */
		@Override
		public String toString() {
			return "State [position=" + position + ", gas=" + gas + ", refuel=" + refuel + "]";
		}

	}

	public int minRefuelStops(int target, int startFuel, int[][] stations) {
		Queue<State> q = new LinkedList<>();
		q.offer(new State(-1, startFuel, 0));
		HashSet<State> vis = new HashSet<>();
		int min = Integer.MAX_VALUE;
		while (!q.isEmpty()) {
			int qsize = q.size();
			for (int i = 0; i < qsize; i++) {
				State curr = q.poll();
				int pos = curr.position;
				int gas = curr.gas;
				int ref = curr.refuel;
				int dis = pos == -1 ? 0 : stations[pos][0];
				if (dis + gas >= target) {
					min = Math.min(ref, min);
					continue;
				}
				if (pos < stations.length - 1) {
					int con;
					State s;
					// ²»¼ÓÓÍ
					if (gas >= (con = stations[pos + 1][0] - dis)) {
						if (vis.add(s = new State(pos + 1, gas - con, ref)))
							q.offer(s);
					}
					// ¼ÓÓÍ
					if (pos != -1)
						if (gas >= (con = stations[pos + 1][0] - dis - stations[pos][1])) {
							if (vis.add(s = new State(pos + 1, gas - con, ref + 1)))
								q.offer(s);
						}
				} else {
					if (pos != -1)
						if (gas >= (target - dis - stations[pos][1])) {
							min = Math.min(min, ref + 1);
						}
				}
			}

		}
		if (min == Integer.MAX_VALUE)
			return -1;
		return min;
	}

	public static void main(String[] args) {
		System.out.println(new P871MinimumNumberofRefuelingStops().minRefuelStops(100, 1,
				new int[][] { /*
								 * { 10, 60 }, { 20, 30 }, { 30, 30 }, { 60, 40
								 * }
								 */ }));
	}
}
