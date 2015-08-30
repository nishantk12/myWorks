package leetCode;

import java.util.Arrays;

public class MaximumProductSubarray {
	public static void main(String[] args) {
		int[] nums = {-3,0,1,-2};
		int max = findMaxProSub(nums);
		System.out.println(max);
	}

	private static int findMaxProSub(int[] nums) {
		int[] bestProMax = new int[nums.length];
		int[] bestProMin = new int[nums.length];
		//int[] bestPro = new int[nums.length];
		int max = nums[nums.length - 1];
		bestProMax[nums.length-1] = nums[nums.length - 1];
		bestProMin[nums.length-1] = nums[nums.length - 1];
		for(int i=nums.length-2;i>=0;i--){
			if(bestProMax[i+1]*nums[i] > bestProMin[i+1]*nums[i]){
				bestProMax[i] = bestProMax[i+1]*nums[i];
				bestProMin[i] = bestProMin[i+1]*nums[i];
			}else{
				bestProMax[i] = bestProMin[i+1]*nums[i];
				bestProMin[i] = bestProMax[i+1]*nums[i];
			}
			if(nums[i] > bestProMax[i]){
				bestProMax[i] = nums[i];
			}
			if(nums[i] < bestProMin[i]){
				bestProMin[i] = nums[i];
			}
			if(max < bestProMax[i]){
				max = bestProMax[i];
			}
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

/*for(int i=0;i<nums.length;i++){
bestPro[i] = findProductByIndex(nums,i);
if(bestPro[i] > max)
	max = bestPro[i];
}*/
