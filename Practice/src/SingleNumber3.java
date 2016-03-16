import java.util.HashMap;
import java.util.Map;

public class SingleNumber3 {
	
	public static int[] singleNumber2(int[] nums) {  
        int A = 0;  
        int B = 0;  
        int AXORB = 0;  
        for(int i = 0; i<nums.length; i++){  
            AXORB ^= nums[i];  
        }  
          
        AXORB = (AXORB & (AXORB - 1)) ^ AXORB; //find the different bit  
        for(int i = 0; i<nums.length; i++){  
            if((AXORB & nums[i]) == 0)  
                A ^= nums[i];  
            else  
                B ^= nums[i];  
        }  
        return new int[]{A, B};  
    }
	
	public static int[] singleNumber(int[] nums) {
 		Map<Integer, Integer> duplicateNumbers = new HashMap<>();
 		int[] result = new int[2];
 		for (int i : nums) {
 			Integer x = duplicateNumbers.get(i);
			if (x == null) {
				duplicateNumbers.put(i, 1);
			} else {
				duplicateNumbers.put(i, x+1);
			}
		}
 		
 		int resultIndex = 0;
 		for (int i : nums) {
			if (duplicateNumbers.get(i) == 1) {
				result[resultIndex++] = i; 
			}
			if(resultIndex > 1)
				break;
		}
 		return result;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] result;
		int[] input = {3,2,3,5,4,5};
		result = singleNumber(input);
		System.out.println(result[0] + " " + result[1]);
	}

}
