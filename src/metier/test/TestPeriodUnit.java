package metier.test;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import metier.PeriodUnit;

public class TestPeriodUnit {
	
	
	private PeriodUnit tested;
	@Before
	public void initTested(){
		tested= new PeriodUnit("hebdomadaire");
	}

	@Test(expected = IllegalArgumentException.class)
	public void testPeriodUnit_IsEmpty() {
		new PeriodUnit("");
	}
	
	@Test(expected = NullPointerException.class)
	public void testPeriodUnit_IsNull() {
		new PeriodUnit(null);
	}

	@Test
	public void testGetId() {
		this.tested.setId(1);
		assertEquals(1,this.tested.getId());
		
	}
	@Test(expected = IllegalArgumentException.class)
	public void testSetId_Invalid() {
		this.tested.setId(-2);	
	}
	@Test
	public void testSetId_Valid(){
		this.tested.setId(8);
	}

	
	@Test
	public void testGetUnit_UnitIsEmpty() { 
		assertEquals("hebdomadaire",this.tested.getUnit());
	}
	@Test(expected=NullPointerException.class)
	public void testSetUnit_Null(){
		this.tested.setUnit(null);
	}
	@Test(expected=IllegalArgumentException.class)
	public void testSetUnit_Empty(){
		this.tested.setUnit("");
	}
	
	
	@Test
	public void testEquals_IsValid() {
		PeriodUnit tested2 = new PeriodUnit("hebdomadaire");
		assertTrue(tested.equals(tested2));
	}
	
	@Test
	public void testEquals_IsInvalid() {
		PeriodUnit tested2 = new PeriodUnit("hebdo");
		assertFalse(tested.equals(tested2));
	}
	
	
	@Test
	public void testToString(){
		assertEquals("hebdomadaire",this.tested.toString());
	}
	
	
}
