package leetCode;

public class NoOfOneBits {
	public static void main(String[] args) {
		//int n = 16;
		Long n = 2147483648L;
		if(n==0) System.out.println(0);
	       long count = 0;
	       //long num = n & 0xffffffffL;
	       while(n/2!=0){
	           count =  (count + n%2);
	           n=n/2;           
	       }
	       if(n==1){
	    	   count++;
	       }
	    System.out.println(count);
	}
	//4294967295
	//2147483648
}
