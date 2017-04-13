package metier.test;

import static org.junit.Assert.*;

import org.junit.Test;

import metier.Address;

public class TestAddress {

	Address address;
	
	public void setAddress(){
		this.address = new Address("Route des landes", null, "40120", "Rillons des landes");
		this.address.setId(1);
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void testAddress_Line_isEmpty() {
		new Address("", null, "40120", "Rillons des landes");
	}
	@Test(expected=IllegalArgumentException.class)
	public void testAddress_PostalCode_isEmpty() {
		new Address("Route des landes", null, "", "Rillons des landes");
	}
	@Test(expected=IllegalArgumentException.class)
	public void testAddress_City_isEmpty() {
		new Address("Route des landes", null, "40120", "");
	}
	@Test(expected=NullPointerException.class)
	public void testAddress_Line_isNull() {
		new Address(null, null, "40120", "Rillons des landes");
	}
	@Test(expected=NullPointerException.class)
	public void testAddress_PostalCode_isNull() {
		new Address("Route des landes", null, null, "Rillons des landes");
	}
	@Test(expected=NullPointerException.class)
	public void testAddress_City_isNull() {
		new Address("Route des landes", null, "40120", null);
	}
	@Test
	public void testGetId() {
		setAddress();
		Address tested = this.address;
		assertEquals(1, tested.getId());
	}
	@Test(expected=IllegalArgumentException.class)
	public void testSetId_isInvalid() {
		setAddress();
		Address tested = this.address;
		tested.setId(0);
	}
	@Test
	public void testSetId_isValid() {
		setAddress();
		Address tested = this.address;
		tested.setId(2);
	}
	@Test
	public void testGetLine1() {
		setAddress();
		Address tested = this.address;
		assertEquals("Route des landes", tested.getLine1());
	}

	@Test
	public void testGetLine2_isNull() {
		setAddress();
		Address tested = this.address;
		assertEquals(null, tested.getLine2());
	}
	@Test
	public void testGetLine2() {
		Address tested = new Address("Route des landes", "chemin du baudet", "40120", "Cachen");
		assertEquals("chemin du baudet", tested.getLine2());
	}
	@Test
	public void testGetPostalCode() {
		setAddress();
		Address tested = this.address;
		assertEquals("40120", tested.getPostalCode());
	}

	@Test
	public void testGetCity() {
		setAddress();
		Address tested = this.address;
		assertEquals("Rillons des landes", tested.getCity());
	}
	
	@Test 
	public void testEquals_isValid(){
		setAddress();
		Address tested = this.address;
		Address tested_Address = new Address("Route des landes", null, "40120", "Rillons des landes");
		assertTrue(tested_Address.equals(tested));
	}
	@Test 
	public void testEquals_isInvalid(){
		setAddress();
		Address tested = this.address;
		Address tested_Address = new Address("Route landes", null, "40120", "Rillons des landes");
		assertFalse(tested_Address.equals(tested));
	}
}