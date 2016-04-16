
/**
 * Write a description of class ReadFile here.
 * 
 * @author (Fiel Edvandro Domingos Muhongo) 
 * @Student (201406033)
 * @version (Assignment1)
 */
import java.util.*; // Importing all classes of java.util
import java.io.*;//Importing all classes of java.io
public class ReadFile
{//declaring a variable of thr type Scanner
 private  Scanner in;
    //Method to Open the file
    public void openFile(){
    
     try{
       in = new Scanner(new File("C:/Users/Edvandro/Desktop/Data.txt"));
      }
      catch(Exception e){
       System.out.println("File not found");
      }
     }
     //Method to read the file into a database
    public void readFile(DataBase a){
       while (in.hasNext()){
         String ln = in.next();
         String fn = in.next();
         String id = in.next();
         a.addIt(id,ln,fn);
      }
    }
     // a method to close the file
    public void closeFile(){
       in.close();
    }
 
}
