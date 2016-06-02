package arrays;

public class MaximumSumNoAdjecent {

	public static int maxSum(int[] a) {
		int incl = a[0];
		int excl = 0;
		int excl_new;
		for(int i = 1; i < a.length; i++) {
			excl_new = (incl > excl) ? incl : excl;
			incl = excl + a[i];
			excl = excl_new;
		}
		return (incl > excl) ? incl : excl;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] a =  {5,  5, 10, 40, 50, 35};
		System.out.println(maxSum(a));
	}

}
