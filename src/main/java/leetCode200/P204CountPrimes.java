package leetCode200;

public class P204CountPrimes {

	public int countPrimes(int n) {
		byte[] flag = new byte[n / 8 + 1];
		int count = 0;
		n--;//小于n的素数
		for (int j = 2; j <= n; j++) {
			if ((flag[j / 8] & (1 << (j % 8))) == 0) {
				count++;
				for (int i = j; i <= n; i += j) {
					int by = i / 8;
					int offset = i % 8;
					flag[by] |= (1 << offset);
				}
			}
		}

		return count;
	}

	public static void main(String[] args) {
		System.out.println(new P204CountPrimes().countPrimes(8));
	}
}
