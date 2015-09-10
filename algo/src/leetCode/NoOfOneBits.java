package leetCode;

public class NoOfOneBits {
	public static void main(String[] args) {
		long n = new Long(4294967295L);
		if(n==0) System.out.println(0);
	       long count = 0;
	       while(n/2!=0){
	           count =  (count + n%2);
	           n=n/2;           
	       }
	       count++;
	    System.out.println(count);
	}
	//4294967295
}
