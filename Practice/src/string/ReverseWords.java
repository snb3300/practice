package string;

import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class ReverseWords {

	public static String reverse(String input) {
		StringBuffer output = new StringBuffer();
		StringBuffer current = new StringBuffer();
		for(int i = input.length() - 1; i >= 0; i--) {
			if(input.charAt(i) == ' ') {
				output.append(current.reverse().toString() + " ");
				current = new StringBuffer();
			} else {
				current.append(input.charAt(i));
			}
		}
		output.append(current.reverse().toString());
		return output.toString();
	}
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		String inFile = "/Users/sbhalekar/Downloads/B-large-practice.in";
		String outFile = "/Users/sbhalekar/Downloads/output";
		FileReader fr;
		FileWriter fw;
		Scanner in;
		BufferedWriter brw;
			fr = new FileReader(inFile);
			fw = new FileWriter(outFile);
			in = new Scanner(fr);
			brw = new BufferedWriter(fw);
			Integer n = Integer.parseInt(in.nextLine());
	        for(int i = 1; i <= n; i++) {
	        	String input = in.nextLine();
	        	fw.write("Case #" + i + ": " + reverse(input) + "\n");
	        }
	        brw.close();
			in.close();
			fw.close();
			fr.close();
		
	}

}
