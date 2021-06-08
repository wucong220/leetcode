package array;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Set;

public class FindNumsAppearOnce {
    public void FindNumsAppearOnce(int [] array,int num1[] , int num2[]) {
        Map<Integer,Integer> map = new HashMap<>();
        for(int i=0;i<array.length;i++){
            map.merge(array[i],1,(a,b)->{
                if(a==1)return null;
                else return a+b;
            });
        }
        Iterator<Integer> it = map.keySet().iterator();
        num1[0] = it.next();
        num2[0] = it.next();
    }
    

    static public ArrayList<Integer> FindNumbersWithSum(int [] array,int sum) {
        Set<Integer> set = new HashSet<>();
        Queue<int[]> q = new PriorityQueue<>((a,b)->a[0]*a[1]-b[0]*b[1]);
        for(int i=0;i<array.length;i++){
            if(set.contains(sum-array[i])){
                q.add(new int[]{sum-array[i],array[i]});
            }
            else {
                set.add(array[i]);
            }
        }
        ArrayList<Integer> ret = new ArrayList<>();
        ret.add(q.peek()[0]);
        ret.add(q.peek()[1]);
        return ret;
    }
    
    public static void main(String[] args) {
		LastRemaining_Solution(5,3);
		//multiply(new int[]{1,2,3,4,5});
	}
    static public int LastRemaining_Solution(int n, int m) {
            List<Integer> list = new ArrayList<Integer>();
            for(int i=0;i<n;i++){
                list.add(i);
            }
            int start = 0;
            while(list.size()>1){
                int remove = (start + m-1)%list.size();
                list.remove(remove);
                start = remove%list.size();
            }
            return list.get(0);
        
    }
}
