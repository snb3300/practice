package string;

public class RemoveSpaces {
	
	public static String removeSpaces(String input) {
		StringBuffer buff = new StringBuffer();
		int i = 0;
		while(i < input.length()) {
			if(input.charAt(i) != ' ') {
				buff.append(input.charAt(i));
			}
			i += 1;
		}
		return buff.toString();
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(removeSpaces("g   eeks    for ge  eks   "));
	}

}
