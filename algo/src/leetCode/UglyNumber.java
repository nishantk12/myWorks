package leetCode;

public class UglyNumber {
	public static void main(String[] args) {
		int num = -2147483648;
		int reminder = findLeftOut(num);
		if(reminder == 1){
			System.out.println("number is ugly");
		}else{
			System.out.println("number is pretty");
		}
	}

	private static int findLeftOut(int num) {
		if(num == 1){
			return 1;
		}
		if(num == 0){
		    return 0;
		}
		while(num%2 == 0){
			num = num/2;
		}
		while(num%3 == 0){
			num = num/3;
		}
		while(num%5 == 0){
			num = num/5;
		}
		return num;
	}

}
