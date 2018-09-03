package leetCode200;

import java.util.HashSet;

public class P202HappyNumber {
	public boolean isHappy(int n) {
		HashSet<Integer> visited = new HashSet<>();
		while (true) {
			if (visited.add(n)) {
				if ((n = getSumOfSquaresOfDigits(n)) == 1)
					return true;
			}
			else
				return false;
		}
	}

	int getSumOfSquaresOfDigits(int n) {
		int ret = 0;
		for (; n > 0;) {
			ret += (n % 10) * (n % 10);
			n = n / 10;
		}
		return ret;
	}

	public static void main(String[] args) {
		System.out.println(new P202HappyNumber().getSumOfSquaresOfDigits(91));
	}
}
