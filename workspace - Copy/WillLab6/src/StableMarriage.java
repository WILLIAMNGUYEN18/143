import java.util.*;
import java.io.*;
public class StableMarriage {
	static Scanner input = null;
	static LinkedList<Person> women = new LinkedList<Person>();
	static LinkedList<Person> men = new LinkedList<Person>();
	/*
	 * 
	 * 
	 * */
	public static void main(String[] args){
		System.out.println("What is the file");
		String fileName = "";
		input = new Scanner(System.in);
		fileName = input.next();
		readFile(fileName);
		for(Person i: men){
			//ArrayList<Integer> store = i.getChoices().toArray();
			System.out.println(i.getPos() + " " + i.getName() + i.getChoices().toString());
		}
		for(Person i: women){
			System.out.println(i.getPos() + " " + i.getName() + i.getChoices().toString());
		}
		//
		//work();
		
		input.close();
	}
	
	/*Pseudo to work relations out
	 * set each person to be free;
	while (some man m with a nonempty preference list is free) {
		w = first woman on m's list;
		if (some man p is engaged to w) {
			set p to be free
		}
		set m and w to be engaged to each other
		for (each successor q of m on w's list) {
			delete w from q's preference list
			delete q from w's preference list
		}
	}
	 * */
	private static void work() {
		Iterator<Person> i = men.iterator();
		while(i.hasNext()){
			Person m = i.next();
			System.out.println("Working on " + m.getPos());
			while(m.getFree() && m.getChoices().size() != 0){
				int first = m.getChoices().getFirst();
				Person woman = women.get(first);
				if(!woman.getFree()){
					for(Person p: men){
						if (p.getName().equals(woman.getPartner())){
							//creates a new person that has same values as p,
							//but changes free to true and partner to blank.
							//them addomg the mew one to the position of p, and 
							//removing p.
							Person store = p;
							store.setFree(true);
							store.setPartner("");
							men.add(p.getPos(), store);
							men.remove(p);
						}
					}
				}
				//setting engagement
				m.setFree(false);
				m.setPartner(woman.getName());
				woman.setFree(false);
				woman.setPartner(m.getName());
				women.add(first, woman);
				women.remove(first + 1);
				men.add(m.getPos(), m);
				men.remove(m.getPos() +1);
				//removing successors from these married peoples.
				//for(){}
				
			}
		}
		
	}
	/*
	 * 
	 * 
	 * 
	 * */
	private static void readFile(String fileName) {
		int position = 0, posit = 0;
		Person store = null;
		String name = "";
		boolean male = true;
		LinkedList<Integer> choice = new LinkedList<Integer>();
		
		
		String line = "";
		File in = new File(fileName);
		Scanner fileRead = null;
		Scanner lineRead = null;
		try {
			fileRead = new Scanner(in);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			System.out.println("Could not find file.");
			e.printStackTrace();
		}
		while(fileRead.hasNextLine()){
			
			while(!line.equals("END")){
				line = fileRead.nextLine();
				lineRead = new Scanner(line);
				name = lineRead.next();
				name = name.substring(0,name.length()-1);
				while(lineRead.hasNextInt()){
					choice.add(lineRead.nextInt());
				}
				store = new Person(true, name, male, choice, position);
				men.add(store);
				position++;
				choice.clear();
				//line.nextLine();
				//, position
			}
			
			male = false;
			position = 0;
			line = fileRead.nextLine();
			while(!line.equals("END")){
				line = fileRead.nextLine();
				lineRead = new Scanner(line);
				name = lineRead.next();
				name = name.substring(0,name.length()-1);
					while(lineRead.hasNextInt()){
						choice.add(lineRead.nextInt());
					}
				store = new Person(true, name, male, choice, position);
				women.add(store);
				position++;
				choice.clear();	
				//
			}
		}
		//loop covers END as a list, so it removes that "EN" person.
		men.removeLast();
		women.removeLast();
	}
}
