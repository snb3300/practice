package arrays;

public class TwoRepeatingInArray {

	public static void findRepeating(int[] a, int n) {
		int xor = a[0];
		int x = 0;
		int y = 0;
		int set_bit_no = 0;
		
		for(int i = 1; i < a.length; i++)
			xor ^= a[i];
		for(int i = 1; i <= n; i++)
			xor ^= i;
		
		set_bit_no = xor & ~(xor-1);
		for(int i = 0; i < a.length; i++) {
			if((a[i] & set_bit_no) == a[i])
				x ^= a[i];
			else
				y ^= a[i];
		}
		for(int i = 1; i <= n; i++) {
			if((i & set_bit_no) == a[i])
				x ^= i;
			else
				y ^= i;
		}
		System.out.println("Two numbers : " + x + "," + y);
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] a = {1,2,2,3,4,4,5};
		findRepeating(a, 5);
	}

}
