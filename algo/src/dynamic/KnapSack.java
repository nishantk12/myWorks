package dynamic;

public class KnapSack {
	public static void main(String[] args) {
		int[] objects = {2,3,8,10};
		int[] values = {1,6,2,30};
		int capacity = 11;
		System.out.println(findMinCount(objects,values,capacity));
	}

	private static int findMinCount(int[] objects, int[] values, int capacity) {
		if(capacity == 0) return 0;
		//int count = 0;
		int[][] dp = new int[objects.length+1][capacity+1];
		for(int i=1;i<=objects.length;i++){
			for(int j=1;j<=capacity;j++){
				if(j >= objects[i-1]){
					dp[i][j] = Math.max(dp[i-1][j], dp[i-1][j - objects[i-1]] + values[i-1]);
				}else{
					dp[i][j] = dp[i-1][j];
				}
				System.out.println("["+i+"]"+"["+j+"]"+";"+dp[i][j]);
			}
		}
		return dp[objects.length][capacity];
	}
	
}
