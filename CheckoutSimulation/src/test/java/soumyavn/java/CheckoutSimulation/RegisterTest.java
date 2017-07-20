package soumyavn.java.CheckoutSimulation;
import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

public class RegisterTest extends TestCase{

	
	public void testCheckoutProcess() {
		
		
		//A regular register		
			Store.currentTime=0;
			Register r=new Register(false); 
		
		//customer comes at minute 1 with 2 items
			Customer c1=new Customer('A',1,2);
			Store.currentTime=1;
			r.customerLine.add(c1);
			r.timeToProcess=2;
			r.waitLine=1;
		//Time needed to finish & waitline status line at minute 2
			r.checkoutProcess(2); 
			assertEquals(1,r.timeToProcess);
			assertEquals(1,r.waitLine);
		//customer comes at minute 1 with 2 items
			Customer c2=new Customer('B',2,1);
			Store.currentTime=2;
			r.customerLine.add(c2);
			r.timeToProcess=2;
			r.waitLine=2;
		//Time needed to finish & waitline status line at minute 3
			r.checkoutProcess(3); 
			assertEquals(1,r.timeToProcess);
			assertEquals(1,r.waitLine);
			Store.currentTime=3;
		//Time needed to finish & waitline status line at minute 4
			r.checkoutProcess(4); 
			assertEquals(0,r.timeToProcess);
			assertEquals(0,r.waitLine);
			Store.currentTime=4;
		
		//A trainee register		
			Store.currentTime=0;
			r=new Register(true); 
		
		//customer comes at minute 1 with 2 items
			c1=new Customer('A',1,2);
			Store.currentTime=1;
			r.customerLine.add(c1);
			r.timeToProcess=4;
			r.waitLine=1;
		//Time needed to finish & waitline status line at minute 2
			r.checkoutProcess(2); 
			assertEquals(3,r.timeToProcess);
			assertEquals(1,r.waitLine);
		//customer comes at minute 1 with 2 items
			c2=new Customer('B',2,1);
			Store.currentTime=2;
			r.customerLine.add(c2);
			r.timeToProcess=5;
			r.waitLine=2;
		//Time needed to finish & waitline status line at minute 3
			r.checkoutProcess(3); 
			assertEquals(4,r.timeToProcess);
			assertEquals(2,r.waitLine);
			Store.currentTime=3;
		//Time needed to finish & waitline status line at minute 4
			r.checkoutProcess(4); 
			assertEquals(3,r.timeToProcess);
			assertEquals(2,r.waitLine);
			Store.currentTime=4;
		//Time needed to finish & waitline status line at minute 5
			r.checkoutProcess(5); 
			assertEquals(2,r.timeToProcess);
			assertEquals(1,r.waitLine);
			Store.currentTime=5;
		//Time needed to finish & waitline status line at minute 6
			r.checkoutProcess(6); 
			assertEquals(1,r.timeToProcess);
			assertEquals(1,r.waitLine);
			Store.currentTime=6;
		//Time needed to finish & waitline status line at minute 7
			r.checkoutProcess(7); 
			assertEquals(0,r.timeToProcess);
			assertEquals(0,r.waitLine);
			Store.currentTime=7;



		
	
	}

}
