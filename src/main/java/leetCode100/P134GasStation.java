package leetCode100;

import java.util.Arrays;

public class P134GasStation {
	//0ms
	/*class Solution {
		public:
		    int canCompleteCircuit(vector<int> &gas, vector<int> &cost) {
		        int start(0),total(0),tank(0);
		        //if car fails at 'start', record the next station
		        for(int i=0;i<gas.size();i++) if((tank=tank+gas[i]-cost[i])<0) {start=i+1;total+=tank;tank=0;}
		        return (total+tank<0)? -1:start;
		    }
		};
	}*/
	
	//40ms
	public static int canCompleteCircuit(int[] gas, int[] cost) {
		int[] fuck = new int[gas.length];
		for (int i = 0; i < gas.length; i++) {
			fuck[i] = gas[i] - cost[i];
		}
		int flag = 0;
		int end = gas.length;
		Integer ret = null;
		for (int i = 0; i < end; i++) {
			int fuckyou = 0;
			int oldi = i;

			while (fuck[i] < 0) {
				flag = 1;
				if (fuckyou == 0) {
					fuckyou=1;
					if (ret == null) {
						ret = (i - 1 + gas.length) % gas.length;
					}
					fuck[ret]+=fuck[i];
					fuck[i]=0;
					i=ret;
					if (i > oldi)
						end = i;
					if (i == oldi)
						return -1;	
				} else {
					fuck[(i - 1 + gas.length) % gas.length] += fuck[i];
				
					fuck[i] = 0;
					i = (i - 1 + gas.length) % gas.length;
					if (i > oldi)
						end = i;
					if (i == oldi)
						return -1;
					ret = i;
				}
			}
			System.out.println(Arrays.toString(fuck));
			i = oldi;
		}

		if (flag == 0)
			return 0;
		else
			return ret;

		// for (int j = 0; j < gas.length; j++) {
		// int totalgas = 0;
		// for (int i = j; i < gas.length+j; i++) {
		// totalgas += gas[i%gas.length];
		// totalgas -= cost[i%gas.length];
		// if (totalgas < 0)
		// break;
		// }
		// if(totalgas>=0){
		// return j;
		// }
		// }
		//
		//

	}

	public static void main(String[] args) {
		System.out.println(canCompleteCircuit(new int[] { 1,2,3,3 }, new int[] {2,1,5,1}));
	}
}
