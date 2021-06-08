package contest;

import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Queue;

public class P857MinimumCosttoHireKWorkers {
	 class Node{
	        int q; // quality
	        double rate; // wage/quality
	        
	        public Node(int quality,int wage){
	            q = quality;
	            rate = wage/(double)quality;
	        }
	    }
	    
	    public double mincostToHireWorkers(int[] quality, int[] wage, int K) {
	        
	        //corner case
	        if(quality.length==1) return wage[0]; //length == 1 
	        
	        Node[] arr = new Node[quality.length];
	        
	        for(int i=0;i<arr.length;i++){
	            arr[i] = new Node(quality[i],wage[i]);
	        }
	        
	        Arrays.sort(arr,(a,b)->{       //O(n logn) 将工资率最低的放在前面，工资率相同就资质最差。
	            if(a.rate==b.rate){
	                return a.q - b.q;
	            }else{
	                
	                if(a.rate<b.rate){
	                    return -1; 
	                }else if(a.rate>b.rate){
	                    return 1;
	                }else{
	                    return 0;
	                }
	            }
	        });
	        
	        Queue<Integer> pq = new PriorityQueue<Integer>(K,(a,b)->b-a); //大顶堆？
	        
	        int q_sum = 0;
	        
	        double min = Double.MAX_VALUE;
	        
	        for(int i=0;i<arr.length;i++){  // O(n logk)
	            
	            if(pq.size()==K){
	                q_sum-=pq.poll();     //O(log k)	在q堆中取一个最大的q出来给q_sum剪掉
	            }
	            pq.offer(arr[i].q);     //O(log k)  把这个人的q加入q堆，并给q_sum+
	            q_sum+=arr[i].q;			
	            
	            if(i>=K-1){
	                //update the min
	                min = Math.min(min,q_sum*arr[i].rate);
	            }
	        }
	        
	        return min;
	        
	    }

}
