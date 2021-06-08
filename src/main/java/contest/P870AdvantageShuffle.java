package contest;

import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class P870AdvantageShuffle {
    public int[] advantageCount(int[] A, int[] B) {
        int[] Bc = B.clone();
    	Arrays.sort(A);
        Arrays.sort(B);
        int count=0;
        for(int i=0,j=0;i<B.length&&j<A.length;){
        	if(A[j]>B[i]){count++;
        		swap(A,i,j);
        		i++;
        	}
        	else{
        		j++;
        	}
        }
        Map<Integer,List<Integer>> map = new HashMap<>();
        for(int i=0;i<A.length;i++){
        	map.putIfAbsent(B[i], new LinkedList<>());
        	map.get(B[i]).add(A[i]);
        }
        
        int[] ret = new int[A.length];
        for(int i=0;i<Bc.length;i++){
        	List<Integer> l=map.get(Bc[i]);
        	ret[i]=l.get(0);
        	l.remove(0);
        }
        
    	return ret;
    }
    
    private void swap(int[] array,int i,int j){
    	int temp = array[i];
    	array[i] = array[j];
    	array[j] = temp;
    }
    
    public static void main(String[] args) {
    	int[] A = {9,1,2,4,5};
    	int[] B = {6,2,9,1,4};
		System.out.println(Arrays.toString(new P870AdvantageShuffle().advantageCount(A, B)));
	}
}
