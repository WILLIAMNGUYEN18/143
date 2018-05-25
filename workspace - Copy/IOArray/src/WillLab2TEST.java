import java.util.*;
import java.io.*;
/*
project name: Lab 2 IO and Arrays
filename: WillLab2
authors' last name: William Nguyen
last modification date: 4/13/2016
program description:
Create a sales record that loops through a menu and gives the user the option to name the file, then add, view sales records, and exit.
Data must persist


*/


public class WillLab2TEST{
//Creating a static scanner for the various System.in so it 
	//doesn't get stuck on the first instance of system.in
static Scanner input = null;
//creating a global PrintStream to successfully 
//access it across the entire program
static PrintStream output = null;

/*
 * Main goes through the entire program, starting with asking for the file name
 * then it tries to break down the information from the file into the two arrays
 * It then goes to the looping phase where it loops through the menu method
 * then it takes the choice from menu and goes further into  the addSale or viewSale 
 *
 */
   public static void main(String [] args) 
		   throws NoSuchElementException, IOException, FileNotFoundException, InputMismatchException{
   input = new Scanner(System.in);
   
   int loop = 1;
   String[] names = new String[50];
   double[] sales = new double[names.length];
   String fileName = new String();
      System.out.println("Sales Records");
      System.out.println("Please enter your text file name:");
      
      fileName = input.next();

      //trying to catch a FileNotFoundException and creating the file if it doesn't exist.
      File salesRecord = new File(fileName);
      Scanner reader = null;
      try{
      reader = new Scanner(salesRecord);
      }
      catch(FileNotFoundException e){
    	  System.out.println("File did not exist prior, creating new one");
    	  output = new PrintStream(salesRecord);
    	  reader = new Scanner(salesRecord);
    	  
      }
      
      //setting up variables necessary to read and store file info
      //looks for line, then splits line into name and number
      //stores values in arrays
      String text = "";
      int count = 0;
      String textToName = "";
      double textToSale = 0;
      while(reader.hasNextLine()){
    	  text = reader.nextLine();
    	  Scanner splitText = new Scanner(text);
    	  textToName = splitText.next();
    	  while(splitText.hasNext() && !splitText.hasNextDouble()){
    		  textToName +=  " " +splitText.next();
    		  
    	  }
    	  while(splitText.hasNextDouble()){
    		  textToSale = splitText.nextDouble();
        	  names[count]= textToName;
        	  sales[count] = textToSale;
    		  count++;
    	  }
    	  splitText.close();
      }
      reader.close();
      //overwrites file and prepares output to print to it.
      output = new PrintStream(salesRecord);
      
      
    	  /*
    	  if(!reader.hasNextDouble()){
    		  textToName += reader.next();
    		  
    	  }
    	  else{
    		  textToSale = reader.nextDouble();
    		  
    	  }
    	  */
      for(int i = 0; i< count; i++){
    		output.println(names[i] + " " + sales[i]);
      }
      while(loop != 0){
    	  loop = menu();
    	  if(loop == 2){
    		  viewSale(fileName, names, sales, count);
    		  
    	  }
    	  if(loop == 1){
    		  addSale();
    		  
    	  }
      }
      System.out.println("Bye.");
      output.close();
      input.close();
   }

/*
 * Menu is a method that returns the numerical choice corresponding to
 * what the user wants to do, add, view, or exit.
 * It reads user input and asks for it again if it isn't the choices labeled
 * and then returns one of the accepted values to be used in the loop
 * */
private static int menu() {
	input = new Scanner(System.in);
	int choice = 0;
	System.out.println("Do you want to:");
	System.out.println("Add a sales record: (Enter 1)");
	System.out.println("View the sales report: (Enter 2)");
	System.out.println("Exit the program: (Enter 0)");
	try{
	choice = input.nextInt();
	}
	catch(InputMismatchException I){
		System.out.println("Please put in an integer next time.");
		System.out.println("Now closing program.");
	}
	while(!(choice == 0||choice == 1 || choice ==2)){
		System.out.println("Input error");
		System.out.println("Please input the 3 integer choices.");
		
		choice = input.nextInt();
		

	}
	return choice;
	
}


//finishing after addSale
private static void viewSale(String fileName, String[] names, double[] sales, int count) 
		throws FileNotFoundException {
	int totalSales = 0;
	for(int k = 0; k < count; k++){
		totalSales += sales[k];
	}
	for(int i = 0; i < count; i++){
		
		System.out.print(names[i] + " " );
		for(int j = 0; j < (sales[i]/totalSales * 100); j++){
		System.out.print("*");
		}
		System.out.println();
	}
	System.out.println("each asterisk is equal to roughly 1 percent of total Sales" );
	
	

}

/*
 * Add Sale scans for a name and a number and then inputs it into the text.
 * */
private static void addSale(){
	String name = "";
	double sale = 0.0;
   input = new Scanner(System.in);
	System.out.println("Enter the sales person's name: ");
	   name = input.nextLine();		
	System.out.println("Enter the sales made by " + name);
		try{
		sale = input.nextDouble();
		}
      catch(InputMismatchException I){
      System.out.println("You need to use a numerical value. \n now defaulting to 0.0");
      }
      System.out.println(name + " has sold: " + sale +". This will be added as a new entry.");
      //The restart is necessary as I don't pass through and adjust the arrays for the new values
      //It wasn't explicitly stated, so it seemed acceptable to make the program this way
      //It still functions, but requires a little more effort.
      System.out.println("You will need to restart the program to be able to view the sales report");
      System.out.println("with these additions");
      output.println(name + " " + sale);



}

}


