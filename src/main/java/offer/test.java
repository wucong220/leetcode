package offer;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import DataStructure.TreeNode;
/**
public class TreeNode {
    int val = 0;
    TreeNode left = null;
    TreeNode right = null;

    public TreeNode(int val) {
        this.val = val;

    }

}
*/
public class test {
	
	//找节点路径为给定值的序列的个数
    static public ArrayList<ArrayList<Integer>> FindPath(TreeNode root,int target) {
        ArrayList<ArrayList<Integer>> ret = new ArrayList<>();
        List<Integer> path = new ArrayList<>();
        dfs(root,ret,path,target);
        Collections.sort(ret,(a,b)->b.size()-a.size());
        return ret;
    }
    
    static public void dfs(TreeNode root,ArrayList<ArrayList<Integer>> ret,List<Integer> path,int target ){
        if(root==null){
        	return;
        }
    	if(root.val == target&&root.left==null&&root.right==null){
            path.add(root.val);
            ret.add(new ArrayList<Integer>(path));
            path.remove(path.size()-1);
        }
        else if(root.val<target){
            path.add(root.val);
            target = target-root.val;
            dfs(root.left,ret,path,target);
            dfs(root.right,ret,path,target);
            path.remove(path.size()-1);
        }
    }
    
    public static void main(String[] args) {
    	boolean flag = VerifySquenceOfBST(new int[]{5,4,3,2,1});
    	System.out.println(flag);
	}
    
    //后序序列验证是否搜索树
    static public boolean VerifySquenceOfBST(int [] sequence) {
    	if(sequence.length==0)return false;
    	return VerifySquenceOfBST(sequence,0,sequence.length-1);
    }
    
    static public boolean VerifySquenceOfBST(int [] sequence,int start,int end) {
        if(end<=start)return true;
        int root = sequence[end];
        boolean flag = false;
        int rroot =end-1;
        int lroot = -1;
        //找左子树根节点
        for(int i=end-1;i>=start;i--){
            if(sequence[i]<root){
                lroot=i;
                //校验左子树，如果左子树中有大于根节点的元素返回false；
                for(int j=lroot;j>=start;j--){
                    if(sequence[j]>root){
                        return false;
                    }
                }
                flag=flag || VerifySquenceOfBST(sequence,0,lroot);
                
                break;
            }
        }
        flag= flag||VerifySquenceOfBST(sequence,lroot+1,rroot);
        return flag;
    }
}