package test;

/**
 * 最小二乘法 线性回归
 * y = a x + b 
 * 
 * b = sum( y ) / n - a * sum( x ) / n
 * 
 * a = ( n * sum( xy ) - sum( x ) * sum( y ) ) / ( n * sum( x^2 ) - sum(x) ^ 2 )
 * 
 * @author tian.yj
 *
 */ 
public class GetLine { 
 
    /*
     * 得到a和b的值
     */
	public static double[] estimateAandB(double[] x,double[] y){
		double[] ret = new double[2];
		ret[0] = getXc(x, y);
		ret[1] = getC(x,y,ret[0]);
		return ret;
		
	}
	
	
   /**
    * 得到a的值
    */
    public static double estimateA( double[] x , double[] y , int i ) { 
        double a = getXc( x , y ) ; 
       
        return a ; 
    } 
    /**
     * 得到常数b
     */
    public static double estimateB( double[] x , double[] y , int i ) { 
    	double a = getXc( x , y ) ; 
        double b = getC( x , y , a ) ; 
        return b;
    } 
     
    /**
     * 计算 x 的系数
     * @param x
     * @param y
     * @return
     */ 
    public static double getXc( double[] x , double[] y ){ 
        int n = x.length ; 
        return ( n * pSum( x , y ) - sum( x ) * sum( y ) )  
                / ( n * sqSum( x ) - Math.pow(sum(x), 2) ) ; 
    } 
     
    /**
     * 计算常量系数
     * @param x
     * @param y
     * @param a
     * @return
     */ 
    public static double getC( double[] x , double[] y , double a ){ 
        int n = x.length ; 
        return sum( y ) / n - a * sum( x ) / n ; 
    } 
     
    /**
     * 计算常量系数
     * @param x
     * @param y
     * @return
     */ 
    public static double getC( double[] x , double[] y ){ 
        int n = x.length ; 
        double a = getXc( x , y ) ; 
        return sum( y ) / n - a * sum( x ) / n ; 
    } 
     
    private static double sum(double[] ds) { 
        double s = 0 ; 
        for( double d : ds ) s = s + d ; 
        return s ; 
    } 
     
    private static double sqSum(double[] ds) { 
        double s = 0 ; 
        for( double d : ds ) s = s + Math.pow(d, 2) ; 
        return s ; 
    } 
     
    private static double pSum( double[] x , double[] y ) { 
        double s = 0 ; 
        for( int i = 0 ; i < x.length ; i++ ) s = s + x[i] * y[i] ; 
        return s ; 
    } 
} 

