package leetCode200;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class P218TheSkylineProblem {
	//这道题，我第一眼就感觉要用扫描线来解
	
	
	private int[] unique(int[] array){
		List<Integer> l = new ArrayList<>();
		for(int i=0;i<array.length;i++){
			if(i>0&&array[i]==array[i-1])continue;
			l.add(array[i]);
		}
		int[] ret = new int[l.size()];
		for(int i=0;i<l.size();i++){
			ret[i] = l.get(i);
		}
		return ret;
	}
	
    public List<int[]> getSkyline(int[][] buildings) {
    	int[] hash = new int[buildings.length*2];//离散表
    	int[][] sides = new int[buildings.length+1][3];
    	for(int i=0;i<buildings.length;i++){
    		hash[i*2] = buildings[i][0];
    		hash[i*2+1] = buildings[i][1];
    		sides[i][0]=buildings[i][0];
    		sides[i][1]=buildings[i][1];
    		sides[i][2]=buildings[i][2];
    	}
    	Arrays.sort(hash);
    	hash = unique(hash);
    	int[] flag = new int[hash.length-1];
    	
    	Map<Integer,Integer> map = new HashMap<>();
    	for(int i=0;i<hash.length;i++){
    		map.put(hash[i], i);
    	}
    	
    	
    	sides[buildings.length][0]=hash[0];
    	sides[buildings.length][1]=hash[hash.length-1];
    	sides[buildings.length][2]=0;
    	Arrays.sort(sides,(a,b)->b[2]-a[2 ]);
    	for(int i=0;i<sides.length;i++){
    		int left=map.get(sides[i][0]);
    		int right=map.get(sides[i][1])-1;
    		for(int j=left;j<=right;j++){
    			if(flag[j]==0){
    				flag[j]=sides[i][2];
    			}
    		}
    	}
    	List<int[]> l = new ArrayList<>();
    	for(int i=0;i<flag.length;i++){
    		if(i>0&&flag[i]==flag[i-1])continue;
    		l.add(new int[]{hash[i],flag[i]});
    	}
    	l.add(new int[]{hash[hash.length-1],0});

		return l;
    }
    
	public static void main(String[] args) {
		String s = "[ [2 9 10], [3 7 15], [5 12 12], [15 20 10], [19 24 8] ] ";
		s=s.replace('[', '{');
		s=s.replace(']', '}');
		System.out.println(s);
		System.out.println(new P218TheSkylineProblem().getSkyline(new int[][]{ {2,9,10}, {3,7,15}, {5,12,12}, {15,20,10}, {19,24,8} } 
));
	}
}


