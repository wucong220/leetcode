package leetCode;

import java.util.ArrayList;
import java.util.List;

public class P77Combinations {
	static     public List<List<Integer>> combine(int n, int k) {
		if(n<k){
			return null;
		}
		List<List<Integer>> ret=  new ArrayList<>();
		if(k==n){
			List<Integer> li = new ArrayList<>();
			for(int i=0;i<n;i++){
				li.add(i+1);
			}
			ret.add(li);
			return ret;
		}
		else if(k==1){
			for(int i=0;i<n;i++){
				List<Integer> li = new ArrayList<>();
				li.add(i+1);
				ret.add(li);
			}	
			return ret;
		}
		
		for(int i=n;i>1;i--){			
			List<List<Integer>> temp = combine(i-1,k-1);
			if(temp!=null){
				for (List<Integer> list : temp) {
					list.add(i);
					ret.add(list);
				}
			}
		}
		
		
		return ret;
    }
	public static void main(String[] args) {
		System.out.println(combine(4,2));
	}
}
