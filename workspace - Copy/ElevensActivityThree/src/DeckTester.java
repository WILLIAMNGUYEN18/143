/**
 * This is a class that tests the Deck class.
 */
/*
 * William Nguyen
 * APCS w/ Mrs. Ozbun
 * ElevensLab Activity
 * 4/19/16
 * */
public class DeckTester {

	/**
	 * The main method in this class checks the Deck operations for consistency.
	 *	@param args is not used.
	 */
	public static void main(String[] args) {
		/* *** TO BE IMPLEMENTED IN ACTIVITY 2 *** */
		String[] ranks = new String[] {"jack","queen","king"};
		String[] suits = new String[] {"blue", "red"};
		int[] pointValues = new int[] {11,12,13};
		String[] rankss = new String[] {"10","9","jack"};
		String[] suitss = new String[] {"diamonds", "spade"};
		int[] pointValuess = new int[] {11,12,13};
		String[] ranksss = new String[] {"jack","queen","king", "A", "1","2","3","4","5","6", "7", "8", "9","10"};
		String[] suitsss = new String[] {"diamonds", "spade", "hearts", "clubs"};
		int[] pointValuesss = new int[] {10,10,10,11,1,2,3,4,5,6,7,8,9,10};
		Deck d = new Deck(ranks, suits, pointValues);
		Deck x = new Deck(rankss, suitss, pointValuess);
		Deck z = new Deck(ranksss, suitsss, pointValuesss);
		d.deal();
		x.deal();
		z.deal();
		System.out.println(d.toString());
		
		System.out.println(x.toString());
		System.out.println(z.toString());
		
		
	}
}
