package sortingSearching;

public class MergeSort {
	public static void main(String[] args) {
		int nums[] = {3,7,1,4,7,9,2,3,0};
		mergeSort(nums,0,nums.length-1);
	}

	private static void mergeSort(int[] nums, int start, int end) {
		if(start<end){
			int center = (end - start)/2;
			mergeSort(nums,start,center);
			mergeSort(nums,center,start);
			merge(nums,start,center,end);
		}
	}

	private static void merge(int[] nums, int start, int center, int end) {
		
		
	}

}
