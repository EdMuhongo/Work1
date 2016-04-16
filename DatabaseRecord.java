
/**
 * Write a description of class DatabaseRecord here.
  * @author (Fiel Edvandro Domingos Muhongo) 
 * @Student (201406033)
 * @version (Assignment1)
 */
public class DatabaseRecord
{
    //Declaring Variables
   private String ID;
   private String firstName;
   private String lastName;
  
   // DatabaseRecord Empty costructor
  public DatabaseRecord(){
      ID= new String(); 
      firstName = new String();
      lastName = new String();
  
    }
    //Parameterized DatabaseRecord constructor
   public DatabaseRecord(String a,String b, String c){
    ID = new String(a);
    firstName = new String(b);
    lastName =  new String(c); 
    } 
    // Methods to get ID,LastName and FirstName out of this class:
   public String getID(){
     return ID;
    } 
  
   public String getfirstName(){
      return firstName;
    }
    
   public String getlastName(){
      return lastName;
    } 
   //Methods toString to display the data formated:
   public String toString(){
     return String.format("%-12s%-14s%-14s",ID,firstName,lastName);
     }  
}
