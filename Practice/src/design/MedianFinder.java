package design;

import java.util.Set;
import java.util.TreeSet;
class MedianFinder {
    Set<Integer> data;
    
    public MedianFinder() {
        data = new TreeSet<Integer>();
    }
    // Adds a number into the data structure.
    public void addNum(int num) {
        data.add(num);
    }

    // Returns the median of current data stream
    public double findMedian() {
        Object[] a = data.toArray();
        if(a.length % 2 == 1)
			return (double)a[a.length / 2];
		else {
			int mid1 = a.length / 2;
			int mid2 = mid1 - 1;
			return ((int)a[mid1] + (int)a[mid2]) / 2;
		}
    }
}

// Your MedianFinder object will be instantiated and called as such:
// MedianFinder mf = new MedianFinder();
// mf.addNum(1);
// mf.findMedian();