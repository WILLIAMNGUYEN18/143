import java.util.*;
public class Person {
	private boolean free;
	private String name;
	private String partner;
	private boolean man;
	private LinkedList<Integer> choices;
	private int pos;
	
	public Person(boolean fre, String names, boolean male, LinkedList<Integer> choice, int position){
		this.free = fre;
		this.name = names;
		this.man = male;
		this.choices = choice;
		this.pos = position;
		//
	}
	public boolean getFree(){
		return this.free;
	}
	public String getName(){
		return this.name;
	}
	public LinkedList<Integer> getChoices(){
		return choices;
	}
	public int getPos(){
		return this.pos;
	}
	public void setFree(boolean change){
		this.free = change;
	}
	public void setChoice(LinkedList<Integer> choice){
		this.choices = choice;
	}
	public String getPartner(){
		return this.partner;
		
	}
	public void setPartner(String part){
		this.partner = part;
		
	}
	public String toString(){
		return this.pos + this.name + ": " + choices;
 		
	}
	

}
