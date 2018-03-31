package leetCode100;

import java.util.ArrayList;
import java.util.List;

public class P119PascalsTriangle2 {
    public List<Integer> getRow(int rowIndex) {
        List<Integer>  temp = new ArrayList<>();
        temp.add(1);
        for(int i=0;i<rowIndex+1;i++){
            List<Integer> l = new ArrayList<>();
            for(int j=0;j<i+1;j++){
          //  	System.out.println(j);
                if(j==i||j==0){
                    l.add(1);
                }
                else
                    l.add(temp.get(j)+temp.get(j-1));
            }
            temp=l;
        }
        return temp;        
    }
}
