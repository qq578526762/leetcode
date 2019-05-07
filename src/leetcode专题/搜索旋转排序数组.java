package leetcode专题;

public class 搜索旋转排序数组 {
	public static void main(String[] args) {
//		int[] nums = {4,5,6,7,0,1,2};
		int[] nums = {2};
		System.out.println(search(nums,2));
	}
	
	public static int search(int[] nums, int target) {
		if(nums.length==0) {
			return -1;
		}
		int mid = nums.length/2;
		if(target>nums[mid]) {
			for(int i=mid+1;i<nums.length;i++) {
				if(target<nums[i]) {
					return -1;
				}else if(target==nums[i]) {
					return i;
				}
			}
			for(int i=0;i<mid;i++) {
				if(target<nums[i]) {
					return -1;
				}else if(target==nums[i]) {
					return i;
				}
			}
			return -1;
		}else if(target<nums[mid]) {
			for(int i=mid-1;i>=0;i--) {
				if(target>nums[i]) {
					return -1;
				}else if(target==nums[i]) {
					return i;
				}
			}
			for(int i=nums.length-1;i>mid;i--) {
				if(target>nums[i]) {
					return -1;
				}else if(target==nums[i]) {
					return i;
				}
			}
			return -1;
		}else {
			return mid;
		}
    }
}
