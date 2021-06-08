package offer;

import java.math.BigDecimal;

public class Power {
		public static void main(String[] args) {
			System.out.println(power(2,-3));
		}
	   static public double power(double base, int exponent) {
		   
		   BigDecimal basBD = new BigDecimal(String.valueOf(base));
		   if(base==0)return 0;
		   if(exponent<0){
			   basBD = new BigDecimal("1").divide(basBD);
			   exponent = -exponent;
		   }
		   return basBD.pow(exponent).doubleValue();       
	   }
}	
