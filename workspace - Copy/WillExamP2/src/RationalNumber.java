import java.util.*;
/*Author: William Nguyen
 * Project Name: WillExamP2
 * File Name: WillExamP2ArrayProgramming
 * Date:4/21/16
 * Desc: a rational number class that represents a fraction with an integer numerator and denominator
 * 
 * 
 * */
public class RationalNumber {
private int num;// numerator field
private int denom;//denominator field
	public static void main(String[] args){
		RationalNumber x = new RationalNumber(4,8);
		RationalNumber y = new RationalNumber(3,4);
		RationalNumber store = y.subtractFrom(x);
		System.out.println(store.toString());
	}
/*constructs a RationalNumber object with the numerator and denominator arguments
 * If the denominator is 0, throw an exception*/
	public RationalNumber(int numerator, int denominator){
		if(denominator == 0){
			throw new IllegalArgumentException();
		}
		else{
		this.denom = denominator;
		}
		
		this.num = numerator;
	}
	
	/*constructs a RationNumber object. The default constructor of sorts. sets numerator to 0 
	 * and denominator
	 * to 1*/
	public RationalNumber(){
		this.num = 0;
		this.denom = 1;
	}
	
	/*Returns the denominator field*/
	public int getDenominator(){
		return this.denom;
	}
	
	/*Returns the numerator field*/
	public int getNumerator(){
		return this.num;
	}
	
	/*Returns a string of the numerator, a divide symbol "/", and the denominator
	 * If the denominator is 1, it just returns the numerator*/
	public String toString(){
		if(this.denom == 1){
			return num +"";
		}
		return num + "/" + denom;
		
	}
	
	/*multiplies the two denominators and numerators and sets them to two variables
	 * Creates a new RationalNumber applying the two variables as parameters, and then return it*/
	public RationalNumber multiply (RationalNumber oRN){
		RationalNumber store =  null;
		int newDenom = 0;
		int newNum = 0;
		newDenom = this.getDenominator() * oRN.getDenominator();
		newNum = this.getNumerator() * oRN.getNumerator();
		store = new RationalNumber(newNum, newDenom);
		return store;
		
		
	}
	
	/*multiplies the original denominator with the inverse of other denominator(other's numerator)
	 * then multiplies original numerator with other's denominator*/
	public RationalNumber dividBy (RationalNumber oRN){
		RationalNumber store =  null;
		int newDenom = 0;
		int newNum = 0;
		newDenom = this.getDenominator() * oRN.getNumerator();
		newNum = this.getNumerator() * oRN.getDenominator();
		store = new RationalNumber(newNum, newDenom);
		return store;
		
		
	}
	/*creates a common denominator from multiplying denominators, 
	 * then adds the two numerators that are each muliplied
	 * by the common denominator. Creates a new rational number with new numerator and common denominator
	 * */
	public RationalNumber add(RationalNumber oRN){
		//common denominator done with multiplying denominators, then multiplying both numerators by common denominator
		RationalNumber store =  null;
		int newNum = 0;
		int commDenom = 0;
		commDenom = this.getDenominator() * oRN.getDenominator();
		newNum = (this.getNumerator() * commDenom) + (oRN.getNumerator() * commDenom);
		store = new RationalNumber(newNum, commDenom);
		return store;
		
	}
	
	/*creates a common denominator from multiplying denominators, 
	 * then subtracts the two numerators that are each muliplied.
	 * by the common denominator. Creates a new rational number with new numerator and common denominator
	 * */
	public RationalNumber subtractFrom(RationalNumber oRN){
		//common denominator done with multiplying denominators, then multiplying both numerators by common denominator
		RationalNumber store =  null;
		int newNum = 0;
		int commDenom = 0;
		commDenom = this.getDenominator() * oRN.getDenominator();
		newNum = (oRN.getNumerator() * commDenom) - (this.getNumerator() * commDenom);
		store = new RationalNumber(newNum, commDenom);
		return store;
		
	}
	

}
