package recursion;

import java.util.ArrayList;
import java.util.List;

public class AllStringPermutation {
	static List<String> outList = new ArrayList<String>();
	
	public static void main(String[] args) {
		char[] arr = {'(','(','(',')',')',')'};
		printStringPermutations(0,arr,"","");
		/*Iterator<String> it = outList.iterator();
		while(it.hasNext()){
			String bb = it.next();
			int len = bb.length();
			for(int i=0;i<len;i++){
				bb = bb+")";
			}
			System.out.println(bb);
		}*/
	}

	private static String printStringPermutations(int start, char[] arr, String set1, String set2) {
		if(start >= arr.length){
			System.out.println(set1);
			/*if(!outList.contains(set1))
				outList.add(set1);*/
			return "ph";
		}
		
		return printStringPermutations(start+1, arr, set1+arr[start], set2) + "..." +
		printStringPermutations(start+1, arr, set1, set2+arr[start]);
	}

}
