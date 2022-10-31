/*
	Title	:	To implement binary tree and perform recursive and non-recursive traversals on it.	
*/

import java.util.Scanner;
import java.util.Stack;

class node
{
	int data;
	node lc,rc;
	
	node(int nm)
	{
		data=nm;
		lc=null;
		rc=null;
	}
}

class tree
{
	private node root;
	
	tree()
	{
		root=null;
	}
	
	
	boolean Empty()
	{
		if(root==null)		
			return true;
		
		return false;
	}
	
	void create()
	{
		
		int flag=0;
		int nm;
		char ch;
		
		Scanner sc=new Scanner(System.in);
		
		do
		{
			flag=0;
			
			System.out.println("Enter the node: ");
			nm=sc.nextInt();
			
			node temp= new node(nm);
			
			if(root==null)
			{
				root=temp;
				flag=1;
			}
			else
			{
				char dir;
				node ptr=root;
				
				
				while(flag==0)
				{
					System.out.println("\n"+ptr.data);
					System.out.println("Enter the direction: (L/R)");
					dir=sc.next().charAt(0);
					
					if(dir=='l'||dir=='L')
					{
						if(ptr.lc!=null)
							ptr=ptr.lc;
						else
						{
							ptr.lc=temp;
							flag=1;
						}
						
					}
					else if(dir=='r'||dir=='R')
					{
						if(ptr.rc!=null)
							ptr=ptr.rc;
						else
						{
							ptr.rc=temp;
							flag=1;
						}
					}
					else
						System.out.println("Invalid direction!");
					
				}
			}
			
			if(flag==1)
				System.out.println("Node inserted!");
			
			
			System.out.println("\n\nDo you want to continue creating? (Y/N)");
			ch=sc.next().charAt(0);
			
		}while(ch=='y'||ch=='Y');
				
	
	}
	
	void inorder(node local_root)
	{
		if(local_root!=null)
		{
			inorder(local_root.lc);
			System.out.println(local_root.data);
			inorder(local_root.rc);
		}
	}
	
	void preorder(node local_root)
	{
		if(local_root!=null)
		{
			System.out.println(local_root.data);
			preorder(local_root.lc);			
			preorder(local_root.rc);
		}
	}
	
	void postorder(node local_root)
	{
		if(local_root!=null)
		{
			postorder(local_root.lc);
			postorder(local_root.rc);
			System.out.println(local_root.data);
		}
	}
	
	
	void r_inorder()
	{
	
		if(Empty())
		{
			System.out.println("Tree is empty!!!");
			return;
		}
		
		inorder(root);
	}
	
	void r_preorder()
	{
		
		if(Empty())
		{
			System.out.println("Tree is empty!!!");
			return;
		}
		
		preorder(root);
	}
	
	void r_postorder()
	{
		
		if(Empty())
		{
			System.out.println("Tree is empty!!!");
			return;
		}
		
		postorder(root);
	}
	
	void nr_inorder() 
	{
		
		if(Empty())
		{
			System.out.println("Tree is empty!!!");
			return;
		}
		
		node ptr=root;
		Stack<node> s=new Stack<node>();
		
		while(true)
		{
			while(ptr!=null)
			{
				s.push(ptr);
				ptr=ptr.lc;
			}
			
			if(s.isEmpty())
				break;
			
			ptr=s.pop();
			System.out.println(ptr.data);
			ptr=ptr.rc;			
			
		}
	}
	
	void nr_preorder() 
	{
		
		if(Empty())
		{
			System.out.println("Tree is empty!!!");
			return;
		}
		
		node ptr=root;
		Stack<node> s=new Stack<node>();
		
		while(true)
		{
			while(ptr!=null)
			{
				System.out.println(ptr.data);
				s.push(ptr);
				ptr=ptr.lc;
			}
			
			if(s.isEmpty())
				return;
			
			ptr=s.pop();
			ptr=ptr.rc;
			
			
		}
	}
	
