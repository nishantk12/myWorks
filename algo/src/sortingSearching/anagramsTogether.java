package sortingSearching;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class anagramsTogether {
	public static void main(String[] args) {
		String str1 = "sasasa";
		String str2 = "ssssss";
		
		if(checkIfAnagrams(str1,str2)){
			System.out.println("yes anagrams");
		}else{
			System.out.println("not anagrams");
		}
		
		String[] strArray = {"army","mary","sasa","asas"};
		
		String[] SortedArray = sortAsPerAnagrams(strArray);
		System.out.println(Arrays.toString(SortedArray));
	}

	private static String[] sortAsPerAnagrams(String[] strArray) {
		String[] sortedArray = new String[strArray.length];
		List<List<String>> anagramClusters = new ArrayList<List<String>>();
		List<String> finalList = new ArrayList<String>();
		int count = 0;
		for(int i=0;i<sortedArray.length;i++){
			anagramClusters = addToList(anagramClusters,strArray[i]);
		}
		
		while(anagramClusters.get(count) != null){
			Collections.sort(anagramClusters.get(count));
			finalList.addAll(anagramClusters.get(count));
		}
		sortedArray = (String[]) finalList.toArray();
		return sortedArray;
	}

	private static List<List<String>> addToList
			(List<List<String>> anagramClusters,String string) {
		int count = 0; 
		int added = 0;
		while(anagramClusters.get(count) != null){
			List<String> cluster = anagramClusters.get(count);
			if(checkIfAnagrams(string, cluster.get(0))){
				cluster.add(string);
				added = 1;
			}
			count++;
		}
		if(added == 0){
			List<String> cluster = new ArrayList<String>();
			cluster.add(string);
			anagramClusters.add(cluster);
		}
		return anagramClusters;
	}

	private static boolean checkIfAnagrams(String str1, String str2) {
		char[] ctr1 = str1.toCharArray();
		char[] ctr2 = str2.toCharArray();
		
		if(str1.length() != str2.length())
			return false;
		
		int[] ctrCheck1 = new int[ctr2.length];
		for(int i=0;i<ctr2.length;i++){
			ctrCheck1[i] = 0;
		}
		
		int count1=0;
		
		while(count1<str1.length()){
			int loc = inArray(ctr1,ctr2[count1],ctrCheck1);
			if(loc != -1){
				ctrCheck1[loc] = 1;
				count1++;
			}else{
				return false;
			}
		}
		return true;
	}

	private static int inArray(char[] ctr1, char c, int[] ctrCheck1) {
		for(int i=0;i<ctr1.length;i++){
			if(ctr1[i] == c && ctrCheck1[i] == 0){
				return i;
			}
		}
		return -1;
	}
}
