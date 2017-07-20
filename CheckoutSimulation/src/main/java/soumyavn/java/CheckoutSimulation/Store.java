package soumyavn.java.CheckoutSimulation;
import java.util.*;
import java.io.*;

public class Store {
	public static int registerCount;
	public static int currentTime;
	public static ArrayList<Register> registers= new ArrayList<Register>();
	public static ArrayList<Customer> customers=new ArrayList<Customer>();
	
	public static void main(String[] args) {
		
		int tempTime;
		currentTime=0;
		
			
		try{	
			//sort customers based on arrival and properties
			if (readFile()==1)
			{
				Collections.sort(customers);		
				
				//Create register list
				
				for(int i=0;i<registerCount;i++)
				{
					if(i==registerCount-1)
						registers.add(i, new Register(true));
					else
						registers.add(i,new Register(false));
				}
				registerCount=registers.size();
			
				//Get each register's waitline status at the time of customer arrival 
			
				for(int i=0;i<customers.size();i++)
				{
					for(int j=0;j<registerCount;j++)
					{
						registers.get(j).checkoutProcess(customers.get(i).arrivalTime);
					}
					currentTime=customers.get(i).arrivalTime;
					customers.get(i).findRegister();
				}
		
			//Computing the total time taken to process
			
				tempTime=registers.get(0).timeToProcess;
				for(int i=1;i<registerCount;i++)
				{
					if(registers.get(i).timeToProcess>tempTime)
					tempTime= registers.get(i).timeToProcess;
				}
				currentTime=currentTime+tempTime;
				System.out.println("Finished at: t=" + currentTime + " minutes");
			}
		}
		catch(Exception e)
		{
			System.out.println("Error on File");
		
		}
		
	}
		
	public static int readFile()
	{       
		String input;       
        System.out.println("Enter File path");
        Scanner sc = new Scanner(System.in);
        input=sc.nextLine();
        sc.close();
        File f= new File(input);
        return(processInput(f));
                
	}     
    public static int processInput(File f)
    {
    	char customerType;
        int arrivalTime;
        int cartTotal;
        try
        {
        	Scanner sc=new Scanner(f);
        	registerCount=sc.nextInt();
        	
        	//Create customer objects and add them to the list
        	
            while(sc.hasNextLine())
            {
            	customerType=sc.next().charAt(0);
            	arrivalTime= sc.nextInt();
            	cartTotal=sc.nextInt();
            	if(customerType=='A'||customerType=='B')
            		customers.add(new Customer(customerType,arrivalTime,cartTotal));
            	else
            	{
            		sc.close();
            		throw new InputMismatchException();
            	}
        				
            }
            sc.close();
            return 1;
        }
        catch(InputMismatchException ex) {
        	System.out.println( "Error on file format" );
        	return 0;
        }
        catch(FileNotFoundException ex) {
        	System.out.println( "Unable to open file" );
            return 0;
        }
       
	}   
        
}






