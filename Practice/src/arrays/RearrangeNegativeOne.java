package arrays;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

public class RearrangeNegativeOne {

	public static void rearrange(int[] arr) {
		int count = 0;
		int firstNegativeIndex = -1;
		
		// runs in O(n)
		for(int i = 0; i < arr.length; i++) {
			if(arr[i] == -1) {
				if(firstNegativeIndex == -1)
					firstNegativeIndex = i;
				count += 1; 
			}
		}
		
		if (count == 0 || count == arr.length)
			return;
		
		int i = firstNegativeIndex;
		int j = i + 1;
		// runs in O(n)
		while(j < arr.length) {
			if(arr[j] != -1) {
				arr[i] = arr[j];
				i += 1;
			}
			j += 1;
		}
		
		// runs in O(n)
		for(i = arr.length - count; i < arr.length; i++)
			arr[i] = -1; 
		
		// total time complexity - 3 * O(n) ~ O(n)
	}
	
	
	public static int getDayIntValue(String day) {
		switch(day) {
			case "Sunday": return 4;
			case "Monday": return 5;
			case "Tuesday": return 6;
			case "Wednesday": return 7;
			case "Thursday": return 1;
			case "Friday": return 2;
			case "Saturday": return 3;
			default: return -1;
		}
	}

	public static String[] recurringTask(String firstDate, int k, String[] daysOfTheWeek, int n) {
		Calendar c = Calendar.getInstance();
		String[] date = firstDate.split("/");
		String[] result = new String[n];
		int startYear = Integer.parseInt(date[2]);
		int startMonth = Integer.parseInt(date[1]);
		int startDate = Integer.parseInt(date[0]);
		c.set(startYear, startMonth, startDate);
//		result[0] = firstDate;
		int resIndex = 0;
		int currDay = c.get(Calendar.DAY_OF_WEEK);
		int dayIndex = 0;
		boolean curr = true;
		while(dayIndex < daysOfTheWeek.length) {
			if(getDayIntValue(daysOfTheWeek[dayIndex]) == currDay)
				break;
			dayIndex += 1;
		}
		
		for(int i = 0; i < k; i++) {
			for(int j = dayIndex; j < daysOfTheWeek.length; j++) {
				if(resIndex == n)
					return result;
				if(curr) {
					result[resIndex++] = firstDate;
					curr = false;
					continue;
				}			
				currDay = Math.abs(getDayIntValue(daysOfTheWeek[j]) - currDay);
				c.add(Calendar.DAY_OF_MONTH, currDay);
				StringBuffer buff = new StringBuffer();
				buff.append(c.get(Calendar.DAY_OF_MONTH) + "/" + c.get(Calendar.MONTH) + "/" + c.get(Calendar.YEAR));
				result[resIndex++] = buff.toString();
			}
			dayIndex = 0;
		}
		return result;
	}

	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] a = {3,5,-1,2,-1,-11,1,-2,4};
//		int[] a = {1,0,-1};
//		rearrange(a);
//		for(int i = 0; i < a.length; i++)
//			System.out.print(a[i] + " ");
//		System.out.println();
		
		String d = "01/01/2015";
		String[] date = d.split("/");
//		System.out.println(date);
//		Calendar c = Calendar.getInstance();
//		int startYear = Integer.parseInt(date[2]);
//		int startMonth = Integer.parseInt(date[1]);
//		int startDate = Integer.parseInt(date[0]);
//		c.set(startYear, startMonth, startDate);
//		String[] days = {"Monday","Thursday"};
//		String[] res = recurringTask(d, 2, days, 4);
//		for(int i = 0; i < res.length; i++)
//			System.out.println(res[i]);
//		    System.out.println(c.get(Calendar.DAY_OF_MONTH));
//		    System.out.println(c.get(Calendar.DAY_OF_WEEK));
//		    System.out.println(c.get(Calendar.DATE));
		    
		System.out.println(Math.floor(2.4));    
		double[] departures = {2.4,1};
		double[] dest = {5,7.3};
		 
	 
				
				
	
		
		    
		    
		    
			
		
	}

}
