package leetCode;

public class TrailingZeros {
	public static void main(String[] args) {
		int n = 2147483647;
		int numOfZeros = 0;
        int power = 1;
        while(n/Math.pow(5,power) >= 1){
            numOfZeros = numOfZeros + n/(int)Math.pow(5,power);
            System.out.println(power +";" + numOfZeros + ";" + n/Math.pow(5,power));
            power++;
        }
        System.out.println(numOfZeros);
	}
}
