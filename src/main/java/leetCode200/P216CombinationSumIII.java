package leetCode200;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class P216CombinationSumIII {
    public List<List<Integer>> combinationSum3(int k, int n) {
    	List<List<Integer>> ret = new ArrayList<>();
    	if(n<(1+k)*k/2||n>(9+(9-k+1))*k/2)return ret;
    	List<Integer> l = new ArrayList<>();
    	for(int i=1;i<=k;i++){
    		l.add(i);
    	}
    	ret.add(l);
    	for(int i=(1+k)*k/2+1;i<=n;i++){
    		List<List<Integer>> templli = new ArrayList<>();
    		for(List<Integer> li:ret){
    			for(int j=li.size()-1;j>=0;j--){
    				if(li.get(j)==9)continue;
    				else if(j==li.size()-1){
    					List<Integer> templi= new ArrayList<>(li);
    					templi.set(j,templi.get(j)+1);
    					templli.add(templi);
    				}
    				else{
    					if(li.get(j)+1<li.get(j+1)){
        					List<Integer> templi= new ArrayList<>(li);
        					templi.set(j,templi.get(j)+1);
        					templli.add(templi);
    					}
    				}
    			}
    		}
    		ret = templli;
    	}
    	return new ArrayList<>(new HashSet<>(ret));
    }
    public static void main(String[] args) {
		System.out.println(new P216CombinationSumIII().combinationSum3(3, 4));
	}
}
