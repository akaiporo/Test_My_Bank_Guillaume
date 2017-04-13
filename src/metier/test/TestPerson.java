package metier.test;

import static org.junit.Assert.*;

import org.junit.Test;

import metier.Person;

public class TestPerson {

	public Person initPerson(){
		return new Person("Gerard", "Majax", "0645537031", "g.majax@gmail.com");
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void testPerson_Name_isEmpty() {
		new Person("", "Majax", "0645537031", "g.majax@gmail.com");
	}
	@Test(expected=NullPointerException.class)
	public void testPerson_Name_isNull() {
		new Person(null, "Majax", "0645537031", "g.majax@gmail.com");
	}
	@Test(expected=IllegalArgumentException.class)
	public void testPerson_FirstName_isEmpty() {
		new Person("Gerard", "", "0645537031", "g.majax@gmail.com");
	}
	@Test(expected=NullPointerException.class)
	public void testPerson_FirstName_isNull() {
		new Person("Gerard", null, "0645537031", "g.majax@gmail.com");
	}
	@Test(expected=IllegalArgumentException.class)
	public void testPerson_Phone_HasInvalidLength() {
		new Person("Gerard", "Majax", "0644565537031", "g.majax@gmail.com");
	}
	@Test(expected=NullPointerException.class)
	public void testPerson_Phone_isNull() {
		new Person("Gerard", "Majax", null, "g.majax@gmail.com");
	}
	@Test(expected=IllegalArgumentException.class)
	public void testPerson_Email_isInvalid() {
		new Person("Gerard", "Majax", "0645537031", "g.majax@gmailcom");
	}
	@Test(expected=NullPointerException.class)
	public void testPerson_Email_isNull() {
		new Person("Gerard", "Majax", "0645537031", null);
	}
	@Test
	public void testGetId() {
		Person tested = initPerson();
		tested.setId(1);
		assertEquals(1, tested.getId());
	}

	@Test
	public void testSetId() {
		Person tested = initPerson();
		tested.setId(1);
	}
	@Test(expected=IllegalArgumentException.class)
	public void testSetId_isInvalid() {
		Person tested = initPerson();
		tested.setId(-1);
	}

	@Test
	public void testGetName() {
		Person tested = initPerson();
		assertEquals("Gerard", tested.getName());
	}

	@Test
	public void testGetFirstName() {
		Person tested = initPerson();
		assertEquals("Majax", tested.getFirstName());
	}

	@Test
	public void testGetPhoneNumber() {
		Person tested = initPerson();
		assertEquals("0645537031", tested.getPhoneNumber());
	}

	@Test
	public void testGetEmail() {
		Person tested = initPerson();
		assertEquals("g.majax@gmail.com", tested.getEmail());
	}

}
