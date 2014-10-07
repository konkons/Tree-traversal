


public class BinarySearchTreeWithRank
{
   BinaryNodeWithSize root ;
    public BinarySearchTreeWithRank()
    {
        
    }
    public void insert (int el )
    { BinaryNodeWithSize newNode =new BinaryNodeWithSize ();// make new node
        newNode.setData(el); // insert data
        if (root==null)// no node in root
        root=newNode;
        else // root occupied
        {
            BinaryNodeWithSize current = root;// start at root
            BinaryNodeWithSize parent;
            while (true)// (exits internally)
            {
                parent=current;
                if (el<current.getdata())// go left?
                { current=current.getLeft(); 
                  if(current==null)// if end of the line,
               {parent.setLeft(newNode);// insert on left
                 parent.getLeft().setParent(parent); 
                   
               return;}// end if go left
                }else  // or go right?
                {  current=current.getRight();
                    if(current == null)// if end of the line
                   {parent.setRight(newNode);// insert on right
                      parent.getRight().setParent(parent); 
                         
                               return;}
                   }// end else go right
               } // end while
           }// end else not root
      }// end insert()
      
      public void delete (int el)  // delete node with given key
      {  BinaryNodeWithSize current = root;// (assumes non-empty list)
         BinaryNodeWithSize parent = root;  
         boolean isLeftChild = true;
         
         while (current.getdata()!= el)
         {
         parent = current;
         if(el < current.getdata())         // go left?
            {
            isLeftChild = true;
            current = current.getLeft();
            }
         else                            // or go right?
            {
            isLeftChild = false;
            current = current.getRight();
            }
         if(current == null)  // end of the line,
         {  
         return   ;         }     // didn't find it
         }  // end while
      // found node to delete

      // if no children, simply delete it
      if(current.getLeft()==null && current.getRight()==null)
         {
         if(current == root)             // if root,
            root = null;                 // tree is empty
         else if(isLeftChild)
           parent.setLeft(null);       // disconnect
         else                            // from parent
            parent.setRight(null);
                
         }

      // if no right child, replace with left subtree
      else if(current.getRight()==null)
          if(current == root)
            root = current.getLeft();
         else if(isLeftChild)
           {parent.setLeft(current.getLeft()); 
           current.getLeft().setParent(parent);}
           else
           { parent.setRight(current.getLeft());
            current.getLeft().setParent(parent);}    

      // if no left child, replace with right subtree
      else if(current.getLeft()==null)
         if(current == root)
            root = current.getRight();
         else if(isLeftChild)
           { parent.setLeft(current.getRight());
            current.getLeft().setParent(parent);}
         else
            {parent.setRight(current.getRight());
            current.getRight().setParent(parent);}    

      else  // two children, so replace with inorder successor
         {
         // get successor of node to delete (current)
         BinaryNodeWithSize successor = getSuccessor(current);

         // connect parent of current to successor instead
         if(current == root)
            {root = successor;}
         else if(isLeftChild)
           {parent.setLeft(successor) ;
           successor.setParent(parent);}
          else
            {parent.setRight(successor) ;
            successor.setParent(parent);}
                
         // connect successor to current's left child
         successor.setLeft(current.getLeft());
         successor.setParent(parent);
         }  // end else two children
      // (successor cannot have a left child)
      
      
     
       return ;                                        // success
      }  // end delete()
    
      private BinaryNodeWithSize getSuccessor(BinaryNodeWithSize delNode)
      {
      BinaryNodeWithSize successorParent = delNode;
      BinaryNodeWithSize successor = delNode;
      BinaryNodeWithSize current = delNode.getRight();   // go to right child
      while(current != null)               // until no more
         {                                 // left children,
         successorParent = successor;
         successor = current;
         current = current.getLeft();      // go to left child
         }
                                           // if successor not
      if(successor != delNode.getRight())  // right child,
         {                                 // make connections
         successorParent.setLeft(successor.getLeft()) ;
         successor.setRight(delNode.getRight()) ;
         }
      return successor;
      }
    
    
      public int find(int el)      // find node with given key
      {                           // (assumes non-empty tree)
      BinaryNodeWithSize current = root;   // start at root
      int d=0;  //d  depth counter
      while(current.getdata() != el)        // while no match,
         {
         if(el < current.getdata() )         // go left?
            {current = current.getLeft();
            d=d+1;}
         else                            // or go right?
            {current = current.getRight();
            d=d+1;}
         if(current == null)             // if no child,
            return -1;                 // didn't find it
         }
      return d;                    // found it
      }  // end find()
   

