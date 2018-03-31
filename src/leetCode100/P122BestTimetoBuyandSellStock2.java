package leetCode100;

public class P122BestTimetoBuyandSellStock2 {
    public int maxProfit(int[] prices) {
        int maxprofit=0;
        boolean buy = true;
        int smallest=Integer.MAX_VALUE;
        int biggest = Integer.MIN_VALUE;
        for(int i =0;i<prices.length;i++){
        	if(buy){
        		if(prices[i]<smallest)smallest=prices[i];
        		else {buy = false;
        		i--;
        		}
        	}else if(!buy){
        		if(prices[i]>biggest)biggest = prices[i];
        		else {
        		maxprofit = biggest-smallest+maxprofit;
                smallest=Integer.MAX_VALUE;
                biggest = Integer.MIN_VALUE;
        		buy=true;
        		i--;
        		}
        	}
        }
        
        
      //  if(maxprofit==null)return 0;
        if(biggest!=Integer.MIN_VALUE)maxprofit = biggest-smallest+maxprofit;
    	return maxprofit;
    }
    
    public static void main(String[] args) {
    	System.out.println();
	}
}
