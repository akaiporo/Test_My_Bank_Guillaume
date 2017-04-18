package metier.test;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;
import org.junit.Test;

import metier.Address;
import metier.Agency;
import metier.Bank;
import metier.CpCity;

public class TestAgency {

	CpCity mockCpCity = mock(CpCity.class);
	
	public Agency initAgency(){
		return new Agency("Beaulieu","12015",
			   new Address("Route des landes", null, this.mockCpCity),
			   new Bank("Caisse d'épargne", "bank_code"));
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void testAgency_Name_isEmpty() {
		new Agency("","12015",
				   new Address("Route des landes", null, mock(CpCity.class)),
				   new Bank("Caisse d'épargne", "bank_code"));
	}
	@Test(expected=NullPointerException.class)
	public void testAgency_Name_isNull() {
		new Agency(null,"12015",
				   new Address("Route des landes", null, mock(CpCity.class)),
				   new Bank("Caisse d'épargne", "bank_code"));
	}
	@Test(expected=IllegalArgumentException.class)
	public void testAgency_CounterCode_HasInvalidLength() {
		new Agency("Beaulieu","115",
				   new Address("Route des landes", null, mock(CpCity.class)),
				   new Bank("Caisse d'épargne", "bank_code"));
	}
	@Test(expected=NullPointerException.class)
	public void testAgency_Address_isNull() {
		new Agency("Beaulieu","12015",null,
				   new Bank("Caisse d'épargne", "bank_code"));
	}
	@Test(expected=NullPointerException.class)
	public void testAgency_Bank_isNull() {
		new Agency("Beaulieu","12015", new Address("Route des landes", null,mock(CpCity.class)),null);
	}
	@Test
	public void testAgency() {
		initAgency();
	}
	@Test
	public void testGetId() {
		Agency tested = initAgency();
		tested.setId(2);
		assertEquals(2, tested.getId());
	}

	@Test
	public void testSetId() {
		Agency tested = initAgency();
		tested.setId(2);
	}
	@Test(expected=IllegalArgumentException.class)
	public void testSetId_Invalid() {
		Agency tested = initAgency();
		tested.setId(-2);
	}
	@Test
	public void testGetAgencyName() {
		Agency tested = initAgency();
		assertEquals("Beaulieu", tested.getAgencyName());
	}

	@Test
	public void testGetCounterCode() {
		Agency tested = initAgency();
		assertEquals("12015", tested.getCounterCode());
	}

	@Test
	public void testGetAddress() {
		Agency tested = initAgency();
		Address tested_address = new Address("Route des landes", null, this.mockCpCity);
		assertEquals(tested_address,tested.getAddress());
	}
	@Test
	public void testGetBank() {
		Agency tested = initAgency();
		Bank tested_Bank =  new Bank("Caisse d'épargne", "bank_code");
		assertEquals(tested_Bank, tested.getBank());
	}
}
