package main.java.com.wu;

import java.util.Arrays;

/**
 * @author wuc006
 * @date 2019/12/6 11:41
 */
public class P985 {
    class Solution {
        public int[] sumEvenAfterQueries(int[] A, int[][] queries) {
            int[] ret = new int[queries.length];
            int sum = 0;
            for(int i=0;i<A.length;i++){
                if(A[i]%2==0){
                    sum+=A[i];
                }
            }
            for(int i=0;i<queries.length;i++){
                int[] query= queries[i];
                int index = query[1];
                int var = query[0];
                if((A[index]+var)%2==0){
                    if(A[index]%2==0){
                        sum+=var;
                    }
                    else{
                        sum+=A[index]+var;
                    }
                }
                else {
                    if (A[index] % 2 == 0) {
                        sum -= A[index];
                    } else {
                        sum += 0;
                    }
                }
                A[index]+=var;
                ret[i]=sum;
            }
            return ret;
        }
    }

    public static void main(String[] args) {
        int[] A = {1,2,3,4};
        int[][] queries = {{1,0},{-3,1},{-4,0},{2,3}};
        int[] ret = new P985().new Solution().sumEvenAfterQueries(A, queries);
        System.out.println(Arrays.toString(ret));
    }
}
