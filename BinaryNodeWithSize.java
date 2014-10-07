

public class BinaryNodeWithSize
{
    
    private int data;
    private BinaryNodeWithSize leftchild;   
    private BinaryNodeWithSize rightchild;
    private BinaryNodeWithSize parent; //using parent pointer for size
    private  int size;
    public boolean visited;//visited flag for traversals
   
    
    public BinaryNodeWithSize()
    {
        size=1;
    }
     
   
    
    public int getdata()
    { return data; }
   
    public BinaryNodeWithSize getLeft()
    {return leftchild;}
    
    public BinaryNodeWithSize getRight()
    {return rightchild;}
    
    public void setData (int x)
    {
     data = x ;   
    }
    
    public void setLeft (BinaryNodeWithSize t)
    { leftchild=t; 
        
    setSize();
    
    }
    
    public void setRight (BinaryNodeWithSize t)
    { rightchild=t;
    setSize();
    
    }

    public void setParent (BinaryNodeWithSize t)
    {parent=t;
        setSize();}
        
       public BinaryNodeWithSize getParent()
       { return parent;}
   
       
       public void setSize()
    {  if ((leftchild!=null )&& (rightchild !=null))
        {size=1+leftchild.size+rightchild.size; 
            if (parent!=null)
            {parent.size=parent.size+size;
            parent.setSize();}//this will refresh size of all tree nodes bottom-up
            return;}
         if (leftchild!=null)
        {size=1+leftchild.size; 
            if (parent!=null)
            {parent.size=parent.size+size;
            parent.setSize();} //this will refresh size of all tree nodes bottom-up
            return;}
         if (rightchild!=null)
        {size=1+rightchild.size; 
            if (parent!=null)
            {parent.size=parent.size+size;
            parent.setSize();} //this will refresh size of all tree nodes bottom-up
            return;}
    }
    
    
    public int getSize()
    {      return size;}
    
}
