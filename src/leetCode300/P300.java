package leetCode300;

public class P300 {
    public int lengthOfLIS(int[] nums) {
        if(nums.length==0)return 0;
        int[] d = new int[nums.length];
        
        for(int i=0;i<nums.length;i++){
            d[i]=1;
            for(int j=0;j<i;j++){
                if(nums[i]>nums[j]){
                    d[i] = Math.max(d[j]+1,d[i]);
                }
            }
        }
        int max = 0;
        for(int i=0;i<d.length;i++){
            max = Math.max(max,d[i]);
        }
        
        return max;
    }
    
    public int longestCommonSubsequence(String A, String B) {
        // write your code 
        if(A.length==0||B.length==0)return 0;
        int[][] d = new int[A.length][B.length];
        
        for(int i=0;i<A.length;i++){
            for(int j=0;j<B.length;j++){
                if(i==0&&j==0){d[i][j]=A.charAt(i)==B.charAt(j)?1:0;}
                else if(i==0){d[i][j]=A.charAt(i)==B.charAt(j)?1:d[i][j-1];}
                else if(j==0){d[i][j]=A.charAt(i)==B.charAt(j)?1:d[i-1][j];}
                else {
                    d[i][j]=A.charAt(i)==B.charAt(j)?d[i-1][j-1]+1:Math.max(d[i][j-1],d[i-1][j]);
                }
            }
        }
        return d[i][j];
    }
}
