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
		this.tested = new PeriodUnit("hebdomadaire");
		this.tested.setId(1);
		assertEquals(1,this.tested.getId());
		
	}

	@Test(expected = IllegalArgumentException.class)
	public void testSetId() {
		this.tested = new PeriodUnit("hebdomadaire");
		this.tested.setId(-2);	
	}

	@Test
	public void testGetUnit_UnitIsEmpty() {
		this.tested = new PeriodUnit("hebdomadaire");
		assertEquals("hebdomadaire",this.tested.getUnit());
	}
	
	
	private PeriodUnit tested;

}
