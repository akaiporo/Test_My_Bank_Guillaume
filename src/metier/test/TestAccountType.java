package metier.test;

import static org.junit.Assert.*;

import org.junit.Test;
import metier.AccountType;

public class TestAccountType {

	@Test(expected = IllegalArgumentException.class)
	public void testAccountType_IsEmpty() {
		new AccountType("");
	}
	
	@Test(expected = NullPointerException.class)
	public void testAccountType_IsNull() {
		new AccountType(null);
	}

	@Test
	public void testGetId() {
		this.tested = new AccountType("foo");
		this.tested.setId(1);
		assertEquals(1,this.tested.getId());
		
	}

	@Test(expected = IllegalArgumentException.class)
	public void testSetId() {
		this.tested = new AccountType("foo");
		this.tested.setId(-3);
	}

	@Test
	public void testGetAccountType() {
		this.tested = new AccountType("epargne");
		assertEquals("epargne",this.tested.getAccountType());
	}
	
	
	private AccountType tested;

}
