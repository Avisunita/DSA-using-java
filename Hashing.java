import java.util.Scanner;

class account
{
	int accno,bal;
	String name;
	
	account(String nm,int ano,int b)
	{
		name=nm;
		accno=ano;
		bal=b;
	}
	
	account()
	{
		name="";
		accno=0;
		bal=0;
	}
	
}

class Hash
{
	int sz;
	account hasht[];
	Scanner sc=new Scanner(System.in);
	
	Hash(int s)
	{
		sz=s;
		
	}
	
	void create()
	{
		hasht=new account[sz];
		
		for(int i=0;i<sz;i++)
			hasht[i]=new account();
	
		System.out.print("Enter no. of records : ");
		int n=sc.nextInt();
		
		for(int i=0;i<n;i++)
			insert();
		
		display();
		
	}
	
	void insert()
	{
		if(isFull()==1)
		{
			System.out.println("Table is empty!");
			return;
		}
		
		System.out.print("Enter account no. : ");
		int acno=sc.nextInt();
		
		System.out.print("Enter accholder name: ");
		String nm=sc.next();
		
		System.out.print("Enter balance: ");
		int b=sc.nextInt();
		
		account temp=new account(nm,acno,b);
		
		int pos=hash(acno);
		
		if(hasht[pos].accno==0)
		{
			hasht[pos]=temp;
		}
		else
		{

			for(int i=(pos+1)%sz;i%sz!=pos;i%=sz)
			{
				if(hasht[i].accno==0)
				{
					hasht[i]=temp;
					break;
				}
				i++;
			}
				
		}
		
		
		System.out.println("Data inserted!");	
		
	}
	
	void search()
	{
		if(isEmpty()==1)
		{
			System.out.println("Table is empty...nothing to search!");
			return;
		}
		
		System.out.println("Enter the Account no you want to Search : ");
		int key=sc.nextInt();
		int flag=0;
		int pos=hash(key);


		if(hasht[pos].accno==key)
		{
			System.out.println(key+" is found at "+pos+" location!!!");
			flag=1;
		}
		else
		{
			for(int i=(pos+1)%sz;i%sz!=pos;i%=sz)
			{
				if(hasht[i].accno==key)
				{
					System.out.println(key+" is found at "+i+" location!!!");
					flag=1;

					break;		
				}
				i++;
			}
		}
		
		if(flag==0)
		{
			System.out.println("Account not Found !!!");
		}

	}
	
	
	void del()
	{
		if(isEmpty()==1)
		{
			System.out.println("Table is empty...nothing to delete!");
			return;
		}
		
		System.out.println("Enter the Account no you want to delete : ");
		int key=sc.nextInt();
		int flag=0;
		int pos=hash(key);


		if(hasht[pos].accno==key)
		{
			hasht[pos]=new account();
			flag=1;
		}
		else
		{
			for(int i=(pos+1)%sz;i%sz!=pos;i%=sz)
			{
				if(hasht[i].accno==key)
				{
					hasht[i]=new account();
					flag=1;

					break;		
				}
				i++;
			}
		}
		
		if(flag==0)
		{
			System.out.println("Account not Found !!!");
		}
		else
		{
			System.out.println("Account Deleted!!!");
		}

	}
	
	
	int isFull()
	{
		int count=0;
		for(int i=0;i<sz;i++)
		{
			if(hasht[i].accno!=0)
			{
				count++;
			}
			else
				break;
		}
		
		if(count==sz)
			return 1;
		else
			return 0;
	}
	
	int isEmpty()
	{
		int count=0;
		for(int i=0;i<sz;i++)
		{
			if(hasht[i].accno==0)
			{
				count++;
			}
			else
				break;
		}
		
		if(count==sz)
			return 1;
		else
			return 0;
	}
	
