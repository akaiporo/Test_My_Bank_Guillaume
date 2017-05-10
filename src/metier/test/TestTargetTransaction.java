package metier.test;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import metier.TargetTransaction;

public class TestTargetTransaction {

	private TargetTransaction tested;
	@Before
	public void initTarget(){
		this.tested= new TargetTransaction("Banque", "frhdteyf45gtf1dju98hgd1jup2");
		this.tested.setId(1);
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void testTargetTransaction_TargetName_isEmpty() {
		new TargetTransaction("", "frhdteyf45gtf1dju98hg12jup2");
	}
	@Test(expected=NullPointerException.class)
	public void testTargetTransaction_TargetName_isNull() {
		new TargetTransaction(null, "frhdteyf45gtf1dju98hg12jup2");
	}
	@Test(expected=IllegalArgumentException.class)
	public void testTargetTransaction_TargetName_hasBadLength() {
		new TargetTransaction("Banque", "frhdteyf4u98gd1jup2");
	}
	@Test(expected=IllegalArgumentException.class)
	public void testTargetTransaction_TargetName_StartsWithFR() {
		new TargetTransaction("Banque", "rfhdteyf45gtf1dju98hg1djup2");
	}
	@Test
	public void testGetId() {
		assertEquals(1, this.tested.getId());
	}
	@Test(expected=IllegalArgumentException.class)
	public void testSetId_isInvalid() {
		this.tested.setId(0);
	}
	@Test
	public void testSetId_Valid() {
		this.tested.setId(1);
	}
	
	
	@Test
	public void testGetTargetName() {
		assertEquals("Banque", this.tested.getTargetName());
	}
	@Test(expected=NullPointerException.class)
	public void testSetTargetName_Null(){
		this.tested.setTargetName(null);
	}
	@Test(expected=IllegalArgumentException.class)
	public void testSetTargetName_Empty(){
		this.tested.setTargetName("");
	}
	@Test
	public void testSetTargetName_Valid(){
		this.tested.setTargetName("a");
	}
	
	
	@Test
	public void testGetIBAN() {
		assertEquals("frhdteyf45gtf1dju98hgd1jup2", this.tested.getIBAN());
	}
	@Test(expected=IllegalArgumentException.class)
	public void testSetIBAN_InvalidLength(){
		this.tested.setIBAN("21465");
	}
	@Test(expected=NullPointerException.class)
	public void testSetIBAN_Null(){
		this.tested.setIBAN(null);
	}
	@Test
	public void testSetIBAN_Valid(){
		this.tested.setIBAN("FR3456789123456789123456789");
	}
	@Test(expected=IllegalArgumentException.class)
	public void testSetIBAN_DoesNotStartWithFR(){
		this.tested.setIBAN("123456789123456789123456789");
	}
	
	
	@Test
	public void testEquals_IsValid() {
		TargetTransaction tested2 = new TargetTransaction("Banque", "frhdteyf45gtf1dju98hgd1jup2");
		assertTrue(tested.equals(tested2));
	}
	@Test
	public void testEquals_IsInvalid() {
		TargetTransaction tested2 = new TargetTransaction("Banque", "frhdteyf45gtf1dju98hgd1jupA");
		assertFalse(tested.equals(tested2));
	}
	
	
	@Test
	public void testToString(){
		assertEquals("Banque",tested.toString());
	}

}
