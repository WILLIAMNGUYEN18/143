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


public class WillLab2{
	
	
   public static void main(String [] args) throws NoSuchElementException, IOException, FileNotFoundException{
   Scanner input = new Scanner(System.in);
   int loop = 1;
   String fileName = new String();
      System.out.println("Sales Records");
      System.out.println("Please enter a file name:");
      fileName = input.next();
/*
      try{
      File salesRecord = new File(fileName);
         if(salesRecord.canRead){
            System.out.println("File successfully accessed.");
         }
         else{
         System.out.println("File failed to open.");
         }
      }
      catch(FileNotFoundException e){
      System.out.println("File not found" + e.getMessage());
      }
      catch(IOException ioe){
      System.out.println("")
      
      }
*/

      File salesRecord = new File(fileName);
      PrintStream output = new PrintStream(salesRecord);
      while(loop != 0){
    	  loop = menu();
    	  if(loop == 2){
    		  viewSale(fileName);
    		  
    	  }
    	  if(loop == 1){
    		  addSale();
    		  
    	  }
      }
      System.out.println("Bye.");
      input.close();
   }

private static int menu() {
	// TODO Auto-generated method stub
	Scanner input = new Scanner(System.in);
	int choice = 0;
	System.out.println("Do you want to:");
	System.out.println("Add a sales record: (Enter 1)");
	System.out.println("View the sales report: (Enter 2)");
	System.out.println("Exit the program: (Enter 0)");
	choice = input.nextInt();
	while(!(choice == 0||choice == 1 || choice ==2)){
		System.out.println("Input error");
		System.out.println("Please input the 3 integer choices.");
		choice = input.nextInt();
		
	}
	input.close();
	return choice;
	
}
//finishing after addSale
private static void viewSale(String fileName) throws FileNotFoundException {
	// TODO Auto-generated method stub
	Scanner read = null;
	try {
		read = new Scanner(new File(fileName));
	} catch (FileNotFoundException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	//while(read.hasNext)
	read.close();
}


private static void addSale(){
	// TODO Auto-generated method stub
	//String name = new String();
	//name = "";
	String name = "";
	double sale = 0.0;
	Scanner in = new Scanner(System.in);
	System.out.println("Enter the sales person's name: ");
	
	//while(NextInt()){
		name = in.next();
			
	//}		
		
	System.out.println("Enter the sales made by " + name);
	while(!in.hasNextDouble()){
		System.out.println("You need to enter a numerical value");
		sale = in.nextDouble();
		
	}

	in.close();
}

}