package soumyavn.java.CheckoutSimulation;
import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

public class CustomerTest extends TestCase {

	public CustomerTest( String testName )
    	{
        	super( testName );
    	}
	 public static Test suite()
   	 {
        	return new TestSuite( CustomerTest.class );
    	}
	public void testfindRegister() {
		
		//Assume 2 registers in the store
			Store.registers.add(new Register(false));
			Store.registers.add(new Register(true));
			Store.registerCount=2;
			
		//Assume both registers are empty
			Customer c=new Customer('A',1,2);
			c.findRegister();
			assertEquals(0,c.regIndex);   //index of register to which the customer will be assigned
			
		//Assume Register1 has 1 customer in line and Register2 is empty
			c=new Customer('B',2,1);
			c.findRegister();
			assertEquals(1,c.regIndex);
			
		//Assume the last customer of Register1 has 2 items and that of Register2 has 1 item left to check out
			c=new Customer('B',3,1);
			c.findRegister();
			assertEquals(1,c.regIndex);
			
		//Assume RegisterI has 1 and Register2 has 2 customers in line
			c=new Customer('A',4,1);
			c.findRegister();
			assertEquals(0,c.regIndex);
		
		
	}

	
	public void testCompareTo() {
		Customer c=new Customer('A',1,2);
		int result=c.compareTo(new Customer('A',2,1));
		assertEquals(-1,result);
		
		c=new Customer('A',1,3);
		result=c.compareTo(new Customer('A',1,2));
		assertEquals(1,result);
		
		c=new Customer('A',1,3);
		result=c.compareTo(new Customer('B',1,3));
		assertEquals(-1,result);
			
	}
	

}
