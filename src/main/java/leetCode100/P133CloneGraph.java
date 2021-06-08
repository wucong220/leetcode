package leetCode100;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

import DataStructure.UndirectedGraphNode;

public class P133CloneGraph {
    public UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {
    	Queue<UndirectedGraphNode> q = new LinkedList<>();
    	Queue<UndirectedGraphNode> q_clone = new LinkedList<>();
    	Map<Integer,UndirectedGraphNode> node_set = new HashMap<>();
    	UndirectedGraphNode clone = new UndirectedGraphNode(node.label);
    	q_clone.offer(clone);
    	node_set.put(clone.label,clone);
    	q.offer(node);
    	while(!q.isEmpty()){
    		UndirectedGraphNode curr = q.poll();
    		UndirectedGraphNode curr_clone = q_clone.poll();
    		curr_clone.neighbors = new ArrayList<>();
    		for(UndirectedGraphNode neighbor:curr.neighbors){
    			UndirectedGraphNode neighbor_clone;
    			if(!node_set.containsKey(neighbor.label)){
    				neighbor_clone = new UndirectedGraphNode(neighbor.label); 
    				node_set.put(neighbor.label,neighbor_clone);
    				q.offer(neighbor);
    				q_clone.offer(neighbor_clone);
    			}else{
    				neighbor_clone = node_set.get(neighbor.label); 
    			}
    			curr_clone.neighbors.add(neighbor_clone);
    		}
    	}
    	
    	return clone;
    }
}
