package leetCode;

public class P04 {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        if(nums1.length>nums2.length){
            return findMedianSortedArrays(nums2,nums1);
        }
        int k = nums1.length + nums2.length;
        int l=0;
        int r=nums1.length+1;
        while(l<r){
            int mid = l+(r-l)/2;
            int patitionX = mid;
            int patitionY = k/2 - patitionX;
            int leftMaxX = patitionX==0?Integer.MIN_VALUE:nums1[patitionX-1];
            int leftMaxY = patitionY==0?Integer.MIN_VALUE:nums2[patitionY-1];
            int rightMinX = patitionX == nums1.length?Integer.MAX_VALUE:nums1[patitionX];
            int rightMinY = patitionY == nums2.length?Integer.MAX_VALUE:nums2[patitionY];
            if(leftMaxX<=rightMinY&&leftMaxY<=rightMinX){
                if((k)%2==0)return ((double)Math.max(leftMaxX,leftMaxY)+Math.min(rightMinX,rightMinY))/2;
                else return Math.min(rightMinX,rightMinY);
            }
            else if(leftMaxX<rightMinY) {
                l=mid+1;
            }
            else{
                r=mid;
            }
        }
        return -1;
    }
    //
    static public double findKth(int[] nums1, int[] nums2,int kth) {
        if(nums1.length>nums2.length){
            return findKth(nums2,nums1,kth);
        }
        int l=nums2.length>kth?0:kth-nums2.length;
        int r=Math.min(kth, nums1.length)+1;
        while(l<r){
            int mid = l+(r-l)/2;
            int patitionX = mid;
            int patitionY = kth - patitionX;
            int leftMaxX = patitionX==0?Integer.MIN_VALUE:nums1[patitionX-1];
            int leftMaxY = patitionY==0?Integer.MIN_VALUE:nums2[patitionY-1];
            int rightMinX = patitionX == nums1.length?Integer.MAX_VALUE:nums1[patitionX];
            int rightMinY = patitionY == nums2.length?Integer.MAX_VALUE:nums2[patitionY];
            if(leftMaxX<=rightMinY&&leftMaxY<=rightMinX){
               return Math.max(leftMaxX,leftMaxY);
            }
            else if(leftMaxX<rightMinY) {
                l=mid+1;
            }
            else{
                r=mid;
            }
        }
        return -1;
    }
	public static void main(String[] args) {
		System.out.println(findKth(new int[]{1,2},new int[]{3,4},2));
	}
}