    public int findKth(int k)//using Inorder traversal algorithm
    {
       stack s=new stack();//in order traversal traverse tree
     BinaryNodeWithSize cnode;//from smallest to biggest elements
     s.push(root);
     int l=0;//counter
     int found=-1;//the number we are looking for
     while (!s.isEmpty())
     {     cnode=s.top().data;
         if ((cnode.getLeft()!=null)&& (cnode.getLeft().visited==false))
         {s.push(cnode.getLeft());}
         else 
         {if ((cnode.getRight()!=null)&& (cnode.getRight().visited==false))
             {   l=l+1;//counts k 
                 cnode.visited=true;
                 s.pop();
                s.push(cnode.getRight());
           if (k==l)//until l=k
           {
            found=cnode.getdata();}
                 
                 
                 }
             else 
             {l=l+1;
                cnode.visited=true;
            s.pop();
        
        if (k==l)
        {
            found=cnode.getdata();}
        }}
         
         
        }   
    
    
        cleanVisits();
      return found;  
    }
    
   public int findMin()
   {BinaryNodeWithSize c=root;//traverse the left subtree
   while (c.getLeft()!=null)//until the leftmost node has been visited
        { c=c.getLeft();}
     return c.getdata();
       
    }
    
    public int findMax()
    {BinaryNodeWithSize c=root;
        
      while (c.getRight()!=null)//traverse the right sub-tree
           { c=c.getRight();}//until the righttmost node has been visited
        return c.getdata();
        
      }
      
      
      public void deleteMin()
      {   
       delete(findMin());//delete max
      }
        
        
         public void deleteMax()
      {  
          delete(findMax());//delete min
        
        
        }
        
        public int getHeight() //using postorder algorithm
        
       {  int h1=1;
           int h2=1;   
           
           stack s=new stack();
     BinaryNodeWithSize cnode;
     s.push(root);
     while (!s.isEmpty())
     {     cnode=s.top().data;
         if ((cnode.getLeft()!=null)&& (cnode.getLeft().visited==false))
         {s.push(cnode.getLeft());
            h1=h1+1;}//every push  increases height
         else 
         {if ((cnode.getRight()!=null)&& (cnode.getRight().visited==false))
             {s.push(cnode.getRight());
                h1=h1+1;}//every push  increases height
             else 
             {
                cnode.visited=true;
                h2=Math.max(h1,h2);//finds the max height among subtrees.Maximum is the height of the tree.
                h1=h1-1;//every pop reduces height
            s.pop();}}
         
         
        }   
       return h2; }
        
        
        public void merge (BinarySearchTreeWithRank t)
        {
        stack s = new stack();
       BinaryNodeWithSize cnode;
        s.push ( t.root);
        
        while ( !s.isEmpty())//traversing new tree (preorder traversal)
                             
        {   
            cnode=s.topAndPop().data;
            BinaryNodeWithSize right = cnode.getRight();
            if (right !=null)
            s.push(right);
            BinaryNodeWithSize left =cnode.getLeft();
            if (left!=null)
             s.push(left);
             insert(cnode.getdata());//insert every new node to tree
            
            
            
        }
        
       
        
        }
        
        public void printPreOrder()
    {stack s = new stack();
       BinaryNodeWithSize cnode;
        s.push ( root);
        
        while ( !s.isEmpty())
        
        {   
            cnode=s.topAndPop().data;//visiting left subtree then right subtree
            BinaryNodeWithSize right = cnode.getRight();
            if (right !=null)// pushing right 
            s.push(right);//and then left node of every node
            BinaryNodeWithSize left =cnode.getLeft();
            if (left!=null)
             s.push(left);
             System.out.printf("%d,",cnode.getdata());
            
            
            
        }
        
        cleanVisits();
    }
    
    private void cleanVisits()//using preorder traversal algorthm 
    {                            //cleans visited flags of binaryNodes
        stack s = new stack();
       BinaryNodeWithSize cnode;
        s.push ( root);
        
        while ( !s.isEmpty())
        
        {   
            cnode=s.topAndPop().data;
            BinaryNodeWithSize right = cnode.getRight();
            if (right !=null)
            s.push(right);
            BinaryNodeWithSize left =cnode.getLeft();
            if (left!=null)
             s.push(left);
             cnode.visited=false;
             
            
            
            
        }
        
    }
    
    
    
    
    public void printPostOrder()
    {
     stack s=new stack();
     BinaryNodeWithSize cnode;
     s.push(root);
     while (!s.isEmpty())
     {     cnode=s.top().data;
         if ((cnode.getLeft()!=null)&& (cnode.getLeft().visited==false))
         {s.push(cnode.getLeft());}//traverse the left sub-tree and push each visited node on the stack
         else //until the leftmost node has been visited
         {if ((cnode.getRight()!=null)&& (cnode.getRight().visited==false))
             {s.push(cnode.getRight());}//If the right sub-tree is not null, visit the right sub-tree and push it on the stack. 
             else //If null, pop the stack and output it.
             {System.out.printf("%d,",cnode.getdata());
                cnode.visited=true;
            s.pop();}}
         
         
        }   
        cleanVisits();
        
    }
    
    
    
    public void printInOrder()
    
    {
    stack s=new stack();
     BinaryNodeWithSize cnode;
     s.push(root);
     while (!s.isEmpty())
     {     cnode=s.top().data;
         if ((cnode.getLeft()!=null)&& (cnode.getLeft().visited==false))//traverse the left sub-tree and push each visited node on the stack
         {s.push(cnode.getLeft());} //until the leftmost node has been visited
         else 
         {if ((cnode.getRight()!=null)&& (cnode.getRight().visited==false))
             {   System.out.printf("%d,",cnode.getdata());//If the right sub-tree is not null
                 cnode.visited=true;//pop the stack and output it, then visit the right sub-tree and push it on the stack. 
                 s.pop();
                s.push(cnode.getRight());}
             else //If null, pop the stack and output it.
             {System.out.printf("%d,",cnode.getdata());
                cnode.visited=true;
            s.pop();}}
         
         
        }   
    
    cleanVisits();
    }
    
    public void printLevelOrder()
    {queue q=new queue();
        q.enqueue(root);//level order traversal using queue
        BinaryNodeWithSize cnode;
        while (!q.isEmpty())
    { cnode=q.first().data;
        q.dequeue();
        System.out.printf("%d,",cnode.getdata());
        if (cnode.getLeft()!=null)
        q.enqueue(cnode.getLeft());
        if (cnode.getRight()!=null)
        q.enqueue(cnode.getRight());
    
    }
    cleanVisits();
    }
    
    public void treePresentation()//using level order traversal algorithm
    {queue q=new queue();
        q.enqueue(root);
        BinaryNodeWithSize cnode;
        System.out.println("TREE Number Of Nodes (size):"+root.getSize());
        while (!q.isEmpty())
    { cnode=q.first().data;
        q.dequeue();
        System.out.println(cnode.getdata());
        if (cnode.getLeft()!=null)
        {q.enqueue(cnode.getLeft());
         System.out.printf("(Left child - %d)\n",cnode.getLeft().getdata());}
        if (cnode.getRight()!=null)
        {q.enqueue(cnode.getRight());
        System.out.printf("(Right child - %d)\n",cnode.getRight().getdata());}
    
    }
       System.out.println("END OF TREE");
       cleanVisits();
    }
    
    
    
    
    
    
    
    
    
}
