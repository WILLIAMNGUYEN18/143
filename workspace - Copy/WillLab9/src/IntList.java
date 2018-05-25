
// Represents a list of integers. 
public interface IntList {     
	public void add(int value);     
	public void add(int index, int value);     
	public int get(int index);     
	public int indexOf(int value);     
	public boolean isEmpty();     
	public void remove(int index);     
	public void set(int index, int value);     
	public int size();     
	public void clear();     
	public String toString();     
	public void addSorted(int value);            
	//removes all elements of this.list that match Otherlist     
	public void removeAll(IntList Otherlist);           
	//removes all elements from this.list that are not included in Otherlist     
	public void retainAll(IntList Otherlist); 
	 
}
