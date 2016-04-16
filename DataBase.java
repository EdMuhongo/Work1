
/**
 * Write a description of class DataBase here.
 * @author (Fiel Edvandro Domingos Muhongo) 
 * @Student (201406033)
 * @version (Assignment1)
 */
import java.util.Scanner; // importing Scanner
public class DataBase
{ // Variables Definition:
    DatabaseRecord[] DatabaseArray ;
      private int nextDatabaseRecord;
      private int counter;
       IndexArray ID;
       IndexArray firstName;
       IndexArray lastName;
       Stack myStack = new Stack(); // intatiation of a Stack
       
     public DataBase(int size){// Parametarazed Database constructor 
        DatabaseArray = new DatabaseRecord[size];
        ID = new IndexArray(size);
        lastName = new IndexArray(size);
        firstName = new IndexArray(size);
        nextDatabaseRecord = 0; 
        counter = 0;
    }
   
     public void addIt(){// Method Addit to Add a new record from the keyBoard
         int IndexInStack;// variable to store temporary Index in a Stack 
         String id;
         String ln;
         String fn;
        
         
         if (myStack.isEmpty())
          IndexInStack = nextDatabaseRecord;
          else 
          IndexInStack= myStack.Pop();
          // Prompting the user to insert data of the record from LastName, FirstName an ID
          Scanner input = new Scanner(System.in); 
          System.out.println("Enter the new record by:");
          System.out.println("Last Name:");
          ln = input.nextLine();
          System.out.println("First Name:");
          fn = input.nextLine();
          System.out.println("ID:");
          id = input.nextLine();
       
        IndexRecord key = new IndexRecord(id,0);
        int found = ID.Search(key);
        if (found >0){
             System.out.println("This record can not be added, cause the ID exists in the database");
             System.out.println( "################################################################");
             System.out.println( " "); 
            } else {
             DatabaseRecord temp = new DatabaseRecord(id,ln,fn);// creating a variable of the type DatabaseRecord
              DatabaseArray[IndexInStack]= temp; // Adding the variable to DatabaseArray
              
              //Adding Values into the three index arrays(ID,lastName,firstName)
               ID.Insert(new IndexRecord(id,IndexInStack)); 
               lastName.Insert(new IndexRecord(ln,IndexInStack)); 
               firstName.Insert(new IndexRecord(fn ,IndexInStack)); 
           nextDatabaseRecord++;// increasing Database array counter
          counter++;
       }
    } 
    // Method to Add data into the database from the Textfile
     public void addIt(String id, String ln, String fn){// Add method to read from the Text file
        
        IndexRecord key = new IndexRecord(id,0);// Creating an instance of IndexRecord with a given Id
        int found = ID.Search(key); //Searching of the Id in Indexarray Id an returning its position
        if (found >0){// Check if id exists show the message if does not Add the Record
                System.out.println("This record can not be added, cause the ID exists in the database");
                System.out.println( "##################################################################");
                 System.out.println( " "); 
            }else {
                DatabaseRecord temp = new DatabaseRecord(id,fn,ln);// instance of DatabaseRecord
                DatabaseArray[nextDatabaseRecord]= temp;// Adding a databaseRecord into a Database Array
          // Inserting the Records into the three index Arrays
           ID.Insert(new IndexRecord(id,nextDatabaseRecord)); 
           firstName.Insert(new IndexRecord(fn,nextDatabaseRecord)); 
           lastName.Insert(new IndexRecord(ln ,nextDatabaseRecord)); 
           nextDatabaseRecord++;
        
         }
      }
      // Method to find An Id into Index IdArray
     public void findIt(){
         Scanner input = new Scanner(System.in); // creating an instance of Scanner
         System.out.println("Enter the Id:");// prompting the user to insert the Id to be deleted
         String id = input.nextLine();
        IndexRecord key = new IndexRecord(id,0);//Creating an instace of IndexRecord with a given Id
         int found = ID.Search(key);//Searching of the Id in Indexarray Id an returning its position
         if (found ==-1 ){// if Statement to check if id exists, if not display a message or if does Display
            System.out.println( "Sorry, but Id entered was not found");
            System.out.println( "####################################");
            System.out.println( " "); 
            } else {
            System.out.println(DatabaseArray[ID.Array[found].getWhere()]);
            System.out.println( "################################");  
            System.out.println( " "); 
        } 
       }      
     // Method to delete from the Index Array    
     public int deleteIt(){
         Scanner input = new Scanner(System.in); // creating an instance of Scanner
         System.out.println("Enter the ID:");// prompting the user to insert the Id to be deleted
         String Id = input.nextLine();
         
          IndexRecord key = new IndexRecord(Id,0);//Creating an instace of IndexRecord with a given Id
          int pos = ID.Search(key); //Searching of the Id in Indexarray Id an returning its position
       
         if (pos ==-1){
          System.out.println("Record not found");
          System.out.println( "################################"); 
          System.out.println( " "); 
        }else{  
             int a = ID.Array[pos].getWhere();
               // Get Elemrnts from the Each IndexArray to delete 
               IndexRecord ln = new IndexRecord(DatabaseArray[a].getlastName(),pos);
               IndexRecord fn = new IndexRecord(DatabaseArray[a].getfirstName(),pos);
               IndexRecord id= new IndexRecord(DatabaseArray[a].getID(),pos);
               
               // Deleting Elements
                lastName.Delete(ln);
                firstName.Delete(fn);
                  ID.Delete(id);
                  myStack.Push(a);// Puching the deleted index into the Stack
                 System.out.println("Record Deleted");
                 System.out.println( "################################"); 
                 System.out.println( " "); 
           } 
           
       
            return pos;
        }
        
     //Method do display the three indexArray in a descending order   
     public void ListAscending(IndexArray theArray){
        int pos;
           for (int i=0;i<theArray.next;i++){
            pos = theArray.Array[i].getWhere();
             System.out.println(DatabaseArray[pos]);
            }    
            System.out.println( "#######################################");
            System.out.println( " "); 
      }
     //Method do display the three indexArray in a descending order      
     public void ListDescending(IndexArray theArray){
        int pos;
        for (int i = theArray.next -1;i>=0;i--){
           pos = theArray.Array[i].getWhere();
           System.out.println(DatabaseArray[pos]);
        }
        System.out.println( "##########################################"); 
        System.out.println( " "); 
        }  
        // Method to Print a Database
     public String printit(){
      return ID+" "+firstName+" "+lastName; 
     }
    }
