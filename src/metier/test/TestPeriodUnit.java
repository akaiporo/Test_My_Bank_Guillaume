package metier.test;

import static org.junit.Assert.*;

import org.junit.Test;

import metier.PeriodUnit;

public class TestPeriodUnit {

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
	public void testSetId() {
		this.tested.setId(-2);	
	}

	@Test
	public void testGetUnit_UnitIsEmpty() { 
		assertEquals("hebdomadaire",this.tested.getUnit());
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
	
	private PeriodUnit tested = new PeriodUnit("hebdomadaire");;
}
