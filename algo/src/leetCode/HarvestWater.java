package leetCode;

public class HarvestWater {
	public static void main(String[] args) {
		int[] nums = {0,1,0,2};
		int amountOfWater =  findWaterAmount(nums);
		System.out.println(amountOfWater);
	}

	private static int findWaterAmount(int[] nums) {
		int totalAmount = 0;
		int firstPillar = nums[0];
		int secondPillar = nums[0];
		int highestPillarFound = 0;
		int indexOfHighestPillarFound = 0;
		int indexOfSecondPillar = 0;
		for(int i=0;i<nums.length;i++){
			firstPillar = nums[i];
			highestPillarFound = 0;
			indexOfHighestPillarFound = i;
			indexOfSecondPillar = i;
			int j = i+1;
			while(j<nums.length && secondPillar >= firstPillar){
				secondPillar = nums[j];
				indexOfSecondPillar = j;
				if(highestPillarFound < nums[j]){
					highestPillarFound = nums[j];
					indexOfHighestPillarFound = j;
				}
				j++;
			}
			if(j >= nums.length){
				secondPillar = highestPillarFound;
				j = i+1;
				while(j < nums.length && j != indexOfHighestPillarFound){
					totalAmount = totalAmount + (nums[j] - highestPillarFound);
					j++;
				}
				i = indexOfHighestPillarFound + 1;
			}else{
				j = i+1;
				while(j < nums.length && j!=indexOfSecondPillar){
					totalAmount = totalAmount + (nums[j] - secondPillar);
					j++;
				}
				i = indexOfSecondPillar +1;
			}
		}
		return totalAmount;
	}
}
