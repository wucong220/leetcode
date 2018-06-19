package leetCode100;

import java.util.Arrays;

public class P188BestTimetoBuyandSellStockIV {
	static public int maxProfit(int k, int[] prices) {
		int[] buys = new int[k];
		int[] sells = new int[k];
		int[] old_buys = new int[k];
		int[] old_sells = new int[k];
		Arrays.fill(old_buys, Integer.MIN_VALUE);
		Arrays.fill(old_sells, Integer.MIN_VALUE);
		Arrays.fill(buys, Integer.MIN_VALUE);
		Arrays.fill(sells, Integer.MIN_VALUE);
		for (int j = 0; j < prices.length; j++) {
			int price = prices[j];
			for (int i = 0; i < 2*k&&i<=j; i++) {
				if(i==0){old_buys[0]=buys[0];buys[0] = Math.max(-price,buys[0]);}
				else if(i==1){old_sells[0]=sells[0];sells[0] = Math.max(sells[0],price+old_buys[0]);}
				else if(i%2==0){old_buys[i/2]=buys[i/2];buys[i/2]=Math.max(buys[i/2], old_sells[i/2-1]-price);}
				else {old_sells[i/2]=sells[i/2];sells[i/2] = Math.max(sells[i/2], old_buys[i/2]+price);}
			}
			System.out.println(Arrays.toString(buys)+Arrays.toString(sells));
		}
		int max=0;
		for(int i=0;i<k;i++){
			max=Math.max(sells[i],max);
		}
		return max;
	}

	public static void main(String[] args) {
		System.out.println(maxProfit(2, new int[] { 3, 2, 6, 5, 0, 3 }));
	}
}
