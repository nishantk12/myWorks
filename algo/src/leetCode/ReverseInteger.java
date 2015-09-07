package leetCode;

public class ReverseInteger {
	public static void main(String[] args) {
		int x = 78877;
		 if(x/10 == 0)
	            System.out.println(x);
	        else
	            System.out.println(reveseString(x));
	}
	
	public static int reveseString(int x){
        String rev = "";
        if(x < 0){
            rev = "-" + rev;
        }
        int num = (int)Math.abs(x);
        while(num != 0){
            int digit = num%10;
            rev = rev + String.valueOf(digit);
            num = num/10;
        }
        try{
            int returnRev = Integer.parseInt(rev);
            return returnRev;
        }catch(Exception e){
            return 0;
        }
    }

}
