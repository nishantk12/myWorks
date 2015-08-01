package sortingSearching;

import java.util.Arrays;

public class MergeSort {
	static int numsG[] = {4,0,6,2,8,5,4};
	public static void main(String[] args) {
		
		mergeSort(0,numsG.length-1);
		System.out.println(Arrays.toString(numsG));
	}

	private static void mergeSort( int start, int end) {
		if(start<end){
			int center = (start + end)/2;
			mergeSort(start,center);
			mergeSort(center+1,end);
			merge(numsG,start,center,end);
		}
	}

	private static void merge(int[] nums, int start, int center, int end) {
		//System.out.println(Arrays.toString(nums));
		int oneTemp = start;
		int twoTemp = center+1;
		int pointer = start;
		int count = 0;
		int[] numstemp = nums.clone();
		
		while(count<=(end-start)+1){
			if(oneTemp<=center && twoTemp <= end){
				if(nums[oneTemp] <= nums[twoTemp]){
					numstemp[pointer] = nums[oneTemp];
					oneTemp++;
				}else{
					numstemp[pointer] = nums[twoTemp];
					twoTemp++;
				}
			}
			
			else if(twoTemp <= end){
				numstemp[pointer] = nums[twoTemp];
				twoTemp++;
			}
			
			else if(oneTemp <= center){
				numstemp[pointer] = nums[oneTemp];
				oneTemp++;
			}
			
			pointer++;
			count++;
		}
		
		
		numsG = numstemp;
	}
}