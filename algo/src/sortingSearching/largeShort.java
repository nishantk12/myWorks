package sortingSearching;

import java.util.Arrays;

public class largeShort {
	public static void main(String[] args) {
		int[] arr1 = new int[10];
		int[] arr2 = new int[3];
		
		for(int i=0;i<arr1.length;i++)
			arr1[i] = -999;
		
		arr1[0] = 10;arr1[1] = 21;arr1[2] = 80;arr1[3] = 100;
		arr2[0] = 27;arr2[1] = 30;arr2[2] = 85;
		
		int[] sortedArray = mergeSortedArrays(arr1,arr2);
		
		System.out.println(Arrays.toString(sortedArray));
		
		sortedArray = insertSortedArray(arr1,arr2);
		
	}

	//when you have lot of space and working area is not a problem
	
	private static int[] mergeSortedArrays(int[] arr1, int[] arr2) {
		int sortedArray[] = arr1.clone();
		
		int count = 0;
		int count1 = 0;
		int count2 = 0;
		
		while(arr1[count1] != -999 && count2 < arr2.length){
			if(arr1[count1] <= arr2[count2]){
				sortedArray[count] = arr1[count1];
				count++;count1++;
			}else{
				sortedArray[count] = arr2[count2];
				count++;count2++;
			}
		}
		
		while(arr1[count1] != -999){
			sortedArray[count] = arr1[count1];
			count++;count1++;
		}
		
		while(count2 <arr2.length){
			sortedArray[count] = arr2[count2];
			count++;count2++;
		}
		
		
		return sortedArray;
	}
	
	
	//when you dont have space but you can compromise in the area of CPU
	
	private static int[] insertSortedArray(int[] arr1, int[] arr2) {
		int count = 0;
		int count1 = 0;
		//int count2 = 0;
		while(count < arr2.length){
			if(arr2[count] < arr1[count1]){
				//shift by 1
				//allocate arr2[count] to 
				//increase counts by 1
			}else{
				//increase counts by 1
			}
		}
		return null;
	}
}
