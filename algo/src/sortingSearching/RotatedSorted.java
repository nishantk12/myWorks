package sortingSearching;

public class RotatedSorted {
	public static void main(String[] args) {
		int[] nums = {4,5,6,7,8,0,1,2};
		int findNumber = 1;
		int smallestIndex = findIndexOfSmallestElement(nums,0,nums.length-1);
		System.out.println("smallest element has index as " + smallestIndex);
		int searchIndex = findElement(nums,smallestIndex,smallestIndex + nums.length,findNumber);
		
		System.out.println("element found at " + searchIndex);
	}

	private static int findElement(int[] nums, int start, int end, int findNumber) {
		int center = (end + start)/2;
		int endTemp = end;
		if(nums[start] == findNumber)
			return start;
		if(end > nums.length-1){
			center = center - nums.length;
			endTemp = end - nums.length;
		}
		
		if(nums[center] == findNumber)
			return center;
		if(nums[endTemp] == findNumber)
			return endTemp;
		if(nums[nums.length-1] == findNumber)
			return nums.length-1;
		
		if(end <= start){
			if(nums[end] == findNumber)
				return start;
			else
				return -999;
		}
		
		if(nums[center] > findNumber)
			return findElement(nums, start+1, center-1,findNumber);
		else
			return findElement(nums, center+1, end-1, findNumber);
		
	}

	private static int findIndexOfSmallestElement(int[] nums,int start,int end) {
		if(end <= start)
			return end;
		int center = (end + start)/2;
		
		//if the left over list is not sorted
		if(nums[end] < nums[start]){
			
			if(nums[center] >= nums[start])
				return findIndexOfSmallestElement(nums, center+1, end);
			else
				return findIndexOfSmallestElement(nums, start, center);
			
			
		//if the left over list is sorted
		}else{
			if(nums[center] >= nums[start])
				return findIndexOfSmallestElement(nums, start, center);
			else
				return findIndexOfSmallestElement(nums, center+1, end);
		}
	}
}