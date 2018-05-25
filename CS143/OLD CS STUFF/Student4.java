public class Student4{  
   private int identification;
   private char grade;
   private double tuitionOwed;
   private String firstName = new String();
   private String lastName = new String();

   public Student4(int id, char grad, double tuition, String first, String last){
   this.identification = id;
   this.grade = grad;
   this.tuitionOwed = tuition;
   this.firstName = first;
   this.lastName = last;
   
   
   }

   public void setID(int x){
      this.identification = x;
   }

   public void setGrade(char x){
      if(!(x>='A'&& x<='F')){
         throw  new IllegalArgumentException();
      }
      else{
         this.grade = x;
      }
   }

   public void setTuitionOwed(double x){
      if(!(x >= 0)){
         throw new IllegalArgumentException();
      }
      else{
        this.tuitionOwed = x;

      }
 
   }

   public void setFirstName(String x){
   this.firstName = x;
   }

   public String toString(){
   return("ID: " + this.identification + "\n name: " + this.firstName + "\n grade:" + this.grade  );
   }

}

