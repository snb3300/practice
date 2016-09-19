package string;

public class RemoveAdjacentDuplicates {
	
	public static StringBuffer removeUtil(StringBuffer buff) {
		if(buff.length() <= 1)
			return buff;
		
		boolean repeated = false;
		while(buff.length() > 0 && buff.charAt(1) == buff.charAt(0)) {
			repeated = true;
			buff.deleteCharAt(0);
		}
		if(repeated) {
			buff.deleteCharAt(0);
			repeated = false;
		}
		char lastChar = buff.charAt(0);
		StringBuffer rem = removeUtil(new StringBuffer(buff.substring(1)));
		
		while(rem.length() > 0 && rem.charAt(0) == lastChar) {
			repeated = true;
			rem.deleteCharAt(0);
		}
		
		if(!repeated) {
			rem.insert(0, lastChar);
		}
		return rem;
	}
	
	public static String removeDuplicates(String input) {
		return removeUtil(new StringBuffer(input)).toString();
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		System.out.println(remove("azxxxza"));
		String s = "acazxxxzacax";
//		List<Character> buff = new ArrayList<>();
//		
//		for(char c : s.toCharArray()) {
//			buff.add(c);
//		}
//		System.out.println(removeUtil(buff, '\0'));
		System.out.println(removeDuplicates(s));
	}

}
