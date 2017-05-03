package metier.test;

import static org.junit.Assert.*;

import org.junit.Test;

import metier.Bank;

public class TestBank {

	private Bank tested;
	private void initBank(){
		tested=new Bank("foo","bar");
	}
	
	
	@Test(expected  = NullPointerException.class)
	public void testCountryCode_BankNameIsNull() {
		new Bank(null,"bar");
	}
	@Test(expected  = IllegalArgumentException.class)
	public void testCountryCode_BankNameIsEmpty() {
		new Bank("","bar");
	}
	
	@Test(expected  = NullPointerException.class)
	public void testCountryCode_BankCodeIsNull() {
		new Bank("foo",null);
	}
	@Test(expected  = IllegalArgumentException.class)
	public void testCountryCode_BankCodeIsEmpty() {
		new Bank("foo","");
	}

	@Test
	public void testGetId() {
		initBank();
		tested.setId(1);
		assertEquals(1,tested.getId());
	}
	@Test(expected = IllegalArgumentException.class)
	public void testSetId_Invalid() {
		initBank();
		tested.setId(-2);
	}
	@Test
	public void testSetId() {
		initBank();
		tested.setId(2);
	}
	
	
	@Test
	public void testGetBankName() {
		initBank();
		assertEquals("foo",tested.getBankName());
	}
	@Test(expected=NullPointerException.class)
	public void testSetBankName_Null(){
		initBank();
		tested.setBankName(null);
	}
	@Test(expected=IllegalArgumentException.class)
	public void testSetBankName_Empty(){
		initBank();
		tested.setBankName("");
	}
	@Test
	public void testSetBankName(){
		initBank();
		tested.setBankName("ba");
	}
	

	@Test
	public void testGetBankCode() {
		initBank();
		assertEquals("bar",tested.getBankCode());
	}
	@Test(expected=NullPointerException.class)
	public void testSetBankCode_Null(){
		initBank();
		tested.setBankCode(null);
	}
	@Test(expected=IllegalArgumentException.class)
	public void testSetBankCode_Empty(){
		initBank();
		tested.setBankCode("");
	}
	@Test
	public void testSetBankCode(){
		initBank();
		tested.setBankCode("fo");
	}
	

	@Test
	public void testEquals_isValid(){
		initBank();
		Bank tested_bank=new Bank("foo","bar");
		assertTrue(tested.equals(tested_bank));
	}
	@Test
	public void testEquals_isInvalid(){
		initBank();
		Bank tested_bank=new Bank("fo","bar");
		assertFalse(tested.equals(tested_bank));
	}	

}
