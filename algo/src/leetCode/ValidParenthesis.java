package leetCode;

import java.util.Stack;

public class ValidParenthesis {
	public static Stack<Character> stk = new Stack<Character>();
	public static int[] memo = null;
	public static int maxLength = 0;
	public static void main(String[] args) {
		String input = "()(()()";
		memo = new int[input.length()];
		char[] arr = input.toCharArray();
		int maxLen = findLongestValid(arr,0,arr.length);
		System.out.println(maxLen);
	}

	private static int findLongestValid(char[] arr, int start, int end) {
		if(start >= end){
			return 0;
		}
		
		if(memo[start]!=0)
			return memo[start];
		
		int length = 0;
		
		for(int i=0;i<arr.length;i++){
			if(arr[i] == '('){
				if(stk.empty() && (length > maxLength))
					maxLength = length;
				stk.push(arr[i]);
				//length++;
			}else{
				if(stk.empty()){
					//length = 0;
					continue;
				}else if(stk.peek()=='('){
					length = length + 2;
					stk.pop();
					if(stk.empty() && maxLength < length){
						maxLength = length;
						//length=0;
					}
				}else{
					continue;
				}
			}
		}
		if(maxLength < length)
			return length;
		
		return maxLength;
		
	}
}