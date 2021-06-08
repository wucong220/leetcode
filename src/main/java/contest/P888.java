package contest;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class P888 {
    public String[] uncommonFromSentences(String A, String B) {
        String[] as  = A.split("\\s+");
        String[] bs = B.split("\\b+");
        List<String> ret = new ArrayList<>();
        Map<String,Integer> amap = new HashMap<>();
        Map<String,Integer> bmap = new HashMap<>();
        for(int i=0;i<as.length;i++){
        	amap.merge(as[i],1, (a,b)->a+b);
        }
        for(int i=0;i<bs.length;i++){
        	bmap.merge(bs[i],1, (a,b)->a+b);
        }
        for(String key:amap.keySet()){
        	if(amap.get(key)==1&&(!bmap.containsKey(key))){
        		ret.add(key);
        	}
        }
        
        for(String key:bmap.keySet()){
        	if(bmap.get(key)==1&&(!amap.containsKey(key))){
        		ret.add(key);
        	}
        }
        
        return ret.toArray(new String[]{});
    }
}
