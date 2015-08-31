package leetCode;

public class HarvestWater {
	public static void main(String[] args) {
		int[] nums = {0,2,0};
		int amountOfWater =  findWaterAmount(nums);
		System.out.println(amountOfWater);
	}

	private static int findWaterAmount(int[] nums) {
		int totalAmount = 0;
		if(nums==null || nums.length <= 1){
			return 0;
		}
		int firstPillar = nums[0];
		int secondPillar = nums[0];
		int highestPillarFound = 0;
		int indexOfHighestPillarFound = 0;
		int indexOfSecondPillar = 0;
		int start = 0;
		int j=0;
		int foundHigherPillar=0;
		while(nums[start] == 0){
			start++;
		}
		//System.out.println(start);
		for(int i=start;i<nums.length-1;){
			firstPillar = nums[i];
			//System.out.println("firts pillar" + firstPillar);
			secondPillar = nums[i+1];
			indexOfSecondPillar = i+1;
			highestPillarFound = 0;
			indexOfHighestPillarFound = i+1;
			start=i+1;
			while(start<nums.length){
				secondPillar = nums[start];
				indexOfSecondPillar = start;
				
				if(secondPillar < firstPillar){
					if(nums[start] > highestPillarFound){
						highestPillarFound = nums[start];
						indexOfHighestPillarFound = start;
					}
					
					start++;
				}else{
					
					foundHigherPillar=1;
					break;
				}
			}
			
			if(foundHigherPillar == 1){
				//System.out.println("found higher pillar");
				j=i+1;
				while(j<indexOfSecondPillar){
					if(nums[j] < firstPillar){
						totalAmount +=firstPillar-nums[j];
					}
					j++;
				}
				i = indexOfSecondPillar;
			}
			
			if(start >= nums.length){
				//System.out.println("going down");
				j = i+1;
				while(j<indexOfHighestPillarFound){
					if(nums[j] < highestPillarFound){
						totalAmount += (highestPillarFound - nums[j]);
					}
					j++;
				}
				i=indexOfHighestPillarFound;
			}
			//System.out.println("i is " + i);
			foundHigherPillar=0;
		}
		return totalAmount;
	}
}









































/*
			firstPillar = nums[i];
			highestPillarFound = 0;
			secondPillar = nums[i+1];
			indexOfHighestPillarFound = i;
			indexOfSecondPillar = i+1;
			int j = i+1;
			while(j<nums.length){
				if(secondPillar < firstPillar){
					secondPillar = nums[j];
					indexOfSecondPillar = j;
					if(highestPillarFound < nums[j]){
						highestPillarFound = nums[j];
						indexOfHighestPillarFound = j;
					}
				}else{
					break;
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
*/