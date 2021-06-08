package leetCode200;

public class P201BitwiseANDofNumbersRange {
	public int rangeBitwiseAnd(int m, int n) {
		int ret = Integer.MAX_VALUE;
		int hm = 0;
		int hn = 0;
		for (int i = 30; i >= 0; i--) {
			if (((m >>> i) & 1) == 1) {
				hm = i;
				break;
			}
		}
		for (int i = 30; i >= 0; i--) {
			if (((n >>> i) & 1) == 1) {
				hn = i;
				break;
			}
		}
		if (hm < hn)
			return 0;
		for (long i = m; i <= n; i++) {
			ret &= i;
			if (ret == 0)
				return 0;
		}
		return ret;
	}

	public static void main(String[] args) {
		new P201BitwiseANDofNumbersRange().rangeBitwiseAnd(70000000, 2147483647);
	}
}
