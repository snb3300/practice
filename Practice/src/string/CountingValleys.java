package string;

import java.util.Scanner;

public class CountingValleys {
	public static int getValleyCount(char[] steps) {
        boolean didValleyStart = false;

        int valleyCount = 0;
        int currentElavation = 0;
        
        for(int i = 0; i < steps.length; i++) {
            if(steps[i] == 'U')
                currentElavation += 1;
            else if(steps[i] == 'D')
                currentElavation -= 1;
                
            if(currentElavation < 0 && !didValleyStart) {
                didValleyStart = true;
                valleyCount += 1;
            }
            
            if(currentElavation >= 0)
                didValleyStart = false;
        }
        return valleyCount;
    }
    
    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner in = new Scanner(System.in);
        int n = new Integer(in.nextLine());
        String b = in.nextLine();
        in.close();
        System.out.println(getValleyCount(b.toCharArray()));
    }
}
