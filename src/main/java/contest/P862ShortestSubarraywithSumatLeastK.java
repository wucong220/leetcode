package contest;

import java.util.ArrayDeque;
import java.util.Deque;

public class P862ShortestSubarraywithSumatLeastK {
	// 方案1：使用头尾两个指针来确定SubArray范围：这个方法是行不通的，因为数组中既有正数又有负数。
	// 方案2：以一点往两边扩张:Time Limit Exceed
	// 方案3：遍历所有长度可能结果:Time Limit Exceed;

	// Plan 2:
	public int shortestSubarray2(int[] A, int K) {

		int middleA = 0;
		int middleB = 0;
		int head = 0;
		int tail = 0;
		int min = Integer.MAX_VALUE;

		while (middleA < A.length && middleB < A.length) {

			head = middleA;
			tail = middleB;

			while (head >= 0 && tail < A.length) {
				int sum = 0;
				for (int i = head; i <= tail; i++) {
					sum += A[i];
				}
				if (sum >= K) {
					min = Math.min(tail - head + 1, min);
					break;
				}
				head--;
				tail++;
			}
			if (middleA == middleB) {
				middleB++;
			} else {
				middleA++;
			}

		}
		if (min == Integer.MAX_VALUE)
			return -1;
		return min;
	}

	// Plan 3
	public int shortestSubarray(int[] A, int K) {
		int head;
		int tail;
		int min = Integer.MAX_VALUE;
		for (int length = 1; length <= A.length; length++) {
			tail = 0;
			head = tail + length - 1;

			int sum = 0;
			for (int i = tail; i <= head; i++) {
				sum += A[i];
			}
			while (head < A.length) {
				if (sum >= K) {
					min = Math.min(length, min);
					break;
				}
				
				head++;
				if(head<A.length)
				sum+=A[head];
				if(tail<A.length)
				sum-=A[tail];
				tail++;
			}
		}
		if(min == Integer.MAX_VALUE)return -1;
		return min;
	}
	//https://leetcode.com/problems/shortest-subarray-with-sum-at-least-k/discuss/143726/C++JavaPython-O(N)-Using-Deque
    public int shortestSubarray666(int[] A, int K) {
        int N = A.length, res = N + 1;
        int[] B = new int[N + 1];
        for (int i = 0; i < N; i++) B[i + 1] += B[i] + A[i]; //	构造前缀和数组
        Deque<Integer> d = new ArrayDeque<>();
        for (int i = 0; i < N + 1; i++) {
            while (d.size() > 0 && B[d.getFirst()] <= B[i] - K)
                res = Math.min(res, i - d.pollFirst());
            while (d.size() > 0 && B[i] <= B[d.getLast()]) d.pollLast();
            d.addLast(i);
        }
        return res <= N ? res : -1;
    }
    
	public static void main(String[] args) {
		int[] A = {84,-37,32,40,95
				
				 };
		int K = 167;
		int ret = new P862ShortestSubarraywithSumatLeastK().shortestSubarray666(A, K);
		System.out.println(ret);
	}
}
