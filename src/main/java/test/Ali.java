package test;

public class Ali {
	public static void main(String[] args) {
		
		
		System.out.println(new Ali().computeSS(new int[]{0,0,2,2},new int[]{0,2,2,0}, 1, 1));
		
	}
	
	
	double computeSS(int[] xs,int[] ys,int x,int y){
		
		
		double sum = 0;
		double ore = 0;
		for(int i=1;i<xs.length;i++){
			sum += computeS(xs[i],ys[i],xs[i-1],ys[i-1],x,y);
			if(i>1){
				ore += computeS(xs[i],ys[i],xs[i-1],ys[i-1],x,y);
			}
		}
		sum += computeS(xs[0],ys[0],xs[xs.length-1],ys[xs.length-1],x,y);
		if(sum-ore<=1)return 0;
		System.out.println(sum-ore);
		return -1;
	}
	
	
	double computeS(int x1,int y1,int x2,int y2,int x3,int y3){
		double a= computel(x1,y1,x2,y2);
		double b= computel(x3,y3,x2,y2);
		double c= computel(x1,y1,x3,y3);
		double s = (a+b+c)/2;
		return Math.sqrt(s*(s-a)*(s-b)*(s-c));
	}


	private double computel(int x1, int y1, int x2, int y2) {
		// TODO Auto-generated method stub
		return Math.sqrt((y1-y2)*(y1-y2)-(x2-x1)*(x2-x1));
	}
	
}
