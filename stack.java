
public class stack 
{
    
    private linkedlist a;

    public stack()
    {
        a=new linkedlist();//a new stack based on a list
    }
    public void push(BinaryNodeWithSize d)
    {
       a.insertLast(d) ;
       
    }   
    public void pop()
    {
       a.deleteLast(); 
    }
    public node top()
    {
     return a.last();   
    }   
    public node  topAndPop()
    {
       node container=new node();
       container=a.last();
      a.deleteLast();
      return container;
    }
   public boolean isEmpty()
   {return a.isEmpty();}
     
}
