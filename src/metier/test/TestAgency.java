package metier.test;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

import org.junit.Before;
import org.junit.Test;

import metier.Address;
import metier.Agency;
import metier.Bank;

public class TestAgency {

	private Agency tested;
	private Address mockAddress=mock(Address.class);
	private Bank mockBank=mock(Bank.class);
	
	@Before
	public void initAgency(){
		tested=new Agency("Beaulieu","12015",mockAddress,mockBank); 
		tested.setId(2);
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void testAgency_Name_isEmpty() {
		new Agency("","12015",mockAddress,mockBank);
	}
	@Test(expected=NullPointerException.class)
	public void testAgency_Name_isNull() {
		new Agency(null,"12015",mockAddress,mockBank);
	}
	@Test(expected=IllegalArgumentException.class)
	public void testAgency_CounterCode_HasInvalidLength() {
		new Agency("Beaulieu","115",mockAddress,mockBank);
	}
	@Test(expected=NullPointerException.class)
	public void testAgency_Address_isNull() {
		new Agency("Beaulieu","12015",null,mockBank);
	}
	@Test(expected=NullPointerException.class)
	public void testAgency_Bank_isNull() {
		new Agency("Beaulieu","12015", mockAddress,null);
	}
	@Test
	public void testAgency() {
		initAgency();
	}
	
	
	@Test
	public void testGetId() {
		assertEquals(2, tested.getId());
	}
	@Test
	public void testSetId() {
		tested.setId(2);
	}
	@Test(expected=IllegalArgumentException.class)
	public void testSetId_Invalid() {
		tested.setId(-2);
	}
	
	
	@Test
	public void testGetAgencyName() {
		assertEquals("Beaulieu", tested.getAgencyName());
	}
	@Test(expected=NullPointerException.class)
	public void testSetAgencyName_Null(){
		tested.setAgencyName(null);
	}
	@Test(expected=IllegalArgumentException.class)
	public void testSetAgencyName_Empty(){
		tested.setAgencyName("");
	}
	@Test
	public void testSetAgencyName(){
		tested.setAgencyName("Bali");
	}
	

	
	@Test
	public void testGetCounterCode() {
		assertEquals("12015", tested.getCounterCode());
	}
	@Test(expected=NullPointerException.class)
	public void testSetCounterCode_Null(){
		tested.setCounterCode(null);
	}
	@Test(expected=IllegalArgumentException.class)
	public void testSetCounterCode_InvalidLength(){
		tested.setCounterCode("123");
	}
	@Test
	public void testSetCounterCode(){
		tested.setCounterCode("12345");
	}
	

	@Test
	public void testGetAddress() {
		assertEquals(mockAddress,tested.getAddress());
	}
	@Test(expected=NullPointerException.class)
	public void testSetAddress_Null(){
		tested.setAddress(null);
	}
	@Test
	public void testSetAddress(){
		tested.setAddress(mockAddress);
	}
	
	
	@Test
	public void testGetBank() {
		assertEquals(mockBank, tested.getBank());
	}
	@Test(expected=NullPointerException.class)
	public void testSetBank_Null(){
		tested.setBank(null);
	}
	@Test
	public void testSetBank(){
		tested.setBank(mockBank);
	}
	
	
	@Test
	public void equals_Valid(){
		Agency tested2=new Agency("Beaulieu","12015",mockAddress,mockBank);
		assertTrue(tested2.equals(tested));
	}
	@Test
	public void equals_Invalid(){
		Agency tested2=new Agency("Beaeu","12015",mockAddress,mockBank);
		assertFalse(tested2.equals(tested));
	}
	
	
	@Test 
	public void testToString(){
		assertEquals("Beaulieu", this.tested.toString());
	}
}
