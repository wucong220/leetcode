package leetCode300;

public class P371 {
	   static public int getSum(int a, int b) {
		     if(b == 0){//û�н�Ϊ��ʱ���������
		        return a;
		    }
		    int sum,carry;
		    sum = a^b;//��ɵ�һ���ӷ�������
		    carry = (a&b)<<1;//��ɵڶ�����λ������������
		    return getSum(sum,carry);//
	   }
	   
	   public static void main(String[] args) {
		   System.out.println(122&(~22));
	   }
}
