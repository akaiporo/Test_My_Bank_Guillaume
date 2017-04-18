package metier.test;

import static org.junit.Assert.*;

import java.util.Date;
import java.util.GregorianCalendar;

import org.junit.Test;

import metier.Address;
import metier.Advisor;
import metier.Agency;
import metier.Bank;

public class TestAdvisor {

	private Agency agency_tested = new Agency("Beaulieu","12015",
			new Address("Route des landes", null, "40120", "Rillons des landes"),
			new Bank("Caisse d'Epargne", "bank_code")
	);
	
	private Advisor initTested (Date d, Agency a){
		return new Advisor("toto","tutu","0345567891","toto.tutu@titi.tata",d,a);		
	}
	
	@Test (expected = NullPointerException.class )
	public void testAdvisor_DateAssignmentIsNull() {
		initTested (null, agency_tested);
	}
	
	@Test (expected = IllegalArgumentException.class )
	public void testAdvisor_DateAssignmentInTheFuture() {
		initTested (new GregorianCalendar (2018,4,10).getTime(), agency_tested);
	}
	
	@Test (expected = NullPointerException.class )
	public void testAdvisor_AgencyIsNull() {
		initTested (new GregorianCalendar (2016,4,10).getTime(), null);
	}
	
	@Test
	public void testGetDateAssignment() {
		Advisor tested = initTested (new GregorianCalendar (2016,4,10).getTime(), agency_tested);
		assertEquals(new GregorianCalendar (2016,4,10).getTime(),tested.getDateAssignment());	
	}

	@Test
	public void testGetAgency() {
		Advisor tested = initTested (new GregorianCalendar (2016,4,10).getTime(), agency_tested);
		assertEquals(agency_tested,tested.getAgency());
	}

}
