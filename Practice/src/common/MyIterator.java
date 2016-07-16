package common;

import java.util.Iterator;

public class MyIterator implements Iterator<Double>{

	private Double filter;
	private Iterator<Double> it;
	private Double next;
	
	public MyIterator(Iterator<Double> it, Double filter) {
		this.filter = filter;
		this.it = it;
		this.next = null;
	}

	private void peekNext() {
		this.next = null;
		while(it.hasNext()) {
			Double x = it.next();
			if(!x.equals(this.filter)) {
				next = x;
				break; 
			}
		}
	}
	
	@Override
	public boolean hasNext() {
		// TODO Auto-generated method stub
		if(next == null) {
			this.peekNext();
		}
		return next == null ? false : true;
	}

	@Override
	public Double next() {
		// TODO Auto-generated method stub
		if(this.hasNext()) {
			Double d = this.next;
			this.peekNext();
			return d;
		}
		return null;
	}
}
