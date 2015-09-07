package sortingSearching;

public class BinarySearch {
	public static void main(String[] args) {
		int[] nums = {1,2};
		int n = 2;
		System.out.println(findNumIndex(nums,0,nums.length-1,n));
		// without recursion
		System.out.println(findIndex(nums,n));
	}

	private static int findIndex(int[] nums, int n) {
		int start = 0;
		int stop = nums.length -1;
		while(stop >= start){
			int center = (start + stop)/2;
			if(nums[center] < n){
				start = center + 1;
			}else if(nums[center] > n){
				stop = center - 1;
			}else{
				return center;
			}
		}
		return -1;
	}

	private static int findNumIndex(int[] nums, int start, int end, int n) {
		if(start>=end){
			if(nums[start] == n)
				return start;
			else 
				return -1;
		}
		int center = (start+end)/2;
		if(nums[center] == n)
			return center;
		if(nums[center] > n)
			return findNumIndex(nums, start, center-1, n);
		else
			return findNumIndex(nums, center+1, end, n);
	}
}