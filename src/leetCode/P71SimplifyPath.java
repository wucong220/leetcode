package leetCode;

import java.util.Arrays;
import java.util.Stack;

public class P71SimplifyPath {
    static public String simplifyPath(String path) {
    	Stack<String> parentPaths=new Stack<String>();
    	StringBuilder currentPath=new StringBuilder();
    	String[] paths = path.split("/");
    	System.out.println(Arrays.toString(paths));
    	for(int i=0;i<paths.length;i++){
    		if(paths[i].equals(".")){
    			
    		}
    		else if(paths[i].equals("..")){
    			if(!parentPaths.empty())
    			currentPath.delete(0, currentPath.length());
    			currentPath.append(parentPaths.pop());
    		}
    		else if(paths[i].equals("")){
    			
    		}
    		else{
    			parentPaths.push(currentPath.toString());
    			currentPath.append("/");
    			currentPath.append(paths[i]);
    		}
    	}
    	return currentPath.toString();
    }
    
    public static void main(String[] args) {
		System.out.println(simplifyPath("/a/./b/../../c/"));
	}
}
