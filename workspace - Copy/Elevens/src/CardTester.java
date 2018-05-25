/**
 * This is a class that tests the Card class.
 * William Nguyen
 * Mrs. Ozbun 1st Period
 * AP Computer Science
 * 3/28/16
 * Activity 1
 */
public class CardTester {

	/**
	 * The main method in this class checks the Card operations for consistency.
	 *	@param args is not used.
	 */
	public static void main(String[] args) {
		/* *** TO BE IMPLEMENTED IN ACTIVITY 1 *** */
		Card x = new Card("A","Spade",2);
		Card z = new Card ("A","Spade",2);
		Card y = new Card("K", "Spade", 2);
		System.out.println("Are cards x and z equal?:"+ x.matches(z));
		System.out.println("Are cards x and y equal?:"+ x.matches(y));
		System.out.println(x.toString());
		
	}
}
