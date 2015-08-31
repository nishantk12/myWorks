package leetCode;

public class largestSquareOfOnes {
	static int[][] memo = null;
	public static void main(String[] args) {
		char[][] input = {{}};//{{0,1,1},{0,1,1},{0,0,0}};//{{0,1,1,0},{0,1,1,0},{0,0,0,0},{0,0,0,0}};//
		if(input == null || input.length == 0){
            System.out.println(0);
        	return;
		}
		
		if(input.length > 0 && input[0].length == 0){
            System.out.println(0);
        	return;
		}
		
		memo = new int[input.length][input[0].length];
		int largestSize = findBiggestSquare(input,0,0,0);
		System.out.println(largestSize);
	}

	private static int findBiggestSquare(char[][] input, int side, int i, int j) {
		
		if(i > input.length || j > input[0].length)
			return side;
		
		if(i + side >= input.length || j + side >= input[0].length)
			return side;
		
		int count = 0;
		for(int k=j;k<j+side+1;k++){
			if(input[i+side][k] == 1){
				count++;
			}
		}
		for(int k=i;k<i+side+1;k++){
			if(input[k][j+side] == 1){
				count++;
			}
		}
		
		count--;
		//System.out.println(count);
		if(count == ((2*side) +1)){
			
			return Math.max(findBiggestSquare(input,side+1,i,j),Math.max(findBiggestSquare(input,side,i+1,j),
					Math.max(findBiggestSquare(input,side,i,j+1),findBiggestSquare(input,side,i+1,j+1))));
		}else{
			return Math.max(findBiggestSquare(input,side,i+1,j),
					Math.max(findBiggestSquare(input,side,i,j+1),findBiggestSquare(input,side,i+1,j+1)));
		}
	}

}
