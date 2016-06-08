package multithreading;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectInputStream;
import java.io.ObjectOutput;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public class Singleton implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private Singleton() {}
	
	private static class SingletonHelper {
		private static final Singleton instance = new Singleton();
	}
	
	public static Singleton getInstance() {
		return SingletonHelper.instance;
	}
	
	protected Object readResolve() {
		return getInstance();	
	}
	
	public static void main(String[] args) throws FileNotFoundException, IOException, ClassNotFoundException {
		Singleton i1 = Singleton.getInstance();
		ObjectOutput out = new ObjectOutputStream(new FileOutputStream("/tmp/f1.ser"));
		out.writeObject(i1);
		out.close();
		
		ObjectInput in = new ObjectInputStream(new FileInputStream("/tmp/f1.ser"));
		Singleton i2 = (Singleton) in.readObject();
		in.close();
		
		System.out.println("i1 = " + i1.hashCode());
		System.out.println("i1 = " + i2.hashCode());
		
		System.out.println(i1 == i2);
	}

}
