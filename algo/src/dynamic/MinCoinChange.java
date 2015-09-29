package dynamic;

public class MinCoinChange {
	public static void main(String[] args) {
		 int[] coins = {10,20,30};
		 int amount = 50;
		 System.out.println(numberOfCoins(coins, amount,0));
	}
	
	public static int numberOfCoins(int[] coins, int amount,int count){
		if(amount <=  0) return count;
		int min = Integer.MAX_VALUE;
		for(int i=0;i<coins.length;i++){
			if(coins[i] <= amount){
				min = Math.min(min,numberOfCoins(coins, amount-coins[i], count+1));
			}
		}
		return min;
	}
}
