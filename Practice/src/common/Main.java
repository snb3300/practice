package common;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Main {

	Iterator<Double> getCustomIterator(Iterator<Double> it, Double filter) {
		return new MyIterator(it, filter);
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<Double> list = new ArrayList<>();
		double[] a = {1,2,2,2};
		for (double i : a) {
			list.add(i);
		}
		Iterator<Double> it = list.iterator();
		Iterator<Double> my = new MyIterator(it, (double)2);
//		while(my.hasNext()) {
//			System.out.println(my.next());
//		}
		System.out.println(my.hasNext());
		System.out.println(my.next());
		System.out.println(my.hasNext());
	}

}
