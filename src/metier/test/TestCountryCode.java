package metier.test;

import static org.junit.Assert.*;

import org.junit.Test;

import metier.CountryCode;

public class TestCountryCode {

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
		CountryCode tested=new CountryCode("ZZ");
		tested.setId(1);
		assertEquals(1,tested.getId());
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testSetId() {
		CountryCode tested=new CountryCode("ZZ");
		tested.setId(-2);
	}

	@Test
	public void testGetCountryCode() {
		CountryCode tested=new CountryCode("ZZ");
		assertEquals("ZZ",tested.getCountryCode());
	}

}
