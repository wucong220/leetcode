package leetCode;

public class P50Pow {
    public static double myPow(double x, int n) {
        double temp = 1;
        int flag= 0;
        if(n<0){flag=1;n=-n;}
        while(n-->0){
            temp = temp*x;
        }
        if(flag==0)
        return temp;
        else return 1/temp;
        
    }
    public static void main(String[] args) {
		System.out.println(myPow(2,-2));
    }
    
}
