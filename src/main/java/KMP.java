import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

public class KMP {

    public List<Integer> kmp(char[] input,char[] pattern){
        List<Integer> ret = new ArrayList<>();
        int[] next = getNext(pattern);
        for (int i=0,j=0;i<input.length;i++){
            while(j>0 && pattern[j]!=input[j]){
                j = next[j];
            }
            if(pattern[j]==input[j]){
                j++;
            }
            if(j==pattern.length){
                ret.add(i-pattern.length+1);
                j=next[j];
            }
        }
        return ret;
    }

    private int[] getNext(char[] pattern) {
        int[] next = new int[pattern.length+1];
        next[0]=0;
        next[1]=0;
        for(int i=1,j=0;i<pattern.length;i++){
            while (j>0&&pattern[j]!=pattern[i]){
                j=next[j];
            }
            if(pattern[j]==pattern[i]){
                j++;
            }
            next[i] = j;
        }
        return next;
    }

    public static void main(String[] args) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
    }
}
