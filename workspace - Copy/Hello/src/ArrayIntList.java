
public class ArrayIntList {
private int[] theArray;
private int[] secondArray;
private int size = 0;
	public ArrayIntList(){
		this(10);
	}
	public ArrayIntList(int capacity){
		//size = s;
		theArray = new int[capacity];
	}
	public void add(int value){
		checkCapacity();
		theArray[size] = value;
		size++;
	}
	private void checkCapacity(){
		//System.out.println(size());
		//System.out.println(theArray.length);
		if(size() >= theArray.length){
			secondArray = new int[theArray.length * 2];
			for(int i = 0; i < size; i++){
				secondArray[i] = theArray[i];
				
			}
			size++;
			theArray = secondArray;
		}
	}
	public void add(int index,int  value){
		/*
		for(int i = index+1; i <= size; i++){
			theArray[i] = theArray[i+1];
		}
		*/
		checkCapacity();
		for(int i = size; i > index; i--){
			theArray[i] = theArray[i-1];
		}
		theArray[index] = value;
		size++;
	}
	public int get(int index){
		checkCapacity();
		if(index >= size || index <0){
			throw new IndexOutOfBoundsException();
		}
		else{
		return theArray[index];
		}
	}
	public int size(){
		return this.size;
	}
	public boolean isEmpty(){
		return size == 0;
	}
	public int indexOf(int value){
		int store = -1;
		for(int i = 0; i < size; i++){
			if(theArray[i] == value){
				return i;
			}
		}
		return store;
	}
	public boolean contains(int value){
		if(indexOf(value) == -1){
			return false;
		}
		else{
			return true;
		}
	}
	/**
	 * Precondition:0 <= index < size
	 * Postcondition:index in array is removed
	@return element at given index
	remove the value at the specified index
	@param 0 <= index < size
	*/
	public int remove(int index){
		checkCapacity();
		if(index >= size || index <0){
			throw new IndexOutOfBoundsException();
		}
		else{
		int store = theArray[index];
		for(int i = index; i < size; i++){
			theArray[i] = theArray[i+1];
		}
		size--;
		theArray[size] = 0;
		return store;
		}
	}
	/**
	*
	*
	*@param text   0 <= index < size
	*/
	public void set(int index, int value){
		checkCapacity();
		if(index >= size || index <0){
			throw new IndexOutOfBoundsException();
		}
		else{
			theArray[index] = value;
		}
	}
	public String toString(){
		String store = "[";
		if(size == 0){
			return "[]";
		}
		store += theArray[0] + "";
		for(int i = 1; i < size; i++){
			store += ", " + theArray[i];
		}
		store += "]";
			return store;
	}
}
