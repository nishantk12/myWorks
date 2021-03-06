package leetCode;

public class ClimbStairs {
	static int[] memo = null;
	public static void main(String[] args) {
		int numberOfstairs = 44;
		memo = new int[numberOfstairs+1];
		//initializeMemo();    //Commenting this line, made this solution to be 99 %ile from 67%ile
		int numberOfWays = findNumberOfWays(numberOfstairs);
		System.out.println(numberOfWays);
	}

	@SuppressWarnings("unused")
	private static void initializeMemo() {
		for(int i=0;i<memo.length;i++){
			memo[i] = -1;
		}
	}

	private static int findNumberOfWays(int numberOfstairs) {
		if(memo[numberOfstairs] == 0){
			if(numberOfstairs <= 1)
				memo[numberOfstairs] = 1;
			else
				memo[numberOfstairs] = findNumberOfWays(numberOfstairs -1) + findNumberOfWays(numberOfstairs -2);
		}
		
		return memo[numberOfstairs];
	}
	
	
}
