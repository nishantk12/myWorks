package leetCode;

public class addDigits {
	public static void main(String[] args) {
		int num = 19;
		int sum = findSumOfDigits(num);
		while(sum/10 != 0){
			sum = findSumOfDigits(sum);
		}
		System.out.println(sum);
	}
	
	public static int findSumOfDigits(int num){
        int sum = 0;
        int digit = 0;
        while(num/10 != 0){
            digit = num%10;
            sum += digit;
            num = num/10;
        }
        digit = num%10;
        sum += digit;
        return sum;
    }
}
