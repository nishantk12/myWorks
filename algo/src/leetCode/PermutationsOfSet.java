package leetCode;

import java.util.ArrayList;
import java.util.List;

public class PermutationsOfSet {
	public static void main(String[] args) {
		int[] nums = {1,2,3,4};
		List<List<Integer>> perms = new ArrayList<List<Integer>>();
		getAllPermutations(nums,0,new ArrayList<Integer>(),perms);
	}

	private static void getAllPermutations(int[] nums, int start,
			ArrayList<Integer> permutation, List<List<Integer>> perms) {
		if(nums == null){
			return;
		}
		if(nums.length == permutation.size()){
			perms.add(permutation);
			return;
		}
		
		for(int i=0;i<=permutation.size();i++){
			
		}
	}
}
