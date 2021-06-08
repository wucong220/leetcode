package contest;

public class P860LemonadeChange {
    public boolean lemonadeChange(int[] bills) {
        int count5=0;
        int count10=0;
        for(int i=0;i<bills.length;i++){
        	switch(bills[i]){
        		case 5:
        			count5++;
        			break;
        		case 10:
        			if(count5>0){
        				count5--;
        				count10++;
        			}
        			else{
        				return false;
        			}
        			break;
        		case 20:
        			if(count5>0){
        				if(count10>0){
        					count10--;
        					count5--;
        				}
        				else{
        					if(count5>3){
        						count5-=3;
        					}
        					else{
        						return false;
        					}
        				}
        			}
        			else{
        				return false;
        			}
        			break;
        	}
        }
    	return true;
    }
}
