
/**
 * Write a description of class IndexRecord here.
 * @author (Fiel Edvandro Domingos Muhongo) 
 * @Student (201406033)
 * @version (Assignment1)
 */
public class IndexRecord
{// Variables declaration:
  private String key;
 private  int where;
  // Declaring empty constructor of IndexRecord Class:
  public IndexRecord(){
    key = new String();
    where = 0;
    }
    // Parameterized IndexRecord Constractor:
  public IndexRecord(String s, int w){
    key = new String(s);
    where = w;
    } 
    // Mtehod compareTo to compare indexRecords
  public int compareTo(IndexRecord otherRecord){
    return (key.compareTo(otherRecord.key));
    }
    // Method to display the IndexRecord
   public String toString(){
    return (key + "   " +  where);
    }
    //Method to get where out of this class:
    public int getWhere(){
      return where;
    } 
     //Method to get where out of this class:
     public String getKey(){
      return key;
    } 
   
}
  
