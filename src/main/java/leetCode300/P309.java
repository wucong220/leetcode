package leetCode300;

import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Queue;

public class P309 {
	public int maxProfit(int[] prices) {
		Queue<int[]> buyQ = new PriorityQueue<>((a, b) -> b[1] - a[1]);
		Queue<int[]> sellQ = new PriorityQueue<>((a, b) -> b[1] - a[1]);

		for (int i = 0; i < prices.length; i++) {
			if (i == 0) {
				buyQ.offer(new int[] { i, -prices[i] });
				sellQ.offer(new int[] { i, 0 });
			} else {
				int[] temp = sellQ.peek(), currBuy;
				System.out.print(Arrays.toString(temp)+" ");
				if (temp[0] != i - 1) {
					currBuy = new int[] { i, temp[1]>0?temp[1] - prices[i]:-prices[i] };
				} else {
					if(i>1){
						sellQ.poll();
						System.out.print(Arrays.toString(sellQ.peek()));
						currBuy = new int[] { i, sellQ.peek()[1]>0?sellQ.peek()[1] - prices[i]:-prices[i] };
						sellQ.offer(temp);
					}
					else
					currBuy = new int[] { i, -prices[i] };
				}

				sellQ.offer(new int[] { i, buyQ.peek()[1] + prices[i]});
				System.out.print(Arrays.toString(currBuy)+" ");
				buyQ.offer(currBuy);
				System.out.print(sellQ.peek()[1]+":");
				System.out.println(buyQ.peek()[1]);
							
			}
		}

		return sellQ.peek()[1];
	}

	public static void main(String[] args) {
		System.out.println(new P309().maxProfit(new int[] { 1, 2, 3, 0, 2 }));
		Queue<Integer> q = new PriorityQueue<>((a,b)->b-a);
		q.offer(1);
		q.offer(2);
		System.out.println(q);
	}
}
