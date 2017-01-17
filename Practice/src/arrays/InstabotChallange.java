package arrays;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

class TimeFrame implements Comparable<TimeFrame> {

	String startTime;
	long startTimeNumber;
	String endTime;
	long endTimeNumber;
	long timeDiff;
	int leadTime;
	
	public TimeFrame(String startTime, String endTime, int leadTime) throws ParseException {
		this.startTime = startTime;
		this.endTime = endTime;
		if (leadTime != -1)
			this.leadTime = leadTime * 60000;
		else
			this.leadTime = -1;
		SimpleDateFormat sdf = new SimpleDateFormat("hh:mm");
		this.startTimeNumber = sdf.parse(startTime).getTime();
		this.endTimeNumber = sdf.parse(endTime).getTime();
		this.timeDiff = this.endTimeNumber - this.startTimeNumber; 
	}
	
	@Override
	public int compareTo(TimeFrame o) {
		// TODO Auto-generated method stub
		return (int) (this.timeDiff - o.timeDiff);
	}
	
	public String toString() {
		return this.startTime + ":" + this.endTime + " " + this.leadTime;
	}
}

public class InstabotChallange {

	private boolean busyHolidays(String[][] shoppers, String[][] orders, int[] leadTime) {
		List<TimeFrame> orderTimeFrames = new ArrayList<>();
		List<TimeFrame> shopperTimeFrames = new ArrayList<>();
		boolean[] shopperStatus = new boolean[shoppers.length];
		Arrays.fill(shopperStatus, false);
		for(int i = 0; i < shoppers.length; i++) {
			try {
				shopperTimeFrames.add(new TimeFrame(shoppers[i][0], shoppers[i][1], -1));
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				return false;
			}
		}
		
		for(int i = 0; i < orders.length; i++) {
			try {
				orderTimeFrames.add(new TimeFrame(orders[i][0], orders[i][1], leadTime[i]));
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		Collections.sort(orderTimeFrames);
		Collections.sort(shopperTimeFrames, Collections.reverseOrder());
//		Collections.sort(shopperTimeFrames);
		
		for(TimeFrame order : orderTimeFrames) {
			boolean currentOrderStatus = false;
			for(int i = 0; i < shopperTimeFrames.size(); i++) {
				TimeFrame shopper = shopperTimeFrames.get(i);
				if(shopperStatus[i] ||(shopper.timeDiff < order.leadTime) || (order.endTimeNumber < shopper.startTimeNumber) 
						|| (order.startTimeNumber + order.leadTime > shopper.endTimeNumber))
					continue;
				shopperStatus[i] = true;
				currentOrderStatus = true;
				break;
			}
			if (!currentOrderStatus)
				return false;
		}
		
		return true;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		InstabotChallange ic = new InstabotChallange();
		String[][] shoppers = {{"01:00","02:00"},{"01:01","01:30"}};
		String[][] orders = {{"01:00","02:00"}, {"01:11","02:00"}};
		int[] leadTime = {20,20};
//		String[][] shoppers = {{"15:10","16:00"},{"17:50","22:30"}, {"13:00", "14:40"}};
//		String[][] orders = {{"14:30","15:00"}};
//		int[] leadTime = {15};
//		String[][] shoppers = {{"23:00","23:59"},{"22:30","23:30"}};
//		String[][] orders = {{"23:15","23:35"}, {"23:00","23:31"}};
//		int[] leadTime = {20,20};
		System.out.println(ic.busyHolidays(shoppers, orders, leadTime));
	}

}
