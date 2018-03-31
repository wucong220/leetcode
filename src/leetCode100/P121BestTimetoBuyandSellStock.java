package leetCode100;

public class P121BestTimetoBuyandSellStock {
    public int maxProfit(int[] prices) {
        Integer maxprofit=null;
        int smallest=Integer.MAX_VALUE;
        for(int i =0;i<prices.length;i++){
        		if(prices[i]<smallest){
        			smallest = prices[i];
        		}
        		else{
        			if(maxprofit==null){
        				maxprofit = prices[i]-smallest;
        			}
        			else
        			maxprofit = Math.max(prices[i]-smallest, maxprofit);
        		}
        }
        if(maxprofit==null)return 0;
    	return maxprofit;
    }
}
