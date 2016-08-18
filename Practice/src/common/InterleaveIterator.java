package common;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

public class InterleaveIterator<E> implements Iterator<E>{

	private List<Iterator<E>> iterators;
	private int currentIteratorIndex;
	
	
	public InterleaveIterator() {
		// TODO Auto-generated constructor stub
		this.iterators = new ArrayList<Iterator<E>>();
		this.currentIteratorIndex = 0;
	}
	
	
	public void addIterator(Iterator<E> iterator) {
		iterators.add(iterator);
	}
	
	@Override
	public boolean hasNext() {
		// TODO Auto-generated method stub
		int startIndex = currentIteratorIndex;
		do {
			Iterator<E> it = iterators.get(currentIteratorIndex);
			if(it.hasNext())
				return true;
			currentIteratorIndex = (currentIteratorIndex + 1) % iterators.size();
		} while(currentIteratorIndex != startIndex);
		return false;
	}

	@Override
	public E next() {
		// TODO Auto-generated method stub
		E ret = null;
		while(hasNext()) {
			Iterator<E> it = iterators.get(currentIteratorIndex);
			ret = it.next();
			currentIteratorIndex = (currentIteratorIndex + 1) % iterators.size();
			if(ret != null)
				break;
		}
		return ret;
	}
	
	
	public static void main(String[] args) {
		List<Integer> i = new ArrayList<>();
		List<Double> d = new ArrayList<>();
		List<String> s = new ArrayList<>();
		
		i.add(1);
		i.add(2);
		i.add(3);
		
		d.add(10.0);
		d.add(20.0);
		d.add(30.0);
		d.add(40.0);
		
		s.add("abc");
		s.add("pqr");
		
		InterleaveIterator it = new InterleaveIterator();
		it.addIterator(i.iterator());
		it.addIterator(d.iterator());
		it.addIterator(s.iterator());
		
		while(it.hasNext()) {
			System.out.println(it.next());
		}
	}
}
