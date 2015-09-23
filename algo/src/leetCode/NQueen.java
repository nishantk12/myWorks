package leetCode;

import java.util.ArrayList;
import java.util.List;

public class NQueen {
	static List<List<String>> sols = new ArrayList<List<String>>();
	
	public static void main(String[] args) {
		solveNQueens(6);
		System.out.println(sols.size());
	}
	
	public static List<List<String>> solveNQueens(int n) {
        boolean[][] arr = new boolean[n][n];
        isSolution(arr,0);
        return sols;
    }
    
    public static boolean isSolution(boolean[][] arr, int col){
        int length = arr[0].length;
        if(col >= length){
            return true;
        }
        
        for(int i=0;i<arr.length;i++){
            if(isSafe(arr,i,col)){
            	System.out.println(isSafe(arr,i,col) + ";" + i +";" + col);
                arr[i][col] = true;
                if(isSolution(arr,col+1)){
                    addSolution(arr);
                    arr[i][col] = false;
                }else{
                    arr[i][col] = false;
                }
            }
        }
        return false;
    }
    
    public static boolean isSafe(boolean[][] arr, int row, int col){
    	//System.out.println(row+";"+col);
    	//System.out.println("arr[2][1]:"+arr[2][1]);
        int diff = col;
        int n = arr.length;
        for(int i=0;i<arr.length;i++){
            if(arr[row][i] == true || arr[i][col] == true){
                return false;
            }
            if((row - n/2 + i) >= 0 && (row - n/2 + i) < n && (col - n/2 + i) >= 0 && (col - n/2 + i) < n){
            	if(arr[row-n/2+i][col - n/2 + i]==true) return false;
            }
            if((row + n/2 - i) >= 0 && (row + n/2 - i) < n && (col - n/2 + i) >= 0 && (col - n/2 + i) < n){
            	if(arr[row+n/2-i][col - n/2 + i]==true) return false;
            }
        }
        return true;
    }
    
    public static void addSolution(boolean[][] arr){
        List<String> sol = new ArrayList<String>();
         for(int i = 0;i<arr.length;i++){
             String row = "";
            for(int j = 0;j<arr[0].length;j++){
                if(arr[i][j] == true){
                    row += "Q";
                }else{
                    row += ".";
                }
            }
            System.out.println(row);
            sol.add(row);
        }
        sols.add(sol);
    }
}
