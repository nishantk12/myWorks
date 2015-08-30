package leetCode;
import java.util.Arrays;

public class ProductExceptSelf {
	public static void main(String[] args) {
		int[] nums = {0,1,2,3};
		int[] returnArray = findProductArray(nums);
		System.out.println(Arrays.toString(returnArray));
	}
	
	public static int[] findProductArray(int[] nums){
        int[] arr = new int[nums.length];
        int product = 1;
        int hasZero = 0;
        int multipleZeros = 0;
        for(int i=0;i<nums.length;i++){
            if(nums[i] != 0){
                product = product * nums[i];
            }else{
                if(hasZero==0)
                    hasZero = 1;
                else
                    multipleZeros = 1;
            }
        }
        
        for(int i=0;i<nums.length;i++){
            if(multipleZeros == 1){
                arr[i] = 0;
            }else if(hasZero == 1 && nums[i] == 0){
                arr[i] = product;
            }else if(hasZero == 1){
                arr[i] = 0;
            }else{
                arr[i] = product/nums[i];
            }
        }
        
        return arr;
        
    }
}
