package leetCode100;

import java.util.ArrayList;
import java.util.List;

public class P118PascalsTriangle {
    static     public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> ret = new ArrayList<>();
        List<Integer>  temp = new ArrayList<>();
        temp.add(1);
        for(int i=0;i<numRows;i++){
            List<Integer> l = new ArrayList<>();
            for(int j=0;j<i+1;j++){
         //   	System.out.println(j);
                if(j==i||j==0){
                    l.add(1);
                }
                else
                    l.add(temp.get(j)+temp.get(j-1));
            }
            ret.add(l);
            temp=l;
       //     System.out.println(ret);
        }
        return ret;        
    }
    
    public static void main(String[] args) {
		System.out.println(generate(3));
	}
}
