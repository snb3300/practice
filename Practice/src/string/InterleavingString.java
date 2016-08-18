package string;

public class InterleavingString {
	
	public static void printILSUtil(String s1, String s2, StringBuffer buffer) {
		if(s1.length() == 0 && s2.length() == 0) {
			System.out.println(buffer.toString());
		}
		
		if(s1.length() != 0) {
			buffer.append(s1.charAt(0));
			printILSUtil(s1.substring(1), s2, buffer);
			buffer.deleteCharAt(buffer.length() - 1);
		}
		
		if(s2.length() != 0) {
			buffer.append(s2.charAt(0));
			printILSUtil(s1, s2.substring(1), buffer);
			buffer.deleteCharAt(buffer.length() - 1);
		}
	}
	
	public static void printILS(String s1, String s2) {
		StringBuffer buffer = new StringBuffer();
		printILSUtil(s1, s2, buffer);
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		printILS("hey", "sam");
	}

}
