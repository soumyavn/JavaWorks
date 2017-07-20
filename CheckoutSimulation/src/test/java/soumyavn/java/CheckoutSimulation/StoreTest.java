package soumyavn.java.CheckoutSimulation;
import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;
import java.io.*;

public class StoreTest extends TestCase {

	public StoreTest( String testName )
    	{
        	super( testName );
    	}
	 public static Test suite()
   	 {
        	return new TestSuite( StoreTest.class );
    	}
 	public void testStore()
    	{
        	assertTrue( true );
    	}
	public void testprocessInput() throws Exception{
		
		Store.processInput(new File("samples/sample1.txt")); 									//testing based on sample1.txt
		assertEquals(1,Store.registerCount);
		assertEquals('A', Store.customers.get(0).customerType);
		assertEquals(1, Store.customers.get(0).arrivalTime);
		assertEquals(2, Store.customers.get(0).cartItems);
		assertEquals('A', Store.customers.get(1).customerType);
		assertEquals(2, Store.customers.get(1).arrivalTime);
		assertEquals(1, Store.customers.get(1).cartItems);
	}

}
