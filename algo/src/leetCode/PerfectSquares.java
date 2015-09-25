package leetCode;

public class PerfectSquares {
	static int min = Integer.MAX_VALUE;
	public static void main(String[] args) {
		calculateCount(43,0);
		System.out.println(min);
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
	
	
	static void calculateCount(int num, int count){
		if(num == 0){
			if(count < min) min = count;
		}else{
			int max = findMaxNumber(num);
			for(int i=1;i<=max;i++){
				System.out.println("i"+i);
				int temp = num;
				int max_temp = max;
				while(max_temp > i){
					temp = temp - (int)Math.pow(i,2);
					max_temp = findMaxNumber(temp);
					count += 1;
				}
				if(temp - (int)Math.pow(max_temp, 2) == 0){
					count += 1;
					System.out.println(i+";"+count);
					if(count < min) min = count;
				}else{
					System.out.println("inside else" + temp);
					calculateCount(temp,count);
				}
				System.out.println("count0");
				count = 0;
			}
		}
		System.out.println("returning " + min);
		//return min;
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
	
	/*static int calculateCount(int num,int count){
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
	}*/
	
}
