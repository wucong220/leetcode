package contest;

public class P904 {
	
	public static void main(String[] args) {
		System.out.println(totalFruit(new int[]{1,0,3,4,3}));
	}
    static public int totalFruit(int[] tree) {
        int first=-1;
        int fctr=0;
        int second =-1;
        int sctr=0;
        int max = Integer.MIN_VALUE;
        for(int i=0;i<tree.length;i++){
            if(first==-1){
                first=i;
                fctr++;
            }
            else if(tree[first]==tree[i]){
                fctr++;
            }
            else if(second==-1){
                second=i;
                sctr++;
            }
            else if(tree[second]==tree[i]){
            	sctr++;
            }
            else if(tree[i]!=tree[first]&&tree[i]!=tree[second]){
                max = Math.max(i-first,max);
                int j=first;
                for(;fctr>0&&sctr>0;j++){
                	if(tree[first]==tree[j]){
                		fctr--;
                	}
                	else if(tree[second]==tree[j]){
                		sctr--;
                	}
                }
                first=j;
                fctr=sctr;
                second = i;
                sctr=1;
            }
        }
         max = Math.max(tree.length-first,max);
         return max;
    }
	
}
