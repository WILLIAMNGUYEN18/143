import java.util.*;
import java.io.*;
/*
project name: Lab 2 IO and Arrays
filename: WillLab2
authors' last name: William Nguyen
last modification date: 4/12/2016
program description:
Create a sales record that loops through a menu and gives the user the option to name the file, then add, view sales records, and exit.
Data must persist


*/


public class WillLab2{
   public static void main(String [] args) throws IOException, FileNotFoundException{
   Scanner input = new Scanner(System.in);
   String fileName = new String();
      System.out.println("Sales Records");
      System.out.println("Please enter a file name");
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
   }


}