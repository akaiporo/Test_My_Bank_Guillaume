package metier.test;

import static org.junit.Assert.*;

import org.junit.Test;

import metier.TargetTransaction;

public class TestTargetTransaction {

	private TargetTransaction setTarget(){
		return new TargetTransaction("Banque", "frhdteyf45gtf1dju98hgd1jup2");
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
		TargetTransaction tested = setTarget();
		tested.setId(1);
		assertEquals(1, tested.getId());
	}
	@Test(expected=IllegalArgumentException.class)
	public void testSetId_isInvalid() {
		TargetTransaction tested = setTarget();
		tested.setId(0);
	}
	@Test
	public void testSetId() {
		TargetTransaction tested = setTarget();
		tested.setId(1);
	}
	@Test
	public void testGetTargetName() {
		TargetTransaction tested = setTarget();
		assertEquals("Banque", tested.getTargetName());
	}

	@Test
	public void testGetIBAN() {
		TargetTransaction tested = setTarget();
		assertEquals("frhdteyf45gtf1dju98hgd1jup2", tested.getIBAN());
	}

}