
import java.util.Scanner;
public class main
{
  public static void main(String[] args)
  {int val;
      BinarySearchTreeWithRank t=new BinarySearchTreeWithRank();
      
      
      
      System.out.printf("insert 14 \n" );
   t.insert(14);
    System.out.printf("insert 7\n");
   t.insert(7);
    System.out.printf("insert 2\n");
   t.insert(2);
    System.out.printf("insert 1\n");
   t.insert(1);
    System.out.printf("insert 3\n");
   t.insert(3);
    System.out.printf("insert 12\n");
   t.insert(12);
    System.out.printf("insert 10\n");
   t.insert(10);
    System.out.printf("insert 20\n");
   t.insert(20);
   System.out.printf("insert 17\n");
   t.insert(17); 
   System.out.printf("insert 22\n");
   t.insert(22);
    System.out.printf("insert 21\n");
   t.insert(21); 
   t.treePresentation();
     
      System.out.printf("Functions : \n");
      System.out.printf("1.Insert an element\n2.Delete an element\n3.Find an element(return depth)\n");
      System.out.printf("4.Returns Kth smallest element (Give K)\n");
      System.out.printf("5.Returns the smallest element\n");
      System.out.printf("6.Returns the biggest element\n");
      System.out.printf("7.Delete the smallest element\n");
      System.out.printf("8.Delete the biggest element\n");
      System.out.printf("9.Returns tree height\n");
      System.out.printf("10.PreOrder traversal\n");
      System.out.printf("11.InOrder traversal\n");
      System.out.printf("12.PostOrder traversal\n");
      System.out.printf("13.LevelOrder traversal\n");
      System.out.printf("14.Tree Presentation\n");
      System.out.printf("15.Merging example\n");
      System.out.printf("16.this menu\n");
      System.out.printf("17.exit\n");

      Scanner sc = new Scanner(System.in);      
      val = sc.nextInt();
   
    
    
      while (val!=17)
      {
          
          
          
          
          
          switch (val)
          {case 1:
          System.out.println("Give an integer");     
          val = sc.nextInt();
          t.insert(val);
          t.treePresentation();
          break;
          case 2:
          System.out.println("Node deletion,Give an integer");  
          val = sc.nextInt();
          t.delete(val);
          t.treePresentation();
          break;
          
          case 3:
          System.out.println("Give a number");
           val = sc.nextInt();
    
          System.out.println(t.find(val));
          break;
          case 4:
          System.out.println("Give K\n");
		  val = sc.nextInt();
          System.out.println(t.findKth(val));
          break;
          case 5:
          System.out.println(t.findMin());
          break;
          case 6:
          System.out.println(t.findMax());
          break;
          case 7:
          t.deleteMin();
          t.treePresentation();
          break;
          case 8:
          t.deleteMax();
          t.treePresentation();
          break;
          case 9:
          System.out.println("Height is "+t.getHeight());
          break;
          case 10:
          t.printPreOrder();
          break;
          case 11:
           t.printInOrder();
           break;
           case 12:
           t.printPostOrder();
           break;
           case 13:
           t.printLevelOrder();
           break;
           case 14:
           t.treePresentation();
           break;
           case 15:
           System.out.println("merging example,New tree p");
           BinarySearchTreeWithRank p=new BinarySearchTreeWithRank();
           p.insert(30);p.insert(5);p.insert(11);p.insert(4);
           t.merge(p);
           t.treePresentation();
           break;
          
           case 16:
           
           System.out.printf("Functions : \n");
      System.out.printf("1.Insert an element\n2.Delete an element\n3.Find an element(return depth)\n");
      System.out.printf("4.Returns Kth smallest element (Give K)\n");
      System.out.printf("5.Returns the smallest element\n");
      System.out.printf("6.Returns the biggest element\n");
      System.out.printf("7.Delete the smallest element\n");
      System.out.printf("8.Delete the biggest element\n");
      System.out.printf("9.Returns tree height\n");
      System.out.printf("10.PreOrder traversal\n");
      System.out.printf("11.InOrder traversal\n");
      System.out.printf("12.PostOrder traversal\n");
      System.out.printf("13.LevelOrder traversal\n");
      System.out.printf("14.Tree Presentation\n");
      System.out.printf("15.Merging example\n");
      System.out.printf("16.this menu\n");
      System.out.printf("17.exit\n");
      break;
         
        
        }
         System.out.println("\nChoose a function (1-14),for functions menu press 16");
           val = sc.nextInt();
    
             

}

   
            
    }
             
 }
