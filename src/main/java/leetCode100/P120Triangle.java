package leetCode100;

import java.util.ArrayList;
import java.util.List;

public class P120Triangle {
    public int minimumTotal(List<List<Integer>> triangle) {
    	int min =Integer.MAX_VALUE;
    	List<Integer> temp = new ArrayList<>();
    	temp.add(0);
    	for(int i=0;i<triangle.size();i++){
    		List<Integer> list = triangle.get(i);
    		List<Integer> ntemp = new ArrayList<>();
    		for(int j = 0;j<list.size();j++){
    			if(j==0){
    				ntemp.add(list.get(j)+temp.get(0));
    			}else if(j==list.size()-1){
    				ntemp.add(list.get(j)+temp.get(j-1));
    			}else
    			{
    				ntemp.add(list.get(j)+Math.min(temp.get(j-1),temp.get(j)));
    			}
    		}
    		temp = ntemp;
    	}
    	for(int i= 0;i<temp.size();i++){
    		min = Math.min(temp.get(i),min);
    	}
    	return min;
    }
    
    //这道题，无非就是，将金字塔上层的元素加到金子塔下层；
}
