package leetCode;

public class VersionCOntrol {
	static int num = 2126753390;
	static int bad = 1702766719;
	public static void main(String[] args) {
		//Integer.parseInt("9646324351");//9646324351///1534236469
		//int test = 9646324351;
		System.out.println(Integer.MAX_VALUE);
		System.out.println(firstBadVersion(1,num));
	}
	
	private static int firstBadVersion(int start,int end) {
		int center = start;
        while(end >= start){
            if(isBadVersion(start))
                return start;
            center = start + (end - start)/2;     // this the line you must use and not center = (start + end) /2; 
            									// it crosses the int range limit
            if(isBadVersion(center)){
                end = center - 1;
            }else{
                start = center + 1;
            }
        }
        return start;
	}

	private static boolean isBadVersion(int start) {
		if(start >= bad)
			return true;
		else
			return false;
	}

}
