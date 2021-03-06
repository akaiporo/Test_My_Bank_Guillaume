package metier.test;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import metier.CountryCode;

public class TestCountryCode {
	
	private CountryCode tested;
	
	@Before
	public void initTested(){
		tested=new CountryCode("ZZ");
	}

	@Test(expected  = NullPointerException.class)
	public void testCountryCode_codeIsNull() {
		new CountryCode(null);
	}
	@Test(expected  = IllegalArgumentException.class)
	public void testCountryCode_codeIsTooLong() {
		new CountryCode("ZZZ");
	}
	@Test(expected  = IllegalArgumentException.class)
	public void testCountryCode_codeIsEmpty() {
		new CountryCode("");
	}
	
	
	@Test
	public void testGetId() {
		tested.setId(1);
		assertEquals(1,tested.getId());
	}
	@Test(expected = IllegalArgumentException.class)
	public void testSetId_Invalid() {
		tested.setId(-2);
	}
	@Test
	public void testSetId_Valid() {
		tested.setId(2);
	}

	
	@Test
	public void testGetCountryCode() {
		assertEquals("ZZ",tested.getCountryCode());
	}
	@Test 
	public void testSetCountryCode(){
		tested.setCountryCode("ZZ");
	}
	@Test(expected=IllegalArgumentException.class) 
	public void testSetCountryCode_Invalid(){
		tested.setCountryCode("Z");
	}
	@Test(expected=NullPointerException.class) 
	public void testSetCountryCode_Null(){
		tested.setCountryCode(null);
	}
	
	
	@Test
	public void testEquals_IsValid() {
		CountryCode tested2 = new CountryCode("ZZ");
		assertTrue(tested.equals(tested2));
	}
	@Test
	public void testEquals_IsInvalid() {
		CountryCode tested2 = new CountryCode("AA");
		assertFalse(tested.equals(tested2));
	}

	
	@Test
	public void testToString(){
		assertEquals("ZZ",this.tested.toString());
	}
}
