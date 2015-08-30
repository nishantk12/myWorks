package leetCode;

import java.util.Arrays;

public class MaximumSubarray {
	static int maxSumForIndex = 0;
	public static void main(String[] args) {
		int[] nums = {1};
		int maxSum = maxSumArray(nums,0,nums.length,0);
		System.out.println(maxSum);
	}
	
	

	private static int maxSumArray(int[] nums, int start, int end, int sum) {
		int[] bestSum = new int[nums.length];
		bestSum[nums.length-1] = nums[nums.length-1];
		for(int i=nums.length-2;i>=0;i--){
			if(nums[i] + bestSum[i+1] > nums[i]){
				bestSum[i] = nums[i] + bestSum[i+1];
			}else{
				bestSum[i] = nums[i];
			}
		}
		
		/*for(int i=0;i<nums.length;i++){
			bestSum[i] = findMaxForIndex(nums,i,0);
		}*/
		System.out.println(Arrays.toString(bestSum));
		int max = findMaxOfArray(bestSum);
		return max;
	}



	@SuppressWarnings("unused")
	private static int findMaxForIndex(int[] nums, int i,int sum) {
		maxSumForIndex = sum;
		for(int j=i;j<nums.length;j++){
			//sum = sum + nums[j];
			if(maxSumForIndex < sum+nums[j]){
				maxSumForIndex = sum + nums[j];
			}
			sum = sum+nums[j];
		}
		return maxSumForIndex;
	}



	private static int findMaxOfArray(int[] bestSum) {
		int max = bestSum[0];
		for(int i=1;i<bestSum.length;i++){
			max = Math.max(max, bestSum[i]);
		}
		return max;
	}
	
}
