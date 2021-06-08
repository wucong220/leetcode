package leetCode300;

public class P307 {
	public static void main(String[] args) {
		NumArray na = new NumArray(new int[]{0,9,5,7,3});
		System.out.println(na.sumRange(0, 2));
		na.update(1, 2);
		System.out.println(na.sumRange(0, 2));
	}
}
class NumArray {
	int seg[];
	int lazy[];
	int length;
	
    public NumArray(int[] nums) {
    	length=nums.length;
    	lazy=new int[length*4];
    	seg=new int[length*4];
    	
    	buildTree(nums,0,0,nums.length-1);
    }

	public void update(int i, int val) {
        updateTree(0,val,i,i,0,length-1);
    }
    


	public int sumRange(int i, int j) {
         return queryRange(0,i,j,0,length-1);
    }
    
    private int queryRange(int i, int ql, int qr, int l, int r) {
		if(ql>qr)return 0;
		
		if(lazy[i]!=0){
			seg[i]+=lazy[i];
			if(l!=r){
				lazy[i*2+1]+=lazy[i];
				lazy[i*2+2]+=lazy[i];
			}
			lazy[i]=0;
		}
		
		if(qr<l||r<ql){
			return 0;
		}
		else if(l>=ql&&qr>=r){
			
			return seg[i];
		}
		else{
			int mid = l+(r-l)/2;
			return queryRange(i*2+1, ql, qr, l, mid)+queryRange(i*2+2, ql, qr, mid+1, r);
		}
    	
	}

	private void buildTree(int[] nums,int i, int l, int r) {
		// TODO Auto-generated method stub
    	if(l==r){
    		seg[i]=nums[l];
    	}
    	else{
    		int mid = l+(r-l)/2;
    		buildTree(nums,i*2+1,l,mid);
    		buildTree(nums,i*2+2,mid+1,r);
    		seg[i]=seg[i*2+1]+seg[i*2+2];
    	}
	}
    
    private void updateTree(int i,int val,int ql,int qr, int l, int r) {
		// TODO Auto-generated method stub
		if(ql>qr)return;
		else{
			if(lazy[i]!=0){
				seg[i]+=lazy[i];
				if(l!=r){
					lazy[i*2+1]+=lazy[i];
					lazy[i*2+2]+=lazy[i];
				}
				lazy[i]=0;
			}
			
			if(ql>r||qr<l){
				return;
			}
			else
			if(ql<=l&&qr>=r){
				seg[i]=val;
				if(l!=r){
					lazy[i*2+1]+=val;
					lazy[i*2+2]+=val;
				}		
				return;
			}
			else
			{	int mid = l+(r-l)/2;
				updateTree(i*2+1,val,ql,qr,l,mid);
				updateTree(i*2+2,val,ql,qr,mid+1,r);
				seg[i] = seg[i*2+1]+seg[i*2+2];
			}
		}
	}
}