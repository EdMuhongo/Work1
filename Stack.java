
/**
 * Write a description of class Stack here.
 * 
  * @author (Fiel Edvandro Domingos Muhongo) 
 * @Student (201406033)
 * @version (Assignment1)
 *///Class Stack implemented in Class 
public class Stack
{    //Variables declaration
     private int[] theStack;   
     private int sp;
     private int maxS;
   // Stack Empty constructor
      public Stack(){
       sp = 0;   
        maxS = 10;
       theStack = new int [10];
     }
     // Stack Parameterized constructor
       public Stack(int sz){
          maxS = sz;
          sp=0;
         theStack = new int [sz];
       }
     // Method to check if the Stack is Full
     public boolean isFull(){
        return (sp==maxS);
        }
    // Method to check if the Stack is Empty
     public boolean isEmpty(){
        return (sp == 0);
        }   
      //Method to insert an element into the Array  
     public void Push(int val ){
        theStack[sp++]= val;
        }   
          //Method to delete an element in the Array 
        public int Pop(){
            int p =0;
           if(isEmpty()==true)
             System.out.println("Error");
           else
             {
               p = theStack[sp-1];
               sp--;
             }
          return p;
        }
       //Method to get the last element in the Array 
        
        public int Peek(){
            if (isEmpty() == true)
            System.out.print("Stack is Empty");
            return (theStack[sp-1]);
        }
        
    }
