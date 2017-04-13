package metier.test;

import static org.junit.Assert.*;

import org.junit.Test;
import metier.TransactionType;

public class TestTransactionType {

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
		this.tested = new TransactionType("foo");
		this.tested.setId(1);
		assertEquals(1,this.tested.getId());
	}

	@Test(expected = IllegalArgumentException.class)
	public void testSetId() {
		this.tested = new TransactionType("foo");
		this.tested.setId(-3);
	}

	@Test
	public void testGetWording() {
		this.tested = new TransactionType("retrait");
		assertEquals("retrait",this.tested.getWording());
	}
	
	private TransactionType tested;

}
