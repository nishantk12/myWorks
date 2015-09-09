package RandomQuestions;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FirstNonDuplicate {
	public static void main(String[] args) {
		String s = "abcac";
		System.out.println(firstNonDupIndex(s));
	}

	private static int firstNonDupIndex(String s) {
		char[] sChar = s.toCharArray();
		int indexPointer = 0;
		List<Integer> indexes = new ArrayList<Integer>();
		List<Integer> removedIndexes = new ArrayList<Integer>();
		Map<Character,Integer> check = new HashMap<Character,Integer>();
		for(int i=0;i<sChar.length;i++){
			if(check.remove(sChar[i])==null){
				check.put(sChar[i],i);
				indexes.add(i);
			}else{
				indexPointer++;
			}
		}
		return indexes.get(indexPointer);
	}
}
