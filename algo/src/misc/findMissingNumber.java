package misc;

public class findMissingNumber {
	public static void main(String[] args) {
		int[] arr = {1,2,3,4,5,6,7};
		int missing = findMissingNumberinArr(arr);
		System.out.println(missing);
	}

	private static int findMissingNumberinArr(int[] arr) {
		if(arr==null){
			return -999;
		}
		if(arr.length <= 1){
			return -998;
		}
		int back = 0;
		int forw = 1;
		int flag = 0;
		while(forw < arr.length){
			if(arr[forw] - arr[back] == 1){
				forw++;
				back++;
			}else{
				flag=1;
				break;
			}
		}
		
		if(flag ==1)
			return arr[back] + 1;
		else
			return -997;
	}
	
}
