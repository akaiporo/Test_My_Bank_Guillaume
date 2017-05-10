package metier.test;

import static org.junit.Assert.*;
import ribcalculation.RIBCalculationController;

import org.junit.Test;

public class TestTraduit {
	
		
@Test
public void testtradRIBkey() {
	 String acc_number = "FX66675659";
	 String traduit = "6766675659";
	 assertEquals(traduit,(RIBCalculationController.tradRIBkey(acc_number)).toString());
	

}


} 