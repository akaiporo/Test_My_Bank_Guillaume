package metier.test;

import static org.junit.Assert.*;

import org.junit.Test;

import metier.Person;

public class TestPerson {

	//Creation of an inner class "ConcretePerson" to test the abstract class "person"
	public class ConretePerson extends Person{
		public ConretePerson(String string, String string2, String string3, String string4) {
			super(string, string2, string3, string4);
		}

		public ConretePerson initPerson(){
			return new ConretePerson("Gerard", "Majax", "0645537031", "g.majax@gmail.com");
		}
		
		@Test(expected=IllegalArgumentException.class)
		public void testPerson_Name_isEmpty() {
			new ConretePerson("", "Majax", "0645537031", "g.majax@gmail.com");
		}
		@Test(expected=NullPointerException.class)
		public void testPerson_Name_isNull() {
			new ConretePerson(null, "Majax", "0645537031", "g.majax@gmail.com");
		}
		@Test(expected=IllegalArgumentException.class)
		public void testPerson_FirstName_isEmpty() {
			new ConretePerson("Gerard", "", "0645537031", "g.majax@gmail.com");
		}
		@Test(expected=NullPointerException.class)
		public void testPerson_FirstName_isNull() {
			new ConretePerson("Gerard", null, "0645537031", "g.majax@gmail.com");
		}
		@Test(expected=IllegalArgumentException.class)
		public void testPerson_Phone_HasInvalidLength() {
			new ConretePerson("Gerard", "Majax", "0644565537031", "g.majax@gmail.com");
		}
		@Test(expected=NullPointerException.class)
		public void testPerson_Phone_isNull() {
			new ConretePerson("Gerard", "Majax", null, "g.majax@gmail.com");
		}
		@Test(expected=IllegalArgumentException.class)
		public void testPerson_Email_isInvalid() {
			new ConretePerson("Gerard", "Majax", "0645537031", "g.majax@gmailcom");
		}
		@Test(expected=NullPointerException.class)
		public void testPerson_Email_isNull() {
			new ConretePerson("Gerard", "Majax", "0645537031", null);
		}
		@Test
		public void testGetId() {
			ConretePerson tested = initPerson();
			tested.setId(1);
			assertEquals(1, tested.getId());
		}
	
		@Test
		public void testSetId() {
			ConretePerson tested = initPerson();
			tested.setId(1);
		}
		@Test(expected=IllegalArgumentException.class)
		public void testSetId_isInvalid() {
			ConretePerson tested = initPerson();
			tested.setId(-1);
		}
	
		@Test
		public void testGetName() {
			ConretePerson tested = initPerson();
			assertEquals("Gerard", tested.getName());
		} 
	
		@Test
		public void testGetFirstName() {
			ConretePerson tested = initPerson();
			assertEquals("Majax", tested.getFirstName());
		}
	
		@Test
		public void testGetPhoneNumber() {
			ConretePerson tested = initPerson();
			assertEquals("0645537031", tested.getPhoneNumber());
		}
	
		@Test
		public void testGetEmail() {
			ConretePerson tested = initPerson();
			assertEquals("g.majax@gmail.com", tested.getMail());
		}
	}

}
