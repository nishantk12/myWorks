package sortingSearching;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class CircusTower {
	public static void main(String[] args) {
		int[][] input = {{1,1,2,6,3},{4,6,7,15,8}};
		Map<Integer,Integer> inputMap = createMapForInput(input);
		
		Set<Integer> Keys = inputMap.keySet();
		List<Integer> sortedKeys = new ArrayList<Integer>();
		System.out.println(Arrays.toString(Keys.toArray()));
		sortedKeys.addAll(Keys);
		Collections.sort(sortedKeys);
		System.out.println(Arrays.toString(sortedKeys.toArray()));
		int maxHieght = calculateMaxHieght(inputMap,sortedKeys,0,sortedKeys.size()-1);
		System.out.println(maxHieght);
	}

	private static int calculateMaxHieght(Map<Integer, Integer> inputMap, List<Integer> sortedKeys, int start,int end) {
		if(start >= end)
			return 1;
		
		if(inputMap.get(sortedKeys.get(start)) < inputMap.get(sortedKeys.get(start+1)))
			return Math.max(1 + calculateMaxHieght(inputMap,sortedKeys,start+1,end), calculateMaxHieght(inputMap,sortedKeys,start+1,end));
		else		
			return calculateMaxHieght(inputMap,sortedKeys,start+1,end);
	}

	private static Map<Integer, Integer> createMapForInput(int[][] input) {
		Map<Integer, Integer> inputMap = new HashMap<Integer, Integer>();
		for(int i=0;i<input[0].length;i++){
			inputMap.put(input[0][i], input[1][i]);
		}
		return inputMap;
	}
}
