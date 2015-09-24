package leetCode;

public class PerfectSquares {
	public static void main(String[] args) {
		int num = calculateCount(43,'s');
		System.out.println(num);
	}

	private static int findMaxNumber(int num) {
		if(num == 0) return 0;
		int start = 1;
		int end = num;
		while(start <= end){
			int mid = start + (end-start)/2;
			if(Math.pow(mid, 2) == num){
				return mid;
			}else if(Math.pow(mid,2) > num){
				end = mid - 1;
			}else if(Math.pow(mid,2) < num){
				start = mid + 1;
			}
		}
		return start;
	}
	
	static int calculateCount(int num,char this_is_just_to_overload){
		if(num == 0) return 0;
		int count = 0;
		int min = Integer.MAX_VALUE;
		int max = findMaxNumber(num);
		for(int i=1;i<=max;i++){
			int temp = num;
			int max_temp = findMaxNumber(temp);
			while(max_temp > i){
				temp = temp - (int)Math.pow(i, 2);
				max_temp = findMaxNumber(temp);
				count += 1;
			}
			if(temp == 0){
				
			}else if(temp - Math.pow(max_temp, 2) == 0){
				count += 1;
			}else{
				while(temp > 0){
					max_temp = findMaxNumber(temp);
					if(temp == 0){
						
					}
					if(Math.pow(max_temp, 2) == temp){
						temp = 0;
						count += 1;
					}else{
						temp = temp - (int)Math.pow(max_temp-1, 2);
						count += 1;
					}
				}
			}
			System.out.println(i+";"+count);
			if(count < min) min = count;
			count = 0;
		}
		return min;
	}
	
	static int calculateCount(int num){
		if(num == 0) return 0;
		int temp = num;
		int count = 0;
		while(temp > 0){
			int max = findMaxNumber(temp);
			if(Math.pow(max, 2) == temp){
				temp = 0;
				count++;
			}else{
				temp = temp - (int)Math.pow(max-1, 2);
				count++;
			}
		}
		return count;
	}
	
	static int calculateCount(int num,int count){
		if(num == 0) return count + 0;
		else{
			int max = findMaxNumber(num);
			if(Math.pow(max,2) == num){
				return count + 1;
			}else{
				if(max == 2){
					return calculateCount(num-(int)Math.pow(max-1,2),count+1);
				}
				return Math.min(calculateCount(num-(int)Math.pow(max-1,2),count+1),calculateCount(num-(int)Math.pow(max-2,2),count+1));
			}
		}
	}
	
}
