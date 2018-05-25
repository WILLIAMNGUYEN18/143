import java.io.*;
import java.util.*;

/*
project name: WillLab6
filename: StableMarriage
authors names: William Nguyen. Brandon Thompson
last modification date: 5/11/16
program description: Solves the classic "Stable" Marriage problem where it pairs off
men and women across an entire group and tries to find a good choice for a majority
of the people.
 * */
public class StableMarriage {
  /*Using END for catching the END statements in the file
   * We use global lists for our Person class, men and women.
   * We thus successfully store all the men and women.
   * 
   * */
   public static final String END = "END";
   public static List<Person> men;
   public static List<Person> women;

   /*We take an input for the file name
    *then we apply bring the input into our genderList
    *which then outputs two Person Lists to our global men and women Lists
    *We then iterate over every man and women to duplicate their internal
    *choices list so that we can use the old, unchanged list later.
    *We then match off everyone i nthe marriages method and print off the
    *results
    * */
   public static void main(String[] args) throws FileNotFoundException {
     Scanner console = new Scanner(System.in);
     System.out.print("What is the input file? ");
     String fileName = console.nextLine();
     Scanner input = new Scanner(new File(fileName));
     System.out.println();

     men = genderList(input);
     women = genderList(input);
     for (Person man : men) {
         man.duplicate();
     }
     for (Person woman : women) {
         woman.duplicate();
     }
     marriages(men, women);
     printChart();
   }   
   
   /*Fir the narriage section, we take in both rhe men and women list,
    * the global being implemented later on and a lot of this already having been
    * constructed. WE go over the entire men and women's list to
    * set them all free
    * We then go into a while loop that sets it's testAlone boolean at
    * the bottom. It checks the pseudocode of if the person has a partner
    * if they have a size larger than 0 and if it has previously been true. So as
    * long as someone has a size greater than 0.
    * For that, we go into a for loop to check the entire men's list and check
    * for their first lady, set her and whoever she is with free, then
    * match them and remove anyone after that person in the list.
    * */
   public static void marriages(List<Person> menList, List<Person> womenList) {
      boolean testAlone = true;
      for (Person oneMan : menList) {
         oneMan.setPartner(-1);
      }
      for (Person oneWoman : womenList) {
         oneWoman.setPartner(-1);
      }
      while(testAlone) {
         for(int i = 0; i < menList.size(); i++) {
            if (menList.get(i).getChoices().size() > 0) {
               System.out.println("Working on " + i);
               int firstLady = menList.get(i).getFirstChoice();
               int loser = womenList.get(firstLady).getPartner();
               if (loser > -1) {
                  menList.get(loser).erasePartner();
               }
               womenList.get(firstLady).setPartner(i);
               menList.get(i).setPartner(firstLady);
               int positionMan = womenList.get(firstLady).getChoices().indexOf(i);
               int listSize = womenList.get(firstLady).getChoices().size();
               for (int j = positionMan + 1; j < listSize; j++) {
                  loser = womenList.get(firstLady).getIndex(j);
                  menList.get(loser).removeChoice(firstLady);
                  womenList.get(firstLady).removeChoice(loser);
                  j--;
                  listSize --;
               }
             }
         }   
         for (Person man : menList) {
            if (man.getChoices().size() > 0 && testAlone == true) { 
               testAlone = true;
            }
            else if (man.getPartner() < 0 && man.getChoices().size() == 0) {
               testAlone = false;
            }
            else {
               testAlone = false;
            }
         }
      }
    }
   
   /*We break the information down into two separate steps with this method.
    * We take in the input scanner, and while the lines of the code aren't END
    * we apply the readperson method to each line to convert the information to the
    * Person Arraylist we need. we then add that to the result arraylist and return it
    * 
    * 
    * */
   public static List<Person> genderList(Scanner input) {
        List<Person> result = new ArrayList<Person>();
        String line = input.nextLine();
        while (!line.equals(END)) {
            result.add(readPerson(line));
            line = input.nextLine();
        }
        return result;
    }
   /*It reads the line, finds hte index of the colon after the name
    * takes the name as before the colon and creates a person, then takes
    * the rest of the information and pulls that Arraylist out.
    * to also be used in Person later.
    * 
    * */
     public static Person readPerson(String line) {
        int index = line.indexOf(":");
        Person result = new Person(line.substring(0, index));
        Scanner data = new Scanner(line.substring(index + 1));
        while (data.hasNextInt()) {
            result.addChoice(data.nextInt());
        }
        return result;
    }
     /*It uses the men and women global lists
      * iterating over the entire lists with a for each
      * printing out the pieces of information necessary from
      * each list. It also stores the math of choice in double variables
      * and calculates the average for the entire man and women's choices.
      * 
      * */
     public static void printChart() {
      int counter = 0;
      int indexNum;
      double total = 0;
      int rank = 0;
      String name = "";
      
      System.out.println("Matches for men");
      System.out.println("Name \t\t Choice \t Partner");
      for(int i = 0; i < 30; i++) {
         System.out.print("-");
      }
      System.out.println();
      
      for (Person man : men) {
         indexNum = man.getPartner();
         if (indexNum == -1) {
            name = "nobody";
         }
         else {
            rank = man.getPartnerRank();
            name = women.get(man.getPartner()).getName();
            total += rank;
            counter++;
         }
         if (indexNum != -1) {
            System.out.println(man.getName() + "\t\t" + rank + "\t" +  name);
         }
         else {
            System.out.println(man.getName() + "\t\t--\t" +  name);
         }
      }
      System.out.println("Mean Choice = " + total / counter);
      System.out.println();
      System.out.println();
      System.out.println("Matches for men");
      System.out.println("Name \t\t Choice \t Partner");
      for(int i = 0; i < 30; i++) {
         System.out.print("-");
      }
      System.out.println();

      counter = 0;
      total = 0;
      name = "";
      rank = 0;
      for (Person woman : women) {
         indexNum = woman.getPartner();
         if (indexNum == -1) {
            name = "nobody";
         }
         else {
            rank = woman.getPartnerRank();
            name = men.get(woman.getPartner()).getName();
            total += rank;
            counter++;        
         }
         if (woman.getName().length() >= 8) {
            if (indexNum != -1) {
               System.out.println(woman.getName() + "\t" + rank + "\t" +  name);
            }
            else {
              System.out.println(woman.getName() + "\t--\t" +  name);
            }
         }
         else {
            if (indexNum != -1) {
               System.out.println(woman.getName() + "\t\t" + rank + "\t" +  name);
            }
            else {
              System.out.println(woman.getName() + "\t\t--\t" +  name);
            }   
         }         
       }
       System.out.println("Mean Choice = " + total / counter);
    }
}