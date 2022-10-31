/*

	Rollno	:	2965
	Title	:	To learn file organization and perform operations on it.
	
*/


import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileInputStream;
import java.lang.ClassNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.Iterator;
import java.util.Vector;
import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.util.Scanner;
import java.io.Serializable;


class Student implements Serializable
{
	int rollno;
	String name;
	int mark;
	
	Student(int rno,String nm,int m)
	{
		rollno=rno;
		name=nm;
		mark=m;
		
	}
	public String toString()
	{
		return "Student " + "id =\t" + rollno + ",\tname =\t"+name+",\tmark =\t"+mark; 
	}
}

class fileOprtn
{
	
	Scanner sc= new Scanner(System.in);
	Student s;
	Vector<Student> v=new Vector<Student>();
	File f=new File("objtest.txt");
	
	
	void write()
	{	
		
		System.out.println("Enter the number of records: ");
		int n=sc.nextInt();
		
		for(int i=0;i<n;i++)
		{
			System.out.print("Enter the rollno: ");
			int rno=sc.nextInt();
			
			System.out.print("Enter the name: ");
			String nm=sc.next();
			
			System.out.print("Enter the marks: ");
			int m=sc.nextInt();
			
			System.out.println();
			
			s=new Student(rno,nm,m);
			v.add(s);
		}
				
		
		try
		{
			FileOutputStream fos=new FileOutputStream(f);
			ObjectOutputStream os=new ObjectOutputStream(fos);
			
			os.writeObject(v);
			
			os.close();
			fos.close();
			
			System.out.println("Data written successfully! ");
			
		}
		catch(FileNotFoundException ex)
		{
			ex.printStackTrace();
		}
		catch(IOException ex)
		{
			ex.printStackTrace();
		}		
				
	}
	
	
	void create()
	{
		
		Vector<Student> v=new Vector<Student>();
		
		System.out.println("Enter the number of records: ");
		int n=sc.nextInt();
		
		for(int i=0;i<n;i++)
		{
			System.out.print("Enter the rollno: ");
			int rno=sc.nextInt();
			
			System.out.print("Enter the name: ");
			String nm=sc.next();
			
			System.out.print("Enter the marks: ");
			int m=sc.nextInt();
			
			System.out.println();
			
			s=new Student(rno,nm,m);
			v.add(s);
		}
				
		
		try
		{
			FileOutputStream fos=new FileOutputStream(f);
			ObjectOutputStream oos=new ObjectOutputStream(fos);
			
			oos.writeObject(v);
			
			oos.close();
			fos.close();
			
			
			System.out.println("Data written successfully!");
			
		}
		catch(FileNotFoundException ex)
		{
			ex.printStackTrace();
		}
		catch(IOException ex)
		{
			ex.printStackTrace();
		}
				
	}
	
	
	void read()
	{
		
		if(f.length()==0||f.length()==167)
		{
			System.out.println("File empty !!");
			return;
		}
		
		try
		{
			FileInputStream fins=new FileInputStream(f);
			ObjectInputStream ois=new ObjectInputStream(fins);
			v=(Vector<Student>)ois.readObject();
			
			Iterator<Student> iter=v.iterator();
			
			System.out.println();
			while(iter.hasNext())
			{
				s=iter.next();
				System.out.println(s);
			}
	
			
			ois.close();
			fins.close();
			
			
		}
		catch(FileNotFoundException ex)
		{
			ex.printStackTrace();
		}
		catch(IOException ex)
		{
			ex.printStackTrace();
		}
		catch(ClassNotFoundException ex)
		{
			ex.printStackTrace();
		}
	
		
		
	}
	
	
	void search()
	{
		
		if(f.length()==0||f.length()==167)
		{
			System.out.println("File empty !!");
			return;
		}
		
		
		System.out.println("Enter the rollno to be searched");
		int key=sc.nextInt();
		int flag=0;
		
		try
		{
			FileInputStream fins=new FileInputStream(f);
			ObjectInputStream ois=new ObjectInputStream(fins);
			v=(Vector<Student>)ois.readObject();
			
			Iterator<Student> iter=v.iterator();
			
			while(iter.hasNext())
			{
				s=iter.next();
				if(key==s.rollno)
				{
					flag=1;
					break;
				}
			}
			
			if(flag==1)
			{
				System.out.println("Record found! ");
				System.out.println(s);
			}
			else
			{
				System.out.println("Record not found! ");
			}
			
			
			ois.close();
			fins.close();
			
		}
		catch(FileNotFoundException ex)
		{
			ex.printStackTrace();
		}
		catch(IOException ex)
		{
			ex.printStackTrace();
		}
		catch(ClassNotFoundException ex)
		{
			ex.printStackTrace();
		}
		
	}
	
	
	
