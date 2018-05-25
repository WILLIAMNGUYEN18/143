
public class ArrayPractice<T> {
	private T[] data;
	private int size;
	
	
	/*
	 * 
	public void set(T t) 
		{ this.t = t; }
    
    public T get() 
    	{ return t; }
    */
	
	public void removeFront(int n) {
		
		//workaround T[] ts = new T[n];
		//workaround T[] ts = (T[]) new Object[n];
		//this.data = new T[];
		T[] store = (T[]) new Object[n];
		for(int i = n-1; i< this.data.length; i++) {
			store[i - n] = this.data[i];
		}
		this.data = store;
	}
	
	public void removeAll(T item) {
	
		for(int i = 0; i < this.data.length; i++) {
			if(this.data[i].equals(item)) {
				//remove(i);
				//
			}
			
		}
		
	}
	
	public void stretch(int n) {
		T[] store = (T[]) new Object[n * this.data.length];
		
		for(int i = 0; i< this.data.length; i++) {
			for(int j = 0; j < n; j++) {
				store[i + j] = this.data[i];
			}
		}
	}

}
