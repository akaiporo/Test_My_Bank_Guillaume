package metier.test;

import static org.junit.Assert.*;

import org.junit.Test;

import metier.Category;
public class TestCategory {

	@Test(expected=IllegalArgumentException.class)
	public void testCategory_Wording_isInvalid() {
		new Category("", null);
	}
	@Test(expected=NullPointerException.class)
	public void testCategory_Wording_isNull() {
		new Category(null, null);
	}
	@Test 
	public void testCategory() {
		new Category("blblblb", null);
	}
	@Test
	public void testGetId() {
		Category tested = new Category("blblblb", null);
		tested.setId(1);
		assertEquals(1, tested.getId());
	}
	@Test(expected=IllegalArgumentException.class)
	public void testSetId_isInvalid() {
		Category tested = new Category("blblblb", null);
		tested.setId(-1);	
	}
	@Test
	public void testSetId() {
		Category tested = new Category("blblblb", null);
		tested.setId(1);	
	}
	@Test
	public void testGetWording() {
		Category tested = new Category("blblblb", null);
		assertEquals("blblblb", tested.getWording());
	}

	@Test
	public void testGetCategory() {
		Category tested = new Category("blblblb", null);
		assertEquals(null, tested.getCategory());
	}

}
