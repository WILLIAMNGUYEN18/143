/*
project name: WillLab3
filename: EDLEditor
authors' last name: William Nguyen
last modification date: 4/18/2016
program description:
Provides a menu to add to an existing EDL 
(to be read from an existing file), create an EDL, or
output an EDL. and loops until they're done.
*/
import java.util.*;
import java.io.*;



public class EDLEditor {
	//System in scanner input used across most methods
	static Scanner input = null;
	/*Main method. creates an Event ArrayList that stores the new or modified EDL.
	 * transfers that to output when needed. Loops between menu,
	 * starting, adding, or outputting.
	 * 
	 * */
	public static void main(String[] args) throws NoSuchElementException, FileNotFoundException{
		ArrayList<Event> transfer = null;
		int loop = 1;
		while(loop != 0){
			loop = menu();
			if(loop == 1){
				transfer =startEDL();
			}
			else if(loop == 2){
				transfer =openEDL();
				
			}
			else if(loop == 3){
				outputEDL(transfer);
			}
		}
		System.out.println("Goodbye");
		input.close();
	}
/*Asks for a file name. Creates one and then loops the ArrayList parameter
 * to get every single Event in the array recorded onto the document.
 * 
 * */
	private static void outputEDL(ArrayList<Event> info) {
		// TODO Auto-generated method stub
		//EDLEvents = new ArrayList<Event>();
		String fileName = "";
		input = new Scanner(System.in);
		System.out.print("Please enter a file name:");
		fileName = input.nextLine();
		PrintStream output = null;
		try {
			output = new PrintStream(fileName);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			System.out.println("could not find file");
			e.printStackTrace();
		}
		for(int i = 0; i < info.size(); i++){
			output.println(info.get(i).toString());
		}
		System.out.println("File Successfully Saved.");
	}
	/*Finds a file.
	 * If file doesn't exist, creates it
	 * reads file and copies information into new event.
	 * proceeds to store events into array list
	 * Then goes into while loop to create more events like the startEDL method
	 * adds more to ArrayList before exiting back to menu
	 * */
	private static ArrayList<Event> openEDL() throws FileNotFoundException {
		// TODO Auto-generated method stub
		//may use output EDL here
		
		//event storage
		int take = 0, camera = 0, event = 0, scene = 0;
		String desc = "";
		String timeS = "", timeE = "";
		TimeCode start = null, end = null;
		
		
		
		String fileName = "", eventLine = "";
		ArrayList<Event> bringer = new ArrayList<Event>();
		Event storage = null;
		int position = 0;
		input = new Scanner(System.in);
		
		System.out.print("Please enter a file name:");
		fileName = input.nextLine();
		
		File opening = null;
		opening = new File(fileName);
		Scanner fileRead=  null;
		try{
		fileRead = new Scanner(opening);
		}
		catch(FileNotFoundException f){
			PrintStream create = new PrintStream(opening);
			fileRead = new Scanner(opening);
		}
		while(fileRead.hasNextLine()){
			eventLine = fileRead.nextLine();
			Scanner lineRead = new Scanner(eventLine);
			while(lineRead.hasNext()){
				if(position == 0){
					event = lineRead.nextInt();
				}
				if(position == 1){
					scene = lineRead.nextInt();
				}
				if(position == 2){
					take = lineRead.nextInt();
				}
				if(position == 3){
					camera = lineRead.nextInt();
				}
				if(position == 4){
					timeS = lineRead.next();
					start = textToTime(timeS);
				}
				if(position == 5){
					timeE = lineRead.next();
					end = textToTime(timeE);
				}
				if(position >= 6){
					desc += lineRead.next();
				}
				position++;	
				
			}
			storage = new Event(event,scene,take,camera,start,end,desc);
			bringer.add(storage);
			position = 0;
			lineRead.close();
		}
		
				fileRead.close();
		System.out.println("File has been successfully loaded");
		System.out.println("Now starting additional Scenes");
		//setup for code reuse of startEDL method
		event++;
		scene = 0;
		boolean go = true;
		input = new Scanner(System.in);
		while(go){
			System.out.println("Event #: " + event);
			System.out.println("To return to the main menu - enter 0");
			System.out.print("Enter scene: \t");
			try{
				scene = input.nextInt();
			}
			catch(InputMismatchException i){
				System.out.println("Incorrect Input?");
			}
			if(scene == 0){
				go = false;
			}
			else{
				storage = createEvent(scene, event);
				bringer.add(storage);
				event++;
			}
		}
		System.out.println("Note, this has overridden any previous EDL.");
		return bringer;
	}
/*Starting a new EDL, we use the event and scene variables which
 * will be transferred to the createEven method
 * while scene isn't zero, we continue to ask for new scene, update event #
 * and go to createEvent method. after we've created the event, we return it
 * here to then be added to the array and returned out of here.
 * 
 * 
 * */
	private static ArrayList<Event> startEDL() {
		// TODO Auto-generated method stub
		//may use outputEDL here
		boolean go = true;
		int event = 1;
		int scene = 0;
		Event storage = null;
		ArrayList<Event> bringer = new ArrayList<Event>();
		input = new Scanner(System.in);
		while(go){
			System.out.println("Event #: " + event);
			System.out.println("To return to the main menu - enter 0");
			System.out.print("Enter scene: \t");
			try{
				scene = input.nextInt();
			}
			catch(InputMismatchException i){
				System.out.println("Incorrect Input?");
			}
			if(scene == 0){
				go = false;
			}
			else{
				storage = createEvent(scene, event);
				bringer.add(storage);
				event++;
			}
		}


		System.out.println("Note, this has overridden any previous EDL.");
	return bringer;
	}
/*It takes in both scene and event
 * It creates variables for all other values necessary to create an event
 * It then scans in integer values for take, camera.
 * For both TimeCodes, it goes to the textToTime Method 
 * which returns a TimeCode
 * 
 * */
	private static Event createEvent(int scene, int event) {
		int take = 0, camera = 0;
		String desc = "";
		
		TimeCode start = null;
		TimeCode end = null;
		input = new Scanner(System.in);
		System.out.print("\nEnter Take: \t");
		try{
			take = input.nextInt();
		}
		catch(InputMismatchException i){
			System.out.print("\n Wrong input, need an integer");
			System.out.print("\n defaulting 0");
			take = 0;
		}
		System.out.print("\nEnter Camera: \t");
		try{
			camera = input.nextInt();
		}
		catch(InputMismatchException i){
			System.out.println("\n Wrong input, need an integer");
			System.out.println(" defaulting 0");
			camera = 0;
		}
		System.out.println("Example TimeCode: \t01:24:25:13");
		System.out.print("\nStart TimeCode: \t");
		 start = textToTime("System.in");
		 System.out.println("\nEnd TimeCode: \t");
		 end = textToTime("System.in");
		 System.out.print("\nDescription: \t");
		 desc = input.nextLine();
		 Event store = new Event(event, scene, take, camera, start, end, desc);
		 return store;	
	}
/*The string brought in via parameter changes 
 * whether it uses the System.in or whatever text is inside
 * After that, it splits the text into 4 different strings
 * It then converts each string into a numerical value
 * And then applies those 4 values into a time code
 * It returns the time code it constructs
 * */
	private static TimeCode textToTime(String scan) {
		// TODO Auto-generated method stub
		if(scan.equals("System.in")){
		input = new Scanner(System.in);
		}
		else{
		input = new Scanner(scan);
		}
		int hour = 0, min = 0, sec = 0, frame = 0;
		String [] timeLine = new String[4];
		String text = "";
		text = input.nextLine();
		 timeLine = text.split(":");
		 
		 hour = Integer.parseInt(timeLine[0]);
		 min = Integer.parseInt(timeLine[1]);
		 sec = Integer.parseInt(timeLine[2]);
		 frame = Integer.parseInt(timeLine[3]);
		 TimeCode conversion = new TimeCode(hour,min,sec,frame);
		 
		 return conversion;
		
	}

	/*Sets up the menu
	 * Gives them 4 choices
	 * Closes if they don't choose a number
	 * loops if they don't choose a number that is a choice
	 * returns choice to main, the choice then leading to other methods
	 * */
	private static int menu() {
		// TODO Auto-generated method stub
		int choice = 0;
		input = new Scanner(System.in);
		System.out.println("Welcome to the Menu");
		System.out.println("To start a new EDL - Enter 1");
		System.out.println("To add to an existing EDL - Enter 2");
		System.out.println("To output the current EDL - Enter 3");
		System.out.println("To exit - Enter 0");
		   try{
			   	choice = input.nextInt();
		   }
		   catch(InputMismatchException i){
			   System.out.println("Please put in an integer next time.");
			   System.out.println("Now closing the program.");
		   }
		   while(!(choice == 0 || choice == 1 || choice == 2 || choice == 3)){
			   System.out.println("Input error");
			   System.out.println("Please input the 3 integer choices.");
			   choice = input.nextInt();   
		   }
		   
		return choice;	
	}
	
}
