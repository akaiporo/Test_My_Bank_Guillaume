package metier.test;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import metier.TransactionType;

public class TestTransactionType {
	
	private TransactionType tested;
	
	@Before
	public void initTested(){
		this.tested=new TransactionType("foo");
		this.tested.setId(1);
	}
	

	@Test(expected = IllegalArgumentException.class)
	public void testTransactionType_IsEmpty() {
		new TransactionType("");
	}	
	@Test(expected = NullPointerException.class)
	public void testTransactionType_IsNull() {
		new TransactionType(null);
	}
	
	
	@Test
	public void testGetId() {
		assertEquals(1,this.tested.getId());
	}
	@Test(expected = IllegalArgumentException.class)
	public void testSetId_Invalid() {
		this.tested.setId(-3);
	}
	@Test
	public void testSetId_Valid(){
		this.tested.setId(8);
	}
	

	@Test
	public void testGetWording() {
		assertEquals("foo",this.tested.getWording());
	}
	@Test(expected = NullPointerException.class)
	public void testSetWording_Null(){
		this.tested.setWording(null);
	}
	@Test(expected = IllegalArgumentException.class)
	public void testSetWording_Empty(){
		this.tested.setWording("");
	}
	@Test
	public void testSetWording_Valid(){
		this.tested.setWording("lihfpoiy");
	}
	
	
	@Test
	public void testEquals_IsValid() {
		TransactionType tested2 = new TransactionType("foo");
		assertTrue(tested.equals(tested2));
	}
	@Test
	public void testEquals_IsInvalid() {
		TransactionType tested2 = new TransactionType("fool");
		assertFalse(tested.equals(tested2));
	}
	
	
	@Test
	public void testToString(){
		assertEquals("foo",this.tested.toString());
	}

}
