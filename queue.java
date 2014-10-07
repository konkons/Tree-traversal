




public class queue
{
    private linkedlist a;
    public queue()
    {
      a=new linkedlist() ; //a new queue based on a list
    }
    
    public node first()
    {
     return a.first();
    }
    public void enqueue(BinaryNodeWithSize d)
    {
     a.insertLast(d);   
    }    
    public void dequeue()
    {
       a.deleteFirst(); 
        
    }   
    public boolean isEmpty()
    {
        return a.isEmpty();
    }
}






