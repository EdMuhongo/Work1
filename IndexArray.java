
/**
 * Write a description of class DataBaseArray here.
 * @author (Fiel Edvandro Domingos Muhongo) 
 * @Student (201406033)
 * @version (Assignment1)
 */

public class IndexArray
{ //Variables Declaration:
   IndexRecord[] Array ;  
    int next;
   // Index array empty constructor
    public IndexArray(){
      Array =new IndexRecord[100];
      next= 0;
    }
    // Index array parameterized constructor
    public IndexArray(int size){
       Array =new IndexRecord[size];
       next= 0;
    }
    // Insert method of the ordered Array
   public void Insert(IndexRecord val){
    int j;
     for (j = next-1 ; j>= 0 ; j--){
        if (Array[j].compareTo(val) < 0) break;
           Array[j+1]= Array[j];
        }
        Array[j+1]= val;
        next ++;
     } 
    // Search Method of the ordered array
     public int  Search(IndexRecord key){
      int hi, lo, mid,num ;
       hi = next-1;
       lo = 0;
       num = -1; 
       while (lo<=hi){
        mid = (lo + hi)/2;
        if (Array[mid].compareTo(key)== 0)
         num = mid  ;
      
        if (Array[mid].compareTo(key)>0)
            hi = mid - 1;
        else
          lo =mid +1;
       
        }
        return num; 
    }
    //Delete method of the ordered Array
    public int Delete(IndexRecord key){
       int where = Search(key);
        if (where != -1){
          for (int j = where ; j<next-1; j++){
           Array[j] = Array[j+1];    
        }
           next--;
        }
        return(where);
      } 
}
