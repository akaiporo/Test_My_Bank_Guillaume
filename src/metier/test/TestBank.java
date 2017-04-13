package metier.test;

import static org.junit.Assert.*;

import org.junit.Test;

import metier.Bank;

public class TestBank {

	@Test(expected  = NullPointerException.class)
	public void testCountryCode_BankNameIsNull() {
		new Bank(null,"bar");
	}
	@Test(expected  = NullPointerException.class)
	public void testCountryCode_BankCodeIsNull() {
		new Bank("foo",null);
	}
	@Test(expected  = IllegalArgumentException.class)
	public void testCountryCode_BankNameIsEmpty() {
		new Bank("","bar");
	}
	@Test(expected  = IllegalArgumentException.class)
	public void testCountryCode_BankCodeIsEmpty() {
		new Bank("foo","");
	}

	@Test
	public void testGetId() {
		Bank tested=new Bank("foo","bar");
		tested.setId(1);
		assertEquals(1,tested.getId());
	}

	@Test(expected = IllegalArgumentException.class)
	public void testSetId() {
		Bank tested=new Bank("foo","bar");
		tested.setId(-2);
	}
	
	@Test
	public void testGetBankName() {
		Bank tested=new Bank("foo","bar");
		assertEquals("foo",tested.getBankName());
	}

	@Test
	public void testGetBankCode() {
		Bank tested=new Bank("foo","bar");
		assertEquals("bar",tested.getBankCode());
	}
	@Test
	public void testEquals_isValid(){
		Bank tested=new Bank("foo","bar");
		Bank tested_bank=new Bank("foo","bar");
		tested.equals(tested_bank);
	}
	@Test
	public void testEquals_isInvalid(){
		Bank tested=new Bank("foo","bar");
		Bank tested_bank=new Bank("fo","bar");
		tested.equals(tested_bank);
	}	
}
