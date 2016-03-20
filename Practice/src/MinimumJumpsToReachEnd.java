import java.util.Arrays;

public class MinimumJumpsToReachEnd {

	public static int getMinJumps(int[] a) {
		int minJumps = Integer.MAX_VALUE;
		int[] minJumpArray = new int[a.length];
		Arrays.fill(minJumpArray, Integer.MAX_VALUE);
		if(a.length > 0) {
			minJumpArray[0] = 0;
			for(int i = 0; i < a.length - 1; i++) {
				int limit = a[i];
				int j = i+1;
				while(limit>0 && j < a.length) {
					minJumpArray[j] = Integer.min(minJumpArray[j], minJumpArray[i] + 1);
					limit -= 1;
					j += 1;
				}
			}
			minJumps = minJumpArray[a.length-1];
		}
		return minJumps;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		int[] a = {1, 3, 5, 8, 9, 2, 6, 7, 6, 8, 9};
		int[] a = {1,1,1,1,1};
		System.out.println(getMinJumps(a));
	}

}
