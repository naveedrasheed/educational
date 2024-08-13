import java.util.Scanner;
public class BookShop
{
	Scanner input;
	String title[];
	int price[];
	int quantity[];
	int revnue;
	int numberOfBooks;
	int arraySize=10;
	
	BookShop()
	{
		input=new Scanner(System.in);
		title=new String[arraySize];
		price=new int[arraySize];
		quantity=new int[arraySize];
		revnue=0;
		numberOfBooks=0;
	}
	
	public static void main (String[] args)
	{
		BookShop call=new BookShop();
		int op=0;
		
		System.out.println("Welcome To Book Shop");
		do
		{
			op=call.displayOptions();
			switch(op)
			{
				case 1:
					call.addNewBook();
					break;
				case 2:
					call.listOfAllBooks();
					break;
				case 3:
					call.saleBook();
					break;
				case 4:
					call.totalRevene();
					break;
				case 5:
					break;
				default:
					System.out.println("Enter a valid option");
			}
		}
		while(op!=5);
	}
	
	int displayOptions()
	{
		System.out.println("\nPlease Select From the Following Menu\n");
		System.out.println("To Add a new Book in the Stock 					  Press 1");
		System.out.println("To Print Detailed List of All books in the Stock  Press 2");
		System.out.println("To Sale a Book 									  Press 3");
		System.out.println("To Print Total Revenue 							  Press 4");
		System.out.println("To Exit 										  Press 5");
		
		return input.nextInt();
	}
	
	void addNewBook()
	{
		if(numberOfBooks==10)
			System.out.println("There is no enough room for new book");
		else
		{
			System.out.println("Enter The Title Of The Book");
			title[numberOfBooks]=input.next();
		
			if(numberOfBooks==0)
				setPriceAndQuantity();
			else if(searchBook(title[numberOfBooks]) != -1)
				System.out.println("The Book is Already in List\n");
			else
				setPriceAndQuantity();
		}
	}
	
	void listOfAllBooks()
	{
		System.out.println("Title\t\tPrice\t\tQuantity");
		for(int j=0; j< numberOfBooks; j++)
			System.out.println(title[j]+"\t\t\t"+price[j]+"\t\t\t"+quantity[j]);
	}
	
	int searchBook(String name)
	{
		String bookToSearch=name;
		int check=-1;
		for(int k=0; k<numberOfBooks ; k++)
			{
				if(title[k].equals(bookToSearch))
				{
					check=k;
					break;
				}
				else
					check=-1;
			}
		return check;
	}
	
	void saleBook()
	{
		System.out.println("Enter the Title");
		String name=input.next();
		
		int loc=searchBook(name);
		if(loc == -1)
		{
			if(name.equals(title[numberOfBooks]))
			{
				loc=numberOfBooks;
				quantity[loc]=quantity[loc]-1;
				revnue+=price[loc];
				if(quantity[loc]==0)
					deleteBook(loc);
			}
			else
				System.out.println("Requested book is out of Stock");
		}
		else
		{
			quantity[loc]=quantity[loc]-1;
			revnue+=price[loc];
			if(quantity[loc]==0)
				deleteBook(loc);
		}
	}
	void deleteBook(int s)
	{
		int swapPrice;
		int swapQuantity;
		String swapTitle;
		
		for (int i = s; i<numberOfBooks; i++)
		{
			swapTitle=title[i];
			title[i]=title[i+1];
			title[i+1]=swapTitle;
			
			swapPrice=price[i];
			price[i]=price[i+1];
			price[i+1]=swapPrice;
			
			swapQuantity=quantity[i];
			quantity[i]=quantity[i+1];
			quantity[i+1]=swapQuantity;
		}
		numberOfBooks--;
	}
	
	void totalRevene()
	{
		System.out.println("The revenue is "+revnue);
	}
	
	void setPriceAndQuantity()
	{
		System.out.println("Enter Price of the Book");
		price[numberOfBooks]=input.nextInt();
		System.out.println("Enter the Quantity of the Book");
		quantity[numberOfBooks]=input.nextInt();
		
		numberOfBooks++;
	}
}