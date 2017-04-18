package metier.test;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import metier.Address;
import metier.CpCity;

public class TestCpCity {

	CpCity cpcity;
	
	@Before
	public void setUp(){
		this.cpcity = new CpCity("64000", "Pau");
	}

	@Test(expected=IllegalArgumentException.class)
	public void testCpCity_PostalCodeHasInvalidLength() {
		new CpCity("6400", "Pau");
	}
	@Test(expected=IllegalArgumentException.class)
	public void testCpCity_CityHasInvalidLength() {
		new CpCity("64000", "");
	}
	@Test(expected=NullPointerException.class)
	public void testCpCity_PostalCodeisNull() {
		new CpCity(null, "Pau");
	}
	@Test(expected=NullPointerException.class)
	public void testCpCity_CityisNull() {
		new CpCity("64000", null);
	}
	@Test(expected=IllegalArgumentException.class)
	public void testSetId_isInvalid() {
		this.cpcity.setId(-1);
	}
	@Test
	public void testSetId() {
		this.cpcity.setId(1);
	}

	@Test
	public void testGetId() {
		this.cpcity.setId(1);
		assertEquals(1, this.cpcity.getId());
	}

	@Test
	public void testGetPostalCode() {
		assertEquals("64000", this.cpcity.getPostalCode());
	}

	@Test
	public void testGetCity() {
		assertEquals("Pau", this.cpcity.getCity());
	}

	@Test 
	public void testEquals_isValid(){
		CpCity tested_cpcity =  new CpCity("64000", "Pau");
		tested_cpcity.equals(this.cpcity);
	}
	@Test 
	public void testEquals_isInvalid(){
		CpCity tested_cpcity =  new CpCity("65000", "Pau");
		tested_cpcity.equals(this.cpcity);
	}
}
