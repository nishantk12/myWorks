package recursion;

public class AllSubsets {
  public static void main(String[] args) {
	int[] nums = {0,1,2,3,4};
	printAllSubsets(0,nums,"","");
}

private static String printAllSubsets(int start, int[] nums, String set1, String set2) {
	if(start >= nums.length){
		//System.out.println(set1);
		System.out.println(set2);
		return "ph";
	}
	return printAllSubsets(start+1,nums,set1+";"+String.valueOf(nums[start]),set2) +"..." 
	+ printAllSubsets(start+1,nums,set1,set2+";"+String.valueOf(nums[start]));
}
}
