package leetCode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Stack;

public class P57InsertInterval {
	static public List<Interval> merge(List<Interval> intervals) {
        Stack<Interval> ret = new Stack<>();
        Collections.sort(intervals,new Comparator<Interval>(){

			@Override
			public int compare(Interval o1, Interval o2) {
				// TODO Auto-generated method stub
				if(o1.start<o2.start)
					return -1;
				else if((o1.start==o2.start))
					return 0;
				else
					return 1;
			}
        	
        });
    	for(int i =0 ; i<intervals.size();i++){
    		Interval interval =  intervals.get(i);
    		if(ret.empty()){ret.push(interval);continue;}
    		Interval old =  ret.peek();
    		if(old!=null){
    			if(old.end<interval.start){
    				ret.push(interval);
    			}
    			else if(old.end>=interval.start&&old.end<interval.end){
    				ret.pop();
    				ret.push(new Interval(old.start,interval.end));
    			}
    			else if(old.end>=interval.end){
    				
    			}

    		}
    	}
    	
    	List<Interval> Ret= new ArrayList<Interval>();
    	Ret.addAll(ret);
    	return  Ret;
    }
	
    static public List<Interval> insert(List<Interval> intervals, Interval newInterval) {
        intervals.add(newInterval);
    	return merge(intervals);
    }
}
