package dynamic;

public class MaximumValueContiguous {
	public static void main(String[] args) {
		int nums[] = {1,-2,-2,1,2,3,-4,5};
		System.out.println(getMaxSum(nums,0));
	}

	private static int getMaxSum(int[] nums, int sum) {
		int max = 0;
		int[] sums = new int[nums.length];
		for(int i=0;i<nums.length;i++){
			if(i==0){
				sums[i] = nums[i];
			}else{
				sums[i] = Math.max(sums[i-1]+nums[i], nums[i]);
			}
			if(max < sums[i]) max = sums[i];
		}
		return max;
	}
	
	
}
