/*

	Rollno	:	2965
	Title	:	To implement hashing and perform operations on it.
	
*/

import java.util.*;

class Client
{
	
	int cid,mob;
	String name;
	Client next;
	Client(int c,int m,String n)
	{
		cid=c;
		mob=m;
		name=n;
		next=null;
	}
}

class Hashing
{
	Scanner sc=new Scanner(System.in);
	int max=10;
	
	Client Head[]=new Client[max];
	
	
	void create()
	{
		for(int i=0;i<max;i++)
		{
			Head[i]=null;		
			
		}
		 
	}
	
	
	int hashval(int k)
	{
		return k%max;
	}
	
	
	void Insert()
	{
		System.out.print("Enter the Client ID : ");
		int cno=sc.nextInt();
		
		System.out.print("Enter the Client Name : ");
		String nm=sc.next();
		
		System.out.print("Enter the Client Phone no : ");
		int mb=sc.nextInt();
		
		Client temp=new Client(cno,mb,nm);
		
		int hashadd=hashval(temp.cid);
		
				 
				 if(Head[hashadd]==null)
					{
						Head[hashadd]=temp;
					
					}
					else
					{
						temp.next=Head[hashadd];
						Head[hashadd]=temp;
	
					}	
				 
				 
				 
				 display();
				 
				 System.out.println("Do you wish to insert again? If yes, press 1");
				 int c=sc.nextInt();
				 
				 if(c==1)
				 {
					 Insert();
				 }
			
				 
			 }
	
		 
		
		
			
	
	
	void display()
	{
		Client ptr;
		
		
		for(int i=0;i<max;i++)
		{
			ptr=Head[i];
			System.out.print(i+"\t---->");
						
				while(ptr!=null)
				{
					System.out.print("|"+ptr.cid+"\t"+ptr.name+"\t"+ptr.mob+"|---->");	
					ptr=ptr.next;
				}
				System.out.println("NULL");
				System.out.println();
				
			}
		}
	
	
	void search()
	{
		int flag=0;
		
		System.out.println("Enter the Client ID which you wish to search");
		int s=sc.nextInt();
		int h=hashval(s);
		Client ptr=null;
		
		if(Head[h]==null)
		{	
			flag=0;
		}
		else
		{
		ptr=Head[h];
		
		if(ptr.cid==s)
		{
			flag=1;
			System.out.println(" Record found!!");
			
		}
		else
		{
			while(ptr!=null)
			{
				if(ptr.cid==s)
				{
					flag=1;
					System.out.println(" Record found!!");
					break;
				}
				ptr=ptr.next;
			}
		}
		}
		
		
		
		if(flag==0)
		{
			System.out.println("Record not found in Client Details!!!");
		}
		else
		{
			System.out.println("ID = "+ptr.cid);
			System.out.println("Name = "+ptr.name);
			System.out.println("Tele = "+ptr.mob);
		
		}
	}
	
	}


public class HashTable 
{
public static void main(String args[])
{
	Hashing h=new Hashing();
	
	h.create();
	
	Scanner sc=new Scanner(System.in);
	int ch;
	while(true)
	{
    System.out.println("");
	System.out.println("===========MENU=========");
	System.out.println("");
	System.out.println("1.Insert Client Details");
	System.out.println("2.Search Client Details");
	System.out.println("3.Display Client Details");
	System.out.println("");
	System.out.println("");
	System.out.println("Enter your choice :");
	ch=sc.nextInt();
	System.out.println("");
	switch(ch)
	{
	case 1:
		h.Insert();
		break;
		
	case 2:
		h.search();
		break;
		
	case 3:
		h.display();
		break;
		
	
			
	}
	}
}
}




/*


OUTPUT:


===========MENU=========

1.Insert Client Details
2.Search Client Details
3.Display Client Details


Enter your choice :
1

Enter the Client ID : 23
Enter the Client Name : dfff
Enter the Client Phone no : 43553
0	---->NULL

1	---->NULL

2	---->NULL

3	---->|23	dfff	43553|---->NULL

4	---->NULL

5	---->NULL

6	---->NULL

7	---->NULL

8	---->NULL

9	---->NULL

Do you wish to insert again? If yes, press 1
1
Enter the Client ID : 73
Enter the Client Name : gdsg
Enter the Client Phone no : 54643
0	---->NULL

1	---->NULL

2	---->NULL

3	---->|73	gdsg	54643|---->|23	dfff	43553|---->NULL

4	---->NULL

5	---->NULL

6	---->NULL

7	---->NULL

8	---->NULL

9	---->NULL

Do you wish to insert again? If yes, press 1
1
Enter the Client ID : 10
Enter the Client Name : rete
Enter the Client Phone no : 5355
0	---->|10	rete	5355|---->NULL

1	---->NULL

2	---->NULL

3	---->|73	gdsg	54643|---->|23	dfff	43553|---->NULL

4	---->NULL

5	---->NULL

6	---->NULL

7	---->NULL

8	---->NULL

9	---->NULL

Do you wish to insert again? If yes, press 1
0

===========MENU=========

1.Insert Client Details
2.Search Client Details
3.Display Client Details


Enter your choice :
3

0	---->|10	rete	5355|---->NULL

1	---->NULL

2	---->NULL

3	---->|73	gdsg	54643|---->|23	dfff	43553|---->NULL

4	---->NULL

5	---->NULL

6	---->NULL

7	---->NULL

8	---->NULL

9	---->NULL


===========MENU=========

1.Insert Client Details
2.Search Client Details
3.Display Client Details


Enter your choice :
2

Enter the Client ID which you wish to search
55
Record not found in Client Details!!!

===========MENU=========

1.Insert Client Details
2.Search Client Details
3.Display Client Details


Enter your choice :
2

Enter the Client ID which you wish to search
23
Record found!!
ID = 23
Name = dfff
Tele = 43553




*/
