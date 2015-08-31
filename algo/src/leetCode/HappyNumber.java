package leetCode;

public class HappyNumber {
	public static void main(String[] args) {
		int num = 32;
		int sum = findSumDigitsSquared(num);
		while(sum/10!=0){
			sum = findSumDigitsSquared(sum);
		}
		if(sum==1){
			System.out.println("number is happy");
		}else{
			System.out.println("number is sad");
		}
	}

		private static int findSumDigitsSquared(int num) {
			int sum = 0;
			int digit = 0;
			while(num/10 != 0){
				digit = num%10;
				sum += Math.pow(digit, 2);
				num = num/10;
			}
			digit = num%10;
			sum += Math.pow(digit, 2);
			return sum;
		}
}
