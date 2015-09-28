package dynamic;

public class KnapSack {
	public static void main(String[] args) {
		int[] objects = {1,2,3};
		int[] values = {10,2,2};
		int capacity = 4;
		System.out.println(findMinCount(objects,values,capacity));
	}

	private static int findMinCount(int[] objects, int[] values, int capacity) {
		if(capacity == 0) return 0;
		//int count = 0;
		int[][] dp = new int[objects.length+1][capacity+1];
		for(int i=0;i<=objects.length;i++){
			for(int j=0;j<=capacity;j++){
				
			}
		}
		return dp[objects.length][capacity];
		
	}
	
}
