package sortingSearching;

import java.util.Arrays;

public class MergeSort {
	static int numsG[] = {4,0,6,2,8,5,4};
	public static void main(String[] args) {
		
		int numstemp[] = numsG;
		mergeSort(numstemp,0,numsG.length-1);
		System.out.println(Arrays.toString(numsG));
	}

	private static void mergeSort(int[] nums, int start, int end) {
		// TODO Auto-generated method stub
		if(start<end){
			int center = (start + end)/2;
			mergeSort(nums,start,center);
			mergeSort(nums,center+1,end);
			merge(nums,start,center,end);
		}
		
		
	}

	private static void merge(int[] nums, int start, int center, int end) {
		System.out.println("start " + start + " center " + center +  " end " + end);
		System.out.println(Arrays.toString(nums));
		int oneTemp = start;
		int twoTemp = center+1;
		int pointer = start;
		int count = 0;
		int[] numstemp = nums;
		
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