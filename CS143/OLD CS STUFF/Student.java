import java.util.Comparator;

public class Student 

					implements Comparator<Student>{
	/*projectName: WillLab8
	 * fileName: Student
	 * author name: William Nguyen
	 * last modification date: 5/25/16
	 * description: the student class used
	 * to store information behind the sorter class.
	 * */
private String firstName;
private String lastName;
private int ID;
private double percentage;
private char grade;
/*student class that stroes all the information for the student
 * info that was processed. Includes the necessary getters
 * and to string to use it in the main*/
	public Student(String first, String last, int id, double percent, char grad){
		firstName = first;
		lastName = last;
		ID = id;
		percentage = percent;
		grade = grad;
	}
	public String getFirstName(){
		return firstName;
	}
	public String getLastName(){
		return lastName;
	}
	public int getID(){
		return ID;
	}
	public double getPercent(){
		return percentage;
	}
	public char getGrade(){
		return grade;
	}
	public String toString(){
		return this.getFirstName() + " " + this.getLastName() + " " + this.getID() + " " + this.getPercent() + " " + this.getGrade();
	}
	@Override
	public int compare(Student o1, Student o2) {
		// TODO Auto-generated method stub
		return o1.getFirstName().compareTo(o2.getFirstName());
	}
}
