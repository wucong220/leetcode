package contest;

import java.util.ArrayList;
import java.util.List;

public class P901 {

}

class StockSpanner {
	List<Integer> list;
	List<Integer> save;
	
    public StockSpanner() {
    	list = new ArrayList<>();
    	save = new ArrayList<>();
    }
    
    public int next(int price) {
    	list.add(price);
    	save.add(1);
    	int count =0;
    	for(int i = list.size()-1;i>=0;){
    		if(list.get(i)<=price){
    			count+=save.get(i);
    			i-=save.get(i);
    		}
    		else break;
    	}
    	save.set(save.size()-1, count);
    	return count;
    }
}