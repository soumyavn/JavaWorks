package soumyavn.java.CheckoutSimulation;

public class Customer implements Comparable<Customer> {
	public char customerType;
	public int arrivalTime;
	public int cartItems;
	public int regIndex=-1;
	
	public Customer(char customerType,int arrivalTime, int cartItems)
	{
		this.customerType=customerType;
		this.arrivalTime=arrivalTime;
		this.cartItems=cartItems;
	}
	public void findRegister()
	{
		for(int i=0;i<Store.registerCount;i++)
		{
			if(Store.registers.get(i).waitLine==0)
			{
				regIndex=i;
				break;
			}
		}
		if(regIndex==-1)
		{
			regIndex=0;
			int tempSize=Store.registers.get(0).customerLine.size();
			int tempItems=Store.registers.get(0).customerLine.peekLast().cartItems;
			if (customerType=='A')
			{
				for(int i=1;i<Store.registerCount;i++)
				{
					if(Store.registers.get(i).customerLine.size()<tempSize)
					{
						regIndex=i;
						tempSize=Store.registers.get(i).customerLine.size();
					}
				}
			}
			else if(customerType=='B')
			{
				for(int i=0;i<Store.registerCount;i++)
				{
					if (Store.registers.get(i).customerLine.peekLast().cartItems< tempItems)
					{
						regIndex=i;
						tempItems=Store.registers.get(i).customerLine.peekLast().cartItems;
					}
				}
			}
		}
		Store.registers.get(regIndex).customerLine.addLast(this);
		Store.registers.get(regIndex).waitLine++;
		if(regIndex==(Store.registerCount)-1)
			Store.registers.get(regIndex).timeToProcess=Store.registers.get(regIndex).timeToProcess + 2*cartItems;
		else
			Store.registers.get(regIndex).timeToProcess=Store.registers.get(regIndex).timeToProcess + cartItems;
		
	}
	
	public int compareTo(Customer c)
	{
		
	    if(this.arrivalTime>c.arrivalTime)
	    	return 1;
	    else if(this.arrivalTime==c.arrivalTime)
	    {
	    	if(this.cartItems>c.cartItems)
	    		return 1;
	    	else if((this.cartItems==c.cartItems) && (this.customerType>c.customerType ))
	    		return 1;
	    	else 
	    		return -1;
	    }
	    else
	    	return -1;
	}
				
}

