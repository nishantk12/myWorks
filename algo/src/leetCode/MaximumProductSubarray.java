package leetCode;

import java.util.Arrays;

public class MaximumProductSubarray {
	public static void main(String[] args) {
		int[] nums = {-2,3,-4};
		int max = findMaxProSub(nums);
		System.out.println(max);
	}

	private static int findMaxProSub(int[] nums) {
		int[] bestPro = new int[nums.length];
		int max = nums[0];
		for(int i=0;i<nums.length;i++){
			bestPro[i] = findProductByIndex(nums,i);
			if(bestPro[i] > max)
				max = bestPro[i];
		}
		return max;
	}
	
	private static int findProductByIndex(int[] nums, int j) {
		int product = nums[j];
		int maxProduct = product;
		for(int i=j+1;i<nums.length;i++){
			if(maxProduct < nums[i]*product){
				maxProduct =  nums[i]*product;
				//System.out.println("maxProduct" + "if" + maxProduct);
			}
			product = product * nums[i];
			//System.out.println(maxProduct);
		}
		return maxProduct;
	}

	
	private static int findMaxOfArray(int[] bestSum) {
		int max = bestSum[0];
		for(int i=1;i<bestSum.length;i++){
			max = Math.max(max, bestSum[i]);
		}
		return max;
	}
}
