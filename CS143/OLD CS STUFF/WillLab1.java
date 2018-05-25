/*
Project: ConsoleArt
filename: WillLab1
author name: William Nguyen
last modification: 4/6/16
description: creating a complex and creative ascii art in console.
My idea is a scalable image that lets the user decide the scale and the character used.
it will be a diamond within a box.

*/

import java.util.*;
public class WillLab1{
/*
main method on method calls and user input
it asks for character and then an integer and outputs a diamond, 
then asks if the user wants to go through again and loops the main if so.
*/
   public static void main(String arg[]){
      Scanner input = new Scanner(System.in);
      boolean go = true;
      while(go){
   
      System.out.println("Hello, welcome to Box. First choose a character that you would");
      System.out.println("like for your box. Please limit yourself to one character:");
      String filler = input.next();
         //Get a new console input until it is only one character
         while(filler.length() > 1)
            {
               System.out.println("That's a tad bit too many characters.");
               System.out.println("If you could try again and limit it to one,that would be dandy.");
               filler = input.next();
            }
      char fill = (char)filler.charAt(0);
      System.out.println("Next, please choose a horizontal length for the image.");
      System.out.println("NOTE: character number is actually a big larger than you would want.");
      
      //loops if it isn't a number including and above 1 and is an integer (this may be done wrong)
      int length = input.nextInt();
      System.out.println("Can you enter that again? My eyes might be deceiving me.");
         while(length < 1 && input.hasNextInt()){
            System.out.println("If you would please use a proper integer, that would be cool.");
            System.out.println("In other words, try again, nerd.");
            length = input.nextInt();
         }

   //doing 1/4 of the rectangle with user choice
      diamondCreate(fill, ((length/2) + 1), true);
   
   //doing 1/4 of the rectangle with filler asterisks
   
   //repeating first half but swapping the boolean of top, thus swapping left and right in the proceeding methods
      diamondCreate(fill, ((length/2) + 1), false);
      
      
      System.out.println("Do you want off this wild ride? \n y/n");
      String confirmation = "";
      confirmation = input.next();
         if(confirmation.equalsIgnoreCase("y")|| confirmation.equalsIgnoreCase("yes")){
            go = false;
         }
         else{
         System.out.println("You didn't say yes, so I'll just go again.");
         }
      }
   
   }
   /*
   fill in half the box with 4 different looped sections.
   method 1 uses method 3 to do the nested loop section
   uses method 3 to add the escape character
   It takes the chosen character and length from main and
   outputs the bottom and top half of the diamond by switching 
   the right and left with the boolean value.
   */
   public static void diamondCreate(char character, int length, boolean top){
      for(int i = 0; i<=length; i++){
         loopChar(i, character, !top, length);
         loopChar(i, '*', top, length);
         loopChar(i, '*', top, length);
         loopChar(i, character,!top, length);
         //going to a new line with method 2 and the \n escape character
         addChar("\n");
         }

   }
   
   
   
   /* used to change the character, 
   basically using a method to print whatever string or char is in the parameter
   */
      public static void addChar(char specialChar){
         System.out.print(specialChar);
   
      }
   /* method override to also accommodate strings and use them as well
   */

      public static void addChar(String specialString){
         System.out.print(specialString);
      }
   /* Takes in an integer that is from the first for loop, basically doing the second for loop
   from that integer, again taking the chosen character further and using the boolean value to vary
   which half of the smaller triangles it is attempting to do.
   */
      public static void loopChar(int iterate, char chosenCharacter, boolean left, int length){
         if(left){
            for(int j = 0; j<=iterate; j++){
               addChar(chosenCharacter);
            }
      }
   //varying how things iterate based on the left boolean being true or false
      else{
         for(int j = length; j>=iterate; j--){
            addChar(chosenCharacter);
         }
      }
   
   }

}