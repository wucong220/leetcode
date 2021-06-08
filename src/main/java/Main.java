import java.util.Scanner;

public class Main {


	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		int a[][] = new int[n][2];
		for(int i=0;i<n;i++){
			a[i][0]=in.nextInt();
			a[i][1]=in.nextInt();
		}
		for(int i=0;i<n;i++){
			int[] curr = find(a[i][0],a[i][1]);
			System.out.println(curr[1]+" "+curr[0]);
		}
	}
	
	public static int[] find(int n,int m){
		int max = (n-(m-1))*(n-(m-1)-1)/2;
		int ave = n/m;
		int offset = n%m;
		int min = (m-offset)*ave*(ave-1)/2+offset*(ave+1)*(ave)/2;
		return new int[]{max,min};
		

	}
}
