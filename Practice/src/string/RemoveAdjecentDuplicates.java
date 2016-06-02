package string;

public class RemoveAdjecentDuplicates {
	
	public static String remove(String input) {
		StringBuffer buff = new StringBuffer();
		int i = 1;
		buff.append(input.charAt(0));
		while(i < input.length()) {
			char current = buff.charAt(buff.length() - 1);
			
			if(input.charAt(i) == current && (i == input.length() - 1 || input.charAt(i + 1) != current)) {
				buff.deleteCharAt(buff.length() - 1);
			} else if (input.charAt(i) != current) {
				buff.append(input.charAt(i));
			}
			i++;
		}
		return buff.toString();
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(remove("azxxxza"));
	}

}