	void delete()
	{
		if(f.length()==0||f.length()==167)
		{
			System.out.println("File empty !!");
			return;
		}
		
		
		File tempf=new File("Tempfile.txt");
		Vector<Student> nv=new Vector<Student>();
		
		System.out.println("Enter rno of student to be deleted : ");
		int key=sc.nextInt();
		int flag=0;
		
		try
		{
			FileInputStream fins=new FileInputStream(f);
			ObjectInputStream ois=new ObjectInputStream(fins);
			v=(Vector<Student>)ois.readObject();
			
			Iterator<Student> iter=v.iterator();
			
			while(iter.hasNext())
			{
				s=iter.next();
				if(key==s.rollno)
				{
					flag=1;
					System.out.println("Record Found!");
					System.out.println(s);
				}
				else
				{
					nv.add(s);					
				}
			}
			
			
			ois.close();
			fins.close();
			
			if(flag==1)
			{
				
				FileOutputStream fos=new FileOutputStream(tempf);
				ObjectOutputStream os=new ObjectOutputStream(fos);
				
				os.writeObject(nv);
				
				os.close();
				fos.close();
				
				System.out.println("\nDeletion successfull! ");		
				
				f.delete();
				tempf.renameTo(f);
				
				read();
				
			}
			else
			{
				System.out.println("Record not found! ");		
				tempf.delete();
			}
			
			
		}
		
		catch(FileNotFoundException ex)
		{
			ex.printStackTrace();
		}
		catch(IOException ex)
		{
			ex.printStackTrace();
		}
		catch(ClassNotFoundException ex)
		{
			ex.printStackTrace();
		}
		
	}
	
	
	void update()
	{
		if(f.length()==0||f.length()==167)
		{
			System.out.println("File empty !!");
			return;
		}
		
		
		File tempf=new File("Tempfile.txt");
		Vector<Student> nv=new Vector<Student>();
		
		System.out.println("Enter rno of student to be updated: ");
		int key=sc.nextInt();
		int flag=0;
		
		try
		{
			FileInputStream fins=new FileInputStream(f);
			ObjectInputStream ois=new ObjectInputStream(fins);
			v=(Vector<Student>)ois.readObject();
			
			Iterator<Student> iter=v.iterator();
			
			while(iter.hasNext())
			{
				s=iter.next();
				if(key==s.rollno)
				{
					flag=1;
					
					System.out.println("Enter the updated rno");
					int newrno=sc.nextInt();
					
					System.out.println();
					
					System.out.println("Before updating: ");
					System.out.println(s);
					
					System.out.println();					
					
					s=new Student(newrno,s.name,s.mark);
					
					nv.add(s);
					
					System.out.println("After updating: ");
					System.out.println(s);
					
				}
				else
				{
					nv.add(s);					
				}
			}
			
			
			ois.close();
			fins.close();
			
			if(flag==1)
			{
				
				FileOutputStream fos=new FileOutputStream(tempf);
				ObjectOutputStream os=new ObjectOutputStream(fos);
				
				os.writeObject(nv);
				
				os.close();
				fos.close();
				
				System.out.println("\nUpdation successfull! ");		
				
				f.delete();
				tempf.renameTo(f);
				
				read();
				
			}
			else
			{
				System.out.println("Record not found! ");		
				tempf.delete();
			}
			
			
		}
		
		catch(FileNotFoundException ex)
		{
			ex.printStackTrace();
		}
		catch(IOException ex)
		{
			ex.printStackTrace();
		}
		catch(ClassNotFoundException ex)
		{
			ex.printStackTrace();
		}
		
	}
	
	
}

public class assign8
{
	public static void main(String args[])
	{
		fileOprtn f=new fileOprtn();
		
		Scanner sc=new Scanner(System.in);
		int ch;

		
		
		do
		{	
			System.out.println("\n\n------------");
			System.out.println("----MENU----");
			System.out.println("1.Write");
			System.out.println("2.Read");
			System.out.println("3.Search");
			System.out.println("4.Delete");
			System.out.println("5.Create");
			System.out.println("6.Update");
			System.out.println("7.Exit");
			System.out.println("------------");
			System.out.println();
			
			System.out.println("Enter your choice: ");
			ch=sc.nextInt();
		
			switch(ch)
			{
				case 1:					
						f.write();
						break;
			
				case 2:	
						f.read();	
						break;	
						
				case 3:	
						f.search();	
						break;	
						
				case 4:	
						f.delete();	
						break;
						
				case 5:	
						f.create();	
						break;
						
				case 6:	
						f.update();	
						break;
			}
			
		
		}while(ch>0&&ch<7);	
	
	}
}


/*


OUTPUT:



------------
----MENU----
1.Write
2.Read
3.Search
4.Delete
5.Exit
------------

Enter your choice: 
1
Enter the number of records: 
3
Enter the rollno: 1
Enter the name: abc
Enter the marks: 45

Enter the rollno: 2
Enter the name: dgd
Enter the marks: 67

Enter the rollno: 
3
Enter the name: fgdg
Enter the marks: 78

Data written successfully! 


------------
----MENU----
1.Write
2.Read
3.Search
4.Delete
5.Exit
------------

Enter your choice: 
2

Student id =	1,	name =	abc,	mark =	45
Student id =	2,	name =	dgd,	mark =	67
Student id =	3,	name =	fgdg,	mark =	78


------------
----MENU----
1.Write
2.Read
3.Search
4.Delete
5.Exit
------------

Enter your choice: 
3
Enter the rollno to be searched
2
Record found! 
Student id =	2,	name =	dgd,	mark =	67


------------
----MENU----
1.Write
2.Read
3.Search
4.Delete
5.Exit
------------

Enter your choice: 
3
Enter the rollno to be searched
4
Record not found! 


------------
----MENU----
1.Write
2.Read
3.Search
4.Delete
5.Exit
------------

Enter your choice: 
4
Enter rno of student to be deleted : 
4
Record not found! 


------------
----MENU----
1.Write
2.Read
3.Search
4.Delete
5.Exit
------------

Enter your choice: 
4
Enter rno of student to be deleted : 
2
Record Found!
Student id =	2,	name =	dgd,	mark =	67

Deletion successfull! 

Student id =	1,	name =	abc,	mark =	45
Student id =	3,	name =	fgdg,	mark =	78


------------
----MENU----
1.Write
2.Read
3.Search
4.Delete
5.Exit
------------

Enter your choice: 
5


*/
