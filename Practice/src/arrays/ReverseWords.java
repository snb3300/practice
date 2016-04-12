package arrays;

public class ReverseWords {

	public static String reverseWords(String s) {
		s = s.trim();
		StringBuffer buffer = new StringBuffer();
		String[] subStrs = s.split(" ");
		for (int i = subStrs.length - 1; i >= 0; i--) {
			String s1 = subStrs[i]; 
			if(!s1.isEmpty() && !s1.equals(" ")){
				buffer.append(s1.trim());
				buffer.append(" ");
			}
		}
		if(buffer.length() > 0)
			buffer.deleteCharAt(buffer.length()-1);
		return buffer.toString().trim();
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(reverseWords("a   b"));
//		System.out.println(("s1".equals(" ")));
	}

}
