package leetCode;

public class countPrimes {
	public int countPrimes(int n) {
        if(n==0||n==1) return 0;
        int[] nums = new int[n];
        for(int i=1;i<nums.length;i++){
            nums[i] = 1;
        }
        
        int sqrtOfN = (int)Math.sqrt(n);
        for(int i=2;i<=sqrtOfN;){
            int temp = i*2;
            while(temp < n){
                nums[temp] = 0;
                temp += i;
            }
            i++;
            while(nums[i]==0){
                i++;
            }
        }
        int count = 0;
        for(int i=2;i<nums.length;i++){
            if(nums[i] ==1){
                count++;
            }
        }
        return count;
    }
}
