package recursion;

import java.util.ArrayList;
import java.util.List;

public class completeBrackets {
	public static List<String> bracks= new ArrayList<String>(); 
	public static void main(String[] args) {
		String[] arr = {"()","()"};
		printBrackets(0,arr,"","");
		for(int i=0;i<bracks.size();i++){
			System.out.println(bracks.get(i));
		}
	}

	private static String printBrackets(int start, String[] arr, String set1, String set2) {
		if(start>=arr.length){
			if(!bracks.contains(set1))
			  bracks.add(set1);
			if(!bracks.contains(set2))
				  bracks.add(set2);
			return "ph";
		}
		
		return printBrackets(start+1, arr, "(" + set1 + ")", "()"+set2)+"..."+
		printBrackets(start+1, arr, set1+"()", "(" + set2 + ")");
		
	}
}