	void nr_postorder()
	{
		
		if(Empty())
		{
			System.out.println("Tree is empty!!!");
			return;
		}
		
		Stack <node> s=new Stack<node>();
		Stack<Character> s1=new Stack<Character> ();

	    node ptr=root; 
		char flag;
	       
	    while(!s.isEmpty()||ptr!=null)
	    {
		    if(ptr!=null)
		    {
		        s.push(ptr);
		        s1.push('l');
		        ptr=ptr.lc;		
		    }
		    else
		    {
		        ptr=s.pop();
		        flag=s1.pop();
		        if(flag=='l')
		        {
		            s.push(ptr);
		            s1.push('r');
		            ptr=ptr.rc;
		           
		        }
		        else
		        {
		            System.out.println(ptr.data);
		            ptr=null;
		        }
		    }
		}  
	      
    }




}


public class assign1 {

	public static void main(String[] args) 
	{
		
		int ch;
		Scanner sc=new Scanner(System.in);
		
		tree t1= new tree();
		
		do
		{
		
			System.out.println("\n----------MENU----------");
			System.out.println("1.Create");
			System.out.println("2.Recursive inorder");
			System.out.println("3.Recursive preorder");
			System.out.println("4.Recursive postorder");
			System.out.println("5.Non-recursive inorder");
			System.out.println("6.Non-recursive preorder");
			System.out.println("7.Non-recursive postorder");
			System.out.println("------------------------\n");

			System.out.println("Enter your choice");
			ch=sc.nextInt();
			System.out.println("------------------------\n");


			switch(ch)
			{
				case 1:
						t1.create();
						break;
						
				case 2:
						t1.r_inorder();
						break;
						
				case 3:
						t1.r_preorder();
						break;
				
				case 4:
						t1.r_postorder();
						break;
					
				case 5:
						t1.nr_inorder();
						break;
						
				case 6:
						t1.nr_preorder();
						break;
						
				case 7:
						t1.nr_postorder();
						break;
				
			}	
		
		}while(ch>0&&ch<8);
		
		
	}

}

/*

OUTPUT:


----------MENU----------
1.Create
2.Recursive inorder
3.Recursive preorder
4.Recursive postorder
5.Non-recursive inorder
6.Non-recursive preorder
7.Non-recursive postorder
------------------------

Enter your choice
2
------------------------

Tree is empty!!!

----------MENU----------
1.Create
2.Recursive inorder
3.Recursive preorder
4.Recursive postorder
5.Non-recursive inorder
6.Non-recursive preorder
7.Non-recursive postorder
------------------------

Enter your choice
1
------------------------

Enter the node:
1
Node inserted!


Do you want to continue creating? (Y/N)
y
Enter the node:
2

1
Enter the direction: (L/R)
l
Node inserted!


Do you want to continue creating? (Y/N)
y
Enter the node:
3

1
Enter the direction: (L/R)
r
Node inserted!


Do you want to continue creating? (Y/N)
n

----------MENU----------
1.Create
2.Recursive inorder
3.Recursive preorder
4.Recursive postorder
5.Non-recursive inorder
6.Non-recursive preorder
7.Non-recursive postorder
------------------------

Enter your choice
2
------------------------

2
1
3

----------MENU----------
1.Create
2.Recursive inorder
3.Recursive preorder
4.Recursive postorder
5.Non-recursive inorder
6.Non-recursive preorder
7.Non-recursive postorder
------------------------

Enter your choice
5
------------------------

2
1
3

----------MENU----------
1.Create
2.Recursive inorder
3.Recursive preorder
4.Recursive postorder
5.Non-recursive inorder
6.Non-recursive preorder
7.Non-recursive postorder
------------------------

Enter your choice
3
------------------------

1
2
3

----------MENU----------
1.Create
2.Recursive inorder
3.Recursive preorder
4.Recursive postorder
5.Non-recursive inorder
6.Non-recursive preorder
7.Non-recursive postorder
------------------------

Enter your choice
6
------------------------

1
2
3

----------MENU----------
1.Create
2.Recursive inorder
3.Recursive preorder
4.Recursive postorder
5.Non-recursive inorder
6.Non-recursive preorder
7.Non-recursive postorder
------------------------

Enter your choice
4
------------------------

2
3
1

----------MENU----------
1.Create
2.Recursive inorder
3.Recursive preorder
4.Recursive postorder
5.Non-recursive inorder
6.Non-recursive preorder
7.Non-recursive postorder
------------------------

Enter your choice
7
------------------------

2
3
1


*/
