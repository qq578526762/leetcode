package leetcode专题;

import java.util.Arrays;

public class 在排序数组中查找元素的第一个和最后一个位置 {
	public static void main(String[] args) {
		int[] nums = {5,7,7,8,8,10};
//		int[] nums = {8};
		System.out.println(Arrays.toString(searchRange(nums, 8)));
	}

	public static int[] searchRange(int[] nums, int target) {
		int[] result = { -1, -1 };
		int start = -1;
		int end = -1;
		if (nums.length == 0) {
			return result;
		}
		int mid = nums.length / 2;
		if (nums[mid] == target) {
			start = mid;
			while (start-1>=0&&nums[start-1] == target) {
				start--;
			}
//			start = start == 0 ? 0 : ++start;
			end = mid;
			while (end+1<nums.length&&nums[end+1] == target) {
				end++;
			}
//			end = end == nums.length ? nums.length : --end;
			result[0] = start;
			result[1] = end;
			return result;
		} else if (target > nums[mid]) {
			for (int i = mid + 1; i < nums.length; i++) {
				if (target < nums[i]) {
					return result;
				} else if (target == nums[i]) {
					start = i;
					while (i+1 < nums.length && nums[i+1] == target)	{
						i++;
					}
					end=i;
//					end = i == nums.length ? nums.length : --i;
					result[0] = start;
					result[1] = end;
					return result;
				}
			}
		} else if (target < nums[mid]) {
			for (int i = mid - 1; i >= 0; i--) {
				if (target > nums[i]) {
					return result;
				} else if (target == nums[i]) {
					end = i;
					while (i-1>= 0 && target == nums[i-1]) {
						i--;
					}
					start = i;
					result[0] = start;
					result[1] = end;
					return result;
				}
			}
		}
		return result;
	}
}