	int hash(int key)
	{
		return key%sz;
	}
	
	
	void display()
	{
		if(isEmpty()==1)
		{
			System.out.println("Table is empty...nothing to display!");
			return;
		}
		
		System.out.println("Index\t\tAcc no\t\tName\t\tBalance");
		for(int i=0;i<sz;i++)
		{
			System.out.print(i+"\t\t");
			if(hasht[i].accno!=0)
			{
				System.out.print(hasht[i].accno+"\t\t"+hasht[i].name+"\t\t"+hasht[i].bal);
			}		
			System.out.println();
		}
		
	}

}
public class LinearProbe 
{
	public static void main(String args[])
	{
		Hash h=new Hash(10);
		
		Scanner sc=new Scanner(System.in);
		int ch;
		
		do
		{
			System.out.println("\n------MENU------");
			System.out.println("1.Create");
			System.out.println("2.Insert");
			System.out.println("3.Search");
			System.out.println("4.Delete");
			System.out.println("5.Display");
			System.out.println("6.Exit");
			System.out.println("----------------\n");

			System.out.println("Enter your choice");
			ch=sc.nextInt();
			System.out.println("----------------\n");
			
			switch(ch)
			{
				case 1:
						h.create();						
						break;
						
				case 2:
						h.insert();						
						break;
						
				case 3:
						h.search();						
						break;
						
				case 4:
						h.del();
						break;
						
				case 5:
						h.display();
						break;
				
						
			}
		}while(ch>0&&ch<6);
	}
	
}


/*


OUTPUT:


------MENU------
1.Create
2.Insert
3.Search
4.Delete
5.Display
6.Exit
----------------

Enter your choice
1
----------------

Enter no. of records : 3
Enter account no. : 12
Enter accholder name: dsfs
Enter balance: 1312
Data inserted!
Enter account no. : 22
Enter accholder name: wff
Enter balance: 2323
Data inserted!
Enter account no. : 23
Enter accholder name: dsvfd
Enter balance: 23322
Data inserted!
Index           Acc no          Name            Balance
0               0                               0
1               0                               0
2               12              dsfs            1312
3               22              wff             2323
4               23              dsvfd           23322
5               0                               0
6               0                               0
7               0                               0
8               0                               0
9               0                               0

------MENU------
1.Create
2.Insert
3.Search
4.Delete
5.Display
6.Exit
----------------

Enter your choice
3
----------------

Enter the Account no you want to Search :
22
22 is found at 3 location!!!

------MENU------
1.Create
2.Insert
3.Search
4.Delete
5.Display
6.Exit
----------------

Enter your choice
3
----------------

Enter the Account no you want to Search :
24
Account not Found !!!

------MENU------
1.Create
2.Insert
3.Search
4.Delete
5.Display
6.Exit
----------------

Enter your choice
5
----------------

Index           Acc no          Name            Balance
0               0                               0
1               0                               0
2               12              dsfs            1312
3               22              wff             2323
4               23              dsvfd           23322
5               0                               0
6               0                               0
7               0                               0
8               0                               0
9               0                               0

------MENU------
1.Create
2.Insert
3.Search
4.Delete
5.Display
6.Exit
----------------

Enter your choice
4
----------------

Enter the Account no you want to delete :
22

------MENU------
1.Create
2.Insert
3.Search
4.Delete
5.Display
6.Exit
----------------

Enter your choice
5
----------------

Index           Acc no          Name            Balance
0               0                               0
1               0                               0
2               12              dsfs            1312
3               0                               0
4               23              dsvfd           23322
5               0                               0
6               0                               0
7               0                               0
8               0                               0
9               0                               0

------MENU------
1.Create
2.Insert
3.Search
4.Delete
5.Display
6.Exit
----------------

Enter your choice
4
----------------

Enter the Account no you want to delete :
12

------MENU------
1.Create
2.Insert
3.Search
4.Delete
5.Display
6.Exit
----------------

Enter your choice
5
----------------

Index           Acc no          Name            Balance
0               0                               0
1               0                               0
2               0                               0
3               0                               0
4               23              dsvfd           23322
5               0                               0
6               0                               0
7               0                               0
8               0                               0
9               0                               0

------MENU------
1.Create
2.Insert
3.Search
4.Delete
5.Display
6.Exit
----------------

Enter your choice
4
----------------

Enter the Account no you want to delete :
23

------MENU------
1.Create
2.Insert
3.Search
4.Delete
5.Display
6.Exit
----------------

Enter your choice
5
----------------

Index           Acc no          Name            Balance
0               0                               0
1               0                               0
2               0                               0
3               0                               0
4               0                               0
5               0                               0
6               0                               0
7               0                               0
8               0                               0
9               0                               0

------MENU------
1.Create
2.Insert
3.Search
4.Delete
5.Display
6.Exit
----------------

Enter your choice
3
----------------

Table is empty...nothing to search!

------MENU------
1.Create
2.Insert
3.Search
4.Delete
5.Display
6.Exit
----------------

Enter your choice
4
----------------

Table is empty...nothing to delete!

*/
