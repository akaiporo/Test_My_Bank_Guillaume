package metier.test;

import static org.junit.Assert.*;

import static org.mockito.Mockito.*;

import org.junit.Test;

import metier.Address;
import metier.Bank;
import metier.CpCity;

public class TestAddress {

	Address address;
	CpCity mockCpCity = mock(CpCity.class);
	
	public void setAddress(){
		this.address = new Address("Route des landes", null, this.mockCpCity);
		this.address.setId(1);
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void testAddress_Line_isEmpty() {
		new Address("", null, mock(CpCity.class));
	}
	@Test(expected=NullPointerException.class)
	public void testAddress_CpCity_isNull() {
		new Address("Route des landes", null, null);
	}
	@Test(expected=NullPointerException.class)
	public void testAddress_Line_isNull() {
		new Address(null, null, mock(CpCity.class));
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
	public void testGetLine2() {
		this.setAddress();
		assertEquals("", this.address.getLine2());
	}

	@Test
	public void testGetCpCity() {
		setAddress();
		assertEquals(this.mockCpCity, this.address.getCpCity());
	}
	
	@Test 
	public void testEquals_isValid(){
		setAddress();
		Address tested = this.address;
		Address tested_Address = new Address("Route des landes", null, this.mockCpCity);
		tested_Address.equals(tested);
	}
	@Test 
	public void testEquals_isInvalid(){
		setAddress();
		Address tested = this.address;
		Address tested_Address = new Address("Route landes", null, this.mockCpCity);
		tested_Address.equals(tested);
	}
}
