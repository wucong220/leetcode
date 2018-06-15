package contest;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class P851LoudAndRich {
	public static void main(String[] args) {
		System.out.println(Arrays.toString(loudAndRich(new int[][]{{1,0},{2,1},{3,1},{3,7},{4,3},{5,3},{6,3}}, new int[]{3,2,5,4,6,1,7,0})));
	}
	
	static public int getAnswer(Person p,Person[] ps, int[] quiet){
		if(p.answer!=null)return p.answer;
		List<Integer> richers = p.getRicher();
		int answer = p.getId();
		for(int richer:richers ){
			if(ps[richer].answer==null)ps[richer].answer=getAnswer(ps[richer],ps,quiet);
			if(quiet[ps[richer].answer]<quiet[answer]){
				answer = ps[richer].answer;
			}	
		}
		
		
		return answer;
	}
	
   static public int[] loudAndRich(int[][] richer, int[] quiet) {
    	Person[] ps = new Person[quiet.length];
    	int[] answer = new int[quiet.length];
    	for(int i=0;i<quiet.length;i++){
    		ps[i]=(new Person(i,quiet[i],new ArrayList<>(quiet.length)));
    	}
    	for(int i=0;i<richer.length;i++){
    		ps[richer[i][1]].getRicher().add(ps[richer[i][0]].getId());
    	}
    	for(int i=0;i<quiet.length;i++){
    		answer[i]=getAnswer(ps[i], ps, quiet);
    	}
    	return answer; 
    }
}

class Person{
	int id;
	int quietness;
	Integer answer=null;

	List<Integer> richer;
	public Person(int id, int quietness, List<Integer> richer) {
		super();
		this.id = id;
		this.quietness = quietness;
		this.richer = richer;
	}
	/**
	 * @return the id
	 */
	public int getId() {
		return id;
	}
	/**
	 * @param id the id to set
	 */
	public void setId(int id) {
		this.id = id;
	}
	/**
	 * @return the quietness
	 */
	public int getQuietness() {
		return quietness;
	}
	/**
	 * @param quietness the quietness to set
	 */
	public void setQuietness(int quietness) {
		this.quietness = quietness;
	}
	/**
	 * @return the richer
	 */
	public List<Integer> getRicher() {
		return richer;
	}
	/**
	 * @param richer the richer to set
	 */
	public void setRicher(List<Integer> richer) {
		this.richer = richer;
	}
	
}
