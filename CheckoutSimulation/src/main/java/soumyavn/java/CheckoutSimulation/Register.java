package soumyavn.java.CheckoutSimulation;
import java.util.*;

public class Register {
	public Deque<Customer> customerLine=new LinkedList<Customer>();
	public int waitLine=0;
	boolean trainee;
	public int timeToProcess=0;
	public Register(boolean trainee)
	{
		this.trainee=trainee;
	}
	public void checkoutProcess(int arrivalTime)
	{		
		if(waitLine!=0)
		{
			int time;
			time=Store.currentTime;
			while(time<arrivalTime)
			{
				time++;
				timeToProcess--;
				if(trainee==false)
					customerLine.getFirst().cartItems--;
				else
					if((timeToProcess%2)==0)
					{
						customerLine.getFirst().cartItems--;
					}
				if(customerLine.getFirst().cartItems==0)
				{
					customerLine.removeFirst();
					waitLine=waitLine-1;		
					if(waitLine==0)
						break;
				}
			}
		}
	}
}
