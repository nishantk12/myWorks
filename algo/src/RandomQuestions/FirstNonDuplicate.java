package RandomQuestions;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

public class FirstNonDuplicate {
	public static void main(String[] args) {
		String s = "abcdeac";
		System.out.println(firstNonDupIndex(s));
	}

	private static int firstNonDupIndex(String s) {
		char[] sChar = s.toCharArray();
		Map<Character,Integer> uniqueChars = new LinkedHashMap<Character,Integer>();
		Map<Character,Integer> repeatedChars = new HashMap<Character,Integer>();
		for(int i=0;i<sChar.length;i++){
			if(!uniqueChars.containsKey(sChar[i]) && !repeatedChars.containsKey(sChar[i])){
				uniqueChars.put(sChar[i], i);
			}else if(uniqueChars.containsKey(sChar[i])){
				uniqueChars.remove(sChar[i]);
				repeatedChars.put(sChar[i],1);
			}
		}
		return uniqueChars.get(uniqueChars.keySet().iterator().next()) ;
	}
}
