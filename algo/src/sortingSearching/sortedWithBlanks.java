package sortingSearching;

import java.util.HashMap;
import java.util.Map;

public class sortedWithBlanks {
	public static void main(String[] args) {
		String[] arr = {"","","A","B","","","C","D","","","","I","M","P","","","","Z"};
		compressionParameters comPar = new compressionParameters();
		comPar = compressArrayForBlanks(arr);
		int index = search("E",comPar);
		if(index == -1)
			System.out.println("not found");
		else
		System.out.println("found at" + index);
	}

	private static int search(String find, compressionParameters comPar) {
		String[] compressed = comPar.compressedArray;
		int lastIndex = comPar.lastIndex;
		System.out.println(lastIndex);
		int index = binarySearch(find,compressed,0,lastIndex);
		System.out.println(index);
		
		if(index == -1)
			return -1;
		int spaces = comPar.blanksInformation.get(index);
		return index + spaces;
	}

	private static int binarySearch(String find, String[] compressed, int start, int lastIndex) {
		
		int center = (start + lastIndex)/2;
		if(start>=lastIndex){
			if(compressed[center].equals(find))
				return center;
			else
				return -1;
		}
		if(compressed[center].equals(find))
			return center;
		
		if(compressed[center].compareTo(find) < 0)
			return binarySearch(find,compressed,center+1,lastIndex);
		
		if(compressed[center].compareTo(find) > 0)
			return binarySearch(find,compressed,start,center-1);
		
		return -1;
	}

	private static compressionParameters compressArrayForBlanks(String[] arr) {
		String[] compressedArr = new String[arr.length];
		Map<Integer, Integer> blanks = new HashMap<Integer, Integer>();
		int j = 0;
		int count = 0;
		for(int i=0;i<arr.length;i++){
			if(arr[i].equals("")){
				count++;
			}else{
				compressedArr[j] = arr[i];
				blanks.put(j, count);
				j++;
				//count=0;
			}
		}
		
		compressionParameters comPar = new compressionParameters();
		comPar.blanksInformation = blanks;
		comPar.compressedArray = compressedArr;
		comPar.lastIndex =j-1;
		return comPar;
	}
}

