import java.io.*;
import java.util.*;

/*projectName: WillLab8
 * fileName: Sort
 * author name: William Nguyen
 * last modification date: 5/25/16
 * description: create a sorter to sort
 * student info based on different categories
 * with a comparator.
 * */
public class Sort{
	/*
	 * creating all the separate comparators necessary.
	 * */
	private static Comparator<Student> byPercent = new Comparator<Student>() {
		@Override
		public int compare(Student one, Student two) {
			if(one.getPercent() < two.getPercent()){
				return -1;
			}
			else if(one.getPercent() > two.getPercent()){
				return 1;
			}
			else{
			return 0;
			}
		}
    };
    private static Comparator<Student> reversebyPercent = new Comparator<Student>() {
		@Override
		public int compare(Student one, Student two) {
			if(one.getPercent() > two.getPercent()){
				return -1;
			}
			else if(one.getPercent() < two.getPercent()){
				return 1;
			}
			else{
			return 0;
			}
		}
    };
    private static Comparator<Student> byGrade = new Comparator<Student>() {
		@Override
		public int compare(Student one, Student two) {
			if(one.getGrade() < two.getGrade()){
				return -1;
			}
			else if(one.getPercent() > two.getPercent()){
				return 1;
			}
			else{
			return 0;
			}
		}
    };
    private static Comparator<Student> reversebyGrade = new Comparator<Student>() {
		@Override
		public int compare(Student one, Student two) {
			if(one.getGrade() > two.getGrade()){
				return -1;
			}
			else if(one.getPercent() < two.getPercent()){
				return 1;
			}
			else{
			return 0;
			}
		}
    };
    private static Comparator<Student> byID = new Comparator<Student>() {
		@Override
		public int compare(Student one, Student two) {
			if(one.getID() < two.getID()){
				return -1;
			}
			else if(one.getID() > two.getID()){
				return 1;
			}
			else{
			return 0;
			}
		}
    };
    private static Comparator<Student> reversebyID = new Comparator<Student>() {
		@Override
		public int compare(Student one, Student two) {
			if(one.getID() > two.getID()){
				return -1;
			}
			else if(one.getID() < two.getID()){
				return 1;
			}
			else{
			return 0;
			}
		}
    };
    private static Comparator<Student> byLastName = new Comparator<Student>() {
		@Override
		public int compare(Student one, Student two) {
			if(one.getLastName().compareTo(two.getLastName())>0){
				return 1;
			}
			else if(one.getLastName().compareTo(two.getLastName())<0){
				return -1;
			}
			else{
			return 0;
			}
		}
    };
    private static Comparator<Student> reversebyLastName = new Comparator<Student>() {
		@Override
		public int compare(Student one, Student two) {
			if(one.getLastName().compareTo(two.getLastName())<0){
				return 1;
			}
			else if(one.getLastName().compareTo(two.getLastName())>0){
				return -1;
			}
			else{
			return 0;
			}
		}
    };
    private static Comparator<Student> byFirstName = new Comparator<Student>() {
		@Override
		public int compare(Student one, Student two) {
			if(one.getFirstName().compareTo(two.getFirstName())>0){
				return 1;
			}
			else if(one.getFirstName().compareTo(two.getFirstName())<0){
				return -1;
			}
			else{
			return 0;
			}
		}
    };
    private static Comparator<Student> reversebyFirstName = new Comparator<Student>() {
		@Override
		public int compare(Student one, Student two) {
			if(one.getLastName().compareTo(two.getLastName())<0){
				return 1;
			}
			else if(one.getLastName().compareTo(two.getLastName())>0){
				return -1;
			}
			else{
			return 0;
			}
		}
    };
    
    private static ArrayList<Student> records = new ArrayList<Student>();
    /*asks for file, reads it and store info in an array of Students
     * Then proceeds to output the list, then resort it for all
     * the variations of the comparators involved.*/
	public static void main(String[] args){
		System.out.println("Please insert the student records filename");
		Scanner input = new Scanner(System.in);
		String fileName = input.nextLine();
		//records.add();
		System.out.println("Default:"+records.toString());
		sort(byFirstName);
		System.out.println("By first name:"+records.toString());
		sort(reversebyFirstName);
		System.out.println("By first name(reversed):"+records.toString());
		sort(byLastName);
		System.out.println("By last name:" + records.toString());
		sort(reversebyLastName);
		System.out.println("By last name reversed:" +records.toString());
		sort(byID);
		System.out.println("By ID:"+records.toString());
		sort(reversebyID);
		System.out.println("By reverse ID:"+records.toString());
		sort(byPercent);
		System.out.println("By percent:" +records.toString());
		sort(reversebyPercent);
		System.out.println("By percent reversed:" +records.toString());
		input.close();
	}
	
	/*reads the file and takes each line separately
	 * to then be read and added as a student*/
	public static void readFile(String fileName){
		
		String studentLine = "";
		File Students = new File(fileName);
		Scanner line = null;
		try {
			line = new Scanner(Students);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if(Students.canRead()){
			while(line.hasNextLine()){
				studentLine = line.nextLine();
				records.add(readLine(studentLine));
				
			}
			
		}
	
	}
	
	/*
	 * Reads the line and formulates a student based off that information
	 * */
	public static Student readLine(String studentLine){
		Student store = null;
		String first = "";
		String last = "";
		int ID = 0;
		double percent = 0.0;
		char grade = 'A';
		int increment = 0;
		Scanner reader = new Scanner(studentLine);
		while(reader.hasNext()){
			if(increment ==0){
				first = reader.next();
			}
			else if(increment == 1){
				last = reader.next();
			}
			else if(increment ==2){
				ID = reader.nextInt();
			}
			else if(increment ==3){
				percent = reader.nextDouble();
			}
			else if(increment ==4){
				grade = reader.next().charAt(0);
			}
			
			increment++;
		}
		
		
		store = new Student(first,last,ID,percent,grade);
		return store;
		
	}
	
	/*Does a bubble sort of the information
	 * based on the comparator inputed.
	 * swaps values if they are in the wrong order
	 * */
	public static void sort( Comparator<Student> order){
		for(int i = 0; i < records.size(); i++){
			for(int j = 0; j<records.size(); j++){
				if(order.compare(records.get(j),records.get(j+1))>0){
				swap(j, j +1);
				}
				else if(order.compare(records.get(j),records.get(j+1))<0){
					
				}
					
					
			}
		}
		
	}
	/*
	 * method to swap two values in the records arraylist.
	 * */
	private static void swap(int first, int second) {
		Student temp = records.get(first);
		records.set(first, records.get(second));
		records.set(second, temp);
		
	}
}
