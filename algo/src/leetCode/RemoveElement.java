package leetCode;

import java.util.Arrays;

public class RemoveElement {
	public static void main(String[] args) {
		int nums[] = {0,4,4,4,1,7,1,3,4,4,3}; //{0,1,45,2,9,4,3,2,1,7,6,54,4,3,2,2,3,4,5,4,433,3};
		int val = 4;
		int numslength = cleanNums(nums,val);
		System.out.println(numslength);
	}

	private static int cleanNums(int[] nums, int val) {
		int count = 0;
		for(int i=0;i<nums.length;i++){
			
			if(i+count >= nums.length){
				break;
			}else{
				nums[i] = nums[i + count];
			}
			if(nums[i] == val){
				count++;
				i--;
			}
		}
		System.out.println(Arrays.toString(nums));
		return nums.length - count;
	}
	
	
}
