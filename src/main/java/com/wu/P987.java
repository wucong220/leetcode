package main.java.com.wu;

import java.lang.reflect.Array;
import java.util.*;

/**
 * @author wuc006
 * @date 2019/12/6 17:15
 */
public class P987 {
    class Solution {
        public List<List<Integer>> verticalTraversal(TreeNode root) {
            List<List<Integer>> ret = new ArrayList<>();
            Map<String,List<Integer>> coodinate = new HashMap<>();
            traverce(root,coodinate,"1000,1000");
            for(int i=0;i<2000;i++){
                List<Integer> arrayList = new ArrayList<>();
                for(int j=1000;j>=0;j--){
                    if(coodinate.containsKey(i+","+j)){
                        arrayList.addAll(coodinate.get(i+","+j));
                    }
                }
                if(arrayList.size()>0) {
                    Collections.sort(arrayList);
                    ret.add(arrayList);
                }
            }
            return ret;
        }

        public void traverce(TreeNode node,Map<String,List<Integer>> coodinate,String cood){

            List<Integer> list = coodinate.getOrDefault(cood, new ArrayList<>());
            list.add(node.val);
            coodinate.put(cood,list);
            String[] xy = cood.split(",");
            int x = Integer.parseInt(xy[0]);
            int y = Integer.parseInt(xy[1]);
            if(node.left!=null){
                traverce(node.left,coodinate,(x-1)+","+(y-1));
            }
            if(node.right!=null){
                traverce(node.right,coodinate,(x+1)+","+(y-1));
            }
        }
    }
}
