import java.util.*;
/*
project name: WillLab6
filename: Person
authors names: William Nguyen. Brandon Thompson
last modification date: 5/11/16
program description: Class created to store the
information behind the preferences and p
 * */
    public class Person {
        
    public static final int NOBODY = -1;
/*stores the name,
 *a curent list of preferences,
 *an old list from creation
 *the integer of the partner's position in the opposing list
 *and this person's current index.
 * 
 * */
    private String name;
    private List<Integer> preferences;
    private List<Integer> pastPreferences;
    private int partner;
    private int index;

    /*
     * duplicates the values of the current preferences list 
     * over to the pastPreference to use for later
     * 
     * */
    public void duplicate () {
      for(int i = 0; i < preferences.size(); i++){
         pastPreferences.add(preferences.get(i));
      }
    } 
    
    /*
     * Initializes both lists to ArrayLists and takes in a name.
     * Defaults parter to the nobody constant, = -1
     * */
    public Person(String name) {
        this.name = name;
        preferences = new ArrayList<Integer>();
        pastPreferences = new ArrayList<Integer>();
        partner = NOBODY;
    }
    
    /*
     * toString uses the name and displays the entire preferences list
     * Mostly for us to use to figure out if we were storing and
     * applying changes to the lists correctly.
     * */
    public String toString() {
      return name + " Preferences: " + preferences;
    }
    /*
     *erasePartner converts the current partner to nobody/-1
     * */
    public void erasePartner() {
        partner = NOBODY;
    }
    /*
     * this checks if partner = nobody and returns true or false
     * based on that information
     * */
    public boolean hasPartner() {
        if (partner == NOBODY) {
         return false;
        }
        else {
         return true;
        }
    }
    
    /*Getting and setting partner
     * 
     * */
    public int getPartner() {
        return partner;
    }
    public void setPartner(int partner) {
        this.partner = partner;
    }
    
    /*
     * getting the person's name
     * */
    public String getName() {
        return name;
    }
    /*
     * returns the first choice in the
     * preference list
     * */
    public int getFirstChoice() {
        return preferences.get(0);
    }
    
    /*removes a choice based on the index of the
     * int parameter in the preference arraylist.
     * */
    public void removeChoice(int person) {               //int person is the index value of the woman you want to remove from the list, not the index value of the man's list
        index = preferences.indexOf(person);
        preferences.remove(index);
    }
    
    /*
     * add a new person to the preferences arraylist
     * */
    public void addChoice(int person) {
        preferences.add(person);
    }
    
    /*
     * returns the preferences arraylist
     * */
    public List<Integer> getChoices() {
        return preferences;
    }
    /*get the person at the specific index
     * that was taken in as a parameter
     * */
    public int getIndex(int index) {
      return preferences.get(index);
    }
    /*
     * get the partner's rank or what their position was
     * in this person's preference list.
     * */
    public int getPartnerRank() {
        return pastPreferences.indexOf(partner) + 1;
    }
}