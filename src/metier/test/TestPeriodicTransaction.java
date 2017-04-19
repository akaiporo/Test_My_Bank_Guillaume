package metier.test;

import static org.junit.Assert.*;

import java.util.GregorianCalendar;

import org.junit.Test;

import metier.Category;
import metier.PeriodUnit;
import metier.PeriodicTransaction;
import metier.TargetTransaction;
import metier.TransactionType;

public class TestPeriodicTransaction {
	
	@Test (expected  = NullPointerException.class)
	public void testPeriodicTransaction_WordingIsNull() {
		new PeriodicTransaction(
				null,
				12.7,
				new GregorianCalendar(2016,4,10,16,55).getTime(), 
				new GregorianCalendar (2018,4,10).getTime(),
				4,
				"foo", 
				type_tested,
				target_tested,
				category_tested,
				period_tested
		);
	}
	@Test (expected  = IllegalArgumentException.class)
	public void testPeriodicTransaction_WordingIsEmpty() {
		new PeriodicTransaction(
				"",
				12.7,
				new GregorianCalendar(2016,4,10,16,55).getTime(), 
				new GregorianCalendar (2018,4,10).getTime(),
				4,
				"foo", 
				type_tested,
				target_tested,
				category_tested,
				period_tested
		);
	}
	
	
	@Test (expected  = NullPointerException.class)
	public void testPeriodicTransaction_ValueIsNull() {
		new PeriodicTransaction(
				"babebiboo",
				null,
				new GregorianCalendar(2016,4,10,16,55).getTime(), 
				new GregorianCalendar (2018,4,10).getTime(),
				4,
				"foo", 
				type_tested,
				target_tested,
				category_tested,
				period_tested
		);
	}
	
	@Test (expected  = NullPointerException.class)
	public void testPeriodicTransaction_DateOperationIsNull() {
		new PeriodicTransaction(
				"babebiboo",
				12.7,
				null, 
				new GregorianCalendar (2018,4,10).getTime(),
				4,
				"foo", 
				type_tested,
				target_tested,
				category_tested,
				period_tested
		);
	}
	@Test (expected  = NullPointerException.class)
	public void testPeriodicTransaction_DayNumberIsZero() {
		new PeriodicTransaction(
				"babebiboo",
				12.7,
				new GregorianCalendar(2016,4,10,16,55).getTime(), 
				new GregorianCalendar (2018,4,10).getTime(),
				0,
				"foo", 
				type_tested,
				target_tested,
				category_tested,
				period_tested
		);
	}
	@Test (expected  = NullPointerException.class)
	public void testPeriodicTransaction_PeriodUnitIsNull() {
		new PeriodicTransaction(
				"babebiboo",
				12.7,
				new GregorianCalendar(2016,4,10,16,55).getTime(), 
				new GregorianCalendar (2018,4,10).getTime(),
				4,
				"foo", 
				type_tested,
				target_tested,
				category_tested,
				null
		);
	}
	@Test (expected  = NullPointerException.class)
	public void testPeriodicTransaction_TransactionTypeIsNull() {
		new PeriodicTransaction(
				"babebiboo",
				12.7,
				new GregorianCalendar(2016,4,10,16,55).getTime(), 
				new GregorianCalendar (2018,4,10).getTime(),
				4,
				"foo", 
				null,
				target_tested,
				category_tested,
				period_tested
		);
	}
	@Test (expected  = NullPointerException.class)
	public void testPeriodicTransaction_TargetTransactionIsNull() {
		new PeriodicTransaction(
				"babebiboo",
				12.7,
				new GregorianCalendar(2016,4,10,16,55).getTime(), 
				new GregorianCalendar (2018,4,10).getTime(),
				4,
				"foo", 
				type_tested,
				null,
				category_tested,
				period_tested
		);
	}
	@Test (expected  = NullPointerException.class)
	public void testPeriodicTransaction_CategoryIsNull() {
		new PeriodicTransaction(
				"babebiboo",
				12.7,
				new GregorianCalendar(2016,4,10,16,55).getTime(), 
				new GregorianCalendar (2018,4,10).getTime(),
				4,
				"foo", 
				type_tested,
				target_tested,
				null,
				period_tested
		);
	}

	@Test
	public void testGetId() {
		tested.setId(1);
		assertEquals(1,tested.getId());
	}

	@Test (expected = IllegalArgumentException.class)
	public void testSetId() {
		tested.setId(-2);
	}

	@Test
	public void testGetWording() {
		assertEquals("babebiboo",tested.getWording());
	}

	@Test
	public void testGetTransactionValue() {
		assertEquals(12.7,tested.getTransactionValue(),0);
	}

	@Test
	public void testGetDateOperation() {
		assertEquals(new GregorianCalendar(2016,4,10,16,55).getTime(),tested.getDateOperation()); 
	}

	@Test
	public void testGetEndDateTransaction() {
		assertEquals(new GregorianCalendar(2018,4,10).getTime(),tested.getEndDateTransaction());
	}

	@Test
	public void testGetDayNumber() {
		assertEquals(4,tested.getDayNumber());
	}

	@Test
	public void testGetDescription() {
		assertEquals("foo",tested.getDescription());
	}

	@Test
	public void testGetTransactionType() {
		assertEquals(type_tested,tested.getTransactionType());
	}
	@Test
	public void testGetTransactionTypeWording() {
		assertEquals(type_tested.getWording(),tested.getTransactionType().getWording());
	}
	@Test
	public void testGetTargetTransaction() {
		assertEquals(target_tested,tested.getTargetTransaction());
	}
	@Test
	public void testGetTargetTransactionName() {
		assertEquals(target_tested.getTargetName(),tested.getTargetTransaction().getTargetName());
	}

	@Test
	public void testGetCategory() {
		assertEquals(category_tested,tested.getCategory());
	}
	@Test
	public void testGetCategoryWording() {
		assertEquals(category_tested.getWording(),tested.getCategory().getWording());
	}

	@Test
	public void testGetPeriodUnit() {
		assertEquals(period_tested,tested.getPeriodUnit());
	}
	@Test
	public void testGetPeriodUnitName() {
		assertEquals(period_tested.getUnit(),tested.getPeriodUnit().getUnit());
	}
	
	private TransactionType type_tested = new TransactionType("bar");
	private TargetTransaction target_tested = new TargetTransaction("Banque", "frhdteyf45gtf1dju98hgd1jup2");
	private Category category_tested = new Category("blblblb",null);
	private PeriodUnit period_tested = new PeriodUnit("hebdomadaire");
	
	private PeriodicTransaction tested= new PeriodicTransaction(
			"babebiboo",
			12.7,
			new GregorianCalendar(2016,4,10,16,55).getTime(), 
			new GregorianCalendar (2018,4,10).getTime(),
			4,
			"foo", 
			type_tested,
			target_tested,
			category_tested,
			period_tested
	);
}
