package string;

public class SuperReduedString {

	public static StringBuilder reduce(StringBuilder buff) {
		if(buff.length() == 0 || buff.length() == 1)
			return buff;
		
		// remove adjacent duplicates in the beginning
		while(buff.length() > 1) {
			if(buff.charAt(0) != buff.charAt(1))
				break;
			buff.delete(0, 2);
		}
		
		if(buff.length() > 0) {
			char prev = buff.charAt(0);
			buff.delete(0, 1);
			buff = reduce(buff);
			if(buff.length() > 0 && prev == buff.charAt(0)) {
				buff.delete(0, 1);
			}
			else {
				buff.insert(0, prev);
			}
		}
		return buff;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String res = "";
		
		res = res.isEmpty() ? "Empty String" : res;
		System.out.println("1. " + reduce(new StringBuilder("aaabccddd")).toString());
		System.out.println("2. " + reduce(new StringBuilder("baab")).toString());
		System.out.println("3. " + reduce(new StringBuilder("aa")).toString());
		System.out.println("4. " + reduce(new StringBuilder("bbbabbbab")).toString());
	}

}
