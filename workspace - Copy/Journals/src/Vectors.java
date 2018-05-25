import java.util.*;


/*
 * Assuming vector dimensions is 2 or 3
 * If we were to use it in an infinite vector format, we would have to use an
 * ADT of some form like an ArrayList, and we would have to receive that for our constructors
 * and run a for loop for the size while doing each value.
 * 
 * 
 * Simple: Write a vector class in a programming language of your choice. 
 *	Harder followup: can everything you have learned about vectors so far be implemented on a computer? 
 *	Is there a vector problem that cannot be done by a computer?
 *
 *	So far, what we have learned is different ways of manipulating the same information,
 *and learning how to interpret vectors in a 3 dimensional space to actually apply them.
 *This vector class gives us the tools necessary to calculate all the different parts,
 *although it doesn't do any of the interpretation. We have to plug in the correct values
 *into the correct parts ourselves. Any concepts not included should be able to be recreated
 *off of the methods in the Vector class.
 * */
public class Vectors {
	/*
	 * Medium-hard followup: would you use exact arithmetic or floating point arithmetic? 
	What are the advantages and disadvantages of each?: 
	 * We are using floating point for the vectors so that
	 * we can get the decimal equivalents of fractions and squares
	 * considering that alternatively if we used exact arithmetic,
	 * we would end up with integers that always round down.
	 * */
	private double xVal;
	private double yVal;
	private double zVal;
	
	/*
	 * constructors for 2 dimensional and 3 dimensional
	 * vectors. If it's 2 dimensional, z is just 0
	 * */
	public Vectors(double x, double y, double z){
		this.xVal = x;
		this.yVal = y;
		this.zVal = z;
	}
	public Vectors(double x, double y){
		this.xVal = x;
		this.yVal = y;
		this.zVal = 0;
		
	}
	
	/*
	 * 3 accessing get methods for each integer
	 * */
	public double getVectorX(){
		return this.xVal;
	}
	
	public double getVectorY(){
		return this.yVal;
	}
	
	public double getVectorZ(){
		return this.zVal;
	}
	
	
	/*toString to show the vector format*/
	public String toString(){
		return "<" + this.xVal + ", " + this.yVal + ", " + this.zVal + ">"; 
	}
	
	/*
	 *Method to add 2 different vectors, whether 2 or 3 dimensional
	 *returns the added vectors.
	 * */
	public Vectors addVectors(Vectors bVector){
		Vectors result = null;
		if(bVector.getVectorZ() == 0 && this.getVectorZ()==0){
			double x = this.getVectorX() + bVector.getVectorX();
			double y = this.getVectorY() + bVector.getVectorY();
			result = new Vectors(x,y);
		}
		
		else{
			double x = this.getVectorX() + bVector.getVectorX();
			double y = this.getVectorY() + bVector.getVectorY();
			double z = this.getVectorZ() + bVector.getVectorZ();
			result = new Vectors(x,y,z);
		}
		return result;
	}
	/*
	 *Method to subtract 2 different vectors, whether 2 or 3 dimensional
	 *returns the subtracted vectors.
	 * */
	public Vectors subtractVectors(Vectors bVector){
		Vectors result = null;
		if(bVector.getVectorZ() == 0 && this.getVectorZ()==0){
			double x = this.getVectorX() - bVector.getVectorX();
			double y = this.getVectorY() - bVector.getVectorY();
			result = new Vectors(x,y);
		}
		
		else{
			double x = this.getVectorX() - bVector.getVectorX();
			double y = this.getVectorY() - bVector.getVectorY();
			double z = this.getVectorZ() - bVector.getVectorZ();
			result = new Vectors(x,y,z);
		}
		return result;
	}
	
	/*
	 * Method that returns the scalar multiple from the dot
	 * product of two vectors, whether two or 3 dimensional
	 * */
	public double dotVectors(Vectors bVector){
		if(bVector.getVectorZ() == 0 && this.getVectorZ()==0){
			double x = this.getVectorX() * bVector.getVectorX();
			double y = this.getVectorY() * bVector.getVectorY();
			return x + y;
		}
		else{
			double x = this.getVectorX() * bVector.getVectorX();
			double y = this.getVectorY() * bVector.getVectorY();
			double z = this.getVectorZ() * bVector.getVectorZ();
			return x + y + z;
		}
	}
	
	/*
	 * based off the formula:
	 * <a2b3 - a3b2, a3b1-a1b3,a1b2-a2b1>
	 * we cross the two vectors to form
	 * a new vector orthogonal to both.
	 * */
	public Vectors crossProduct(Vectors bVector){
		Vectors result = null;
		double x = (this.getVectorY() * bVector.getVectorZ())-(this.getVectorZ() * bVector.getVectorY());
		double y = (this.getVectorZ() * bVector.getVectorX())-(this.getVectorX() * bVector.getVectorZ());
		double z = (this.getVectorX()*bVector.getVectorY())-(this.getVectorY() * bVector.getVectorX());
		result = new Vectors(x,y,z);
		return result;
	}
	
	/*
	 * Based off formula:
	 * sqrt(a^2 + b^2 + c^2)
	 * we find the magnitude/length
	 * of our current vector.
	 * */
	public double magnitude(){
		return Math.sqrt(Math.pow(this.getVectorX(), 2) + Math.pow(this.getVectorY(), 2) + Math.pow(this.getVectorZ(), 2));
	}
	
	/*
	 *based off formula a*b/magnitude(a)
	 * comp of b onto a
	 **/
	public double compBontoA(Vectors bVector){
		return (this.dotVectors(bVector)/this.magnitude());
	}
	
	/*
	 * Projection of B onto A for both 2 and 3 dimensional vectors
	 * */
	public Vectors projBontoA(Vectors bVector){
		Vectors result = null;
		double scalar = this.compBontoA(bVector) * (1/this.magnitude());
		if(bVector.getVectorZ() == 0 && this.getVectorZ()==0){
			double x = this.getVectorX() * scalar;
			double y = this.getVectorY() * scalar;
			result = new Vectors(x,y);
			
		}
		else{
			double x = this.getVectorX() * scalar;
			double y = this.getVectorY() * scalar;
			double z = this.getVectorZ() * scalar;
			result = new Vectors(x,y,z);
		}
		return result;
	}
	
	/*
	 * based off formula:
	 * a*b = magnitude(b)*magnitude(a)cos(theta)
	 * */
	public double angleBetweenAB(Vectors bVector){
		return Math.acos(this.dotVectors(bVector)/(this.magnitude() * bVector.magnitude()));
	}
	
	/*
	 * based off formula:
	 * magnitude(axb) = magnitude(a) * magnitude(b)sin(theta)
	 * */
	public double crossProductAngleAB(Vectors bVector){
		return Math.asin(this.crossProduct(bVector).magnitude()/(this.magnitude() * bVector.magnitude()));
	}
	
	
	/*
	 * based off formula:
	 * A = |axb|
	 * */
	public double crossProductArea(Vectors bVector){
		return this.crossProduct(bVector).magnitude();
	}
	
}
