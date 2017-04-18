package metier.test;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

import org.junit.Before;
import org.junit.Test;
import static org.mockito.Mockito.*;

import application.Tools;
import metier.Account;
import metier.AccountType;
import metier.Agency;
import metier.Category;
import metier.CountryCode;
import metier.PeriodUnit;
import metier.PeriodicTransaction;
import metier.TargetTransaction;
import metier.TransactionType;

public class TestAccount {
	Agency mockAgency = mock(Agency.class);
	CountryCode mockCountryCode = mock(CountryCode.class);
	AccountType mockAccountType = mock(AccountType.class);
	Account account;
	
	@Before
	public void setUp() throws Exception {
		this.account = new Account("fg1265fr459",Tools.today(), 120.25, 200, 0, 
				this.mockAgency, this.mockCountryCode, this.mockAccountType, 0);
	}

	@Test(expected=IllegalArgumentException.class)
	public void testAccount_accountHasInvalidLength() {
		this.account = new Account("fg144265fr459",Tools.today(), 120.25, 200, 0, 
				mock(Agency.class), mock(CountryCode.class), mock(AccountType.class), 0);
	}
	@Test(expected=IllegalArgumentException.class)
	public void testAccount_accountHasNullLength() {
		this.account = new Account("",Tools.today(), 120.25, 200, 0, 
				mock(Agency.class), mock(CountryCode.class), mock(AccountType.class), 0);
	}
	@Test(expected=NullPointerException.class)
	public void testAccount_accountHasNullDate() {
		this.account = new Account("fg1265fr459",null, 120.25, 200, 0, 
				mock(Agency.class), mock(CountryCode.class), mock(AccountType.class), 0);
	}
	@Test(expected=IllegalArgumentException.class)
	public void testAccount_accountHasInvalidDate() {
		Date tmp_date = Tools.today();
		tmp_date.setMonth(8);
		this.account = new Account("fg1265fr459",tmp_date, 120.25, 200, 0, 
				mock(Agency.class), mock(CountryCode.class), mock(AccountType.class), 0);
	}
	@Test(expected=IllegalArgumentException.class)
	public void testAccount_accountHasInvalidOverdraft() {
		this.account = new Account("fg1265fr459",Tools.today(), 120.25, -250, 0, 
				mock(Agency.class), mock(CountryCode.class), mock(AccountType.class), 0);
	}
	@Test(expected=IllegalArgumentException.class)
	public void testAccount_accountHasInvalidInterestRate() {
		this.account = new Account("fg1265fr459",Tools.today(), 120.25, 250, -0.6, 
				mock(Agency.class), mock(CountryCode.class), mock(AccountType.class), 0);
	}
	@Test(expected=NullPointerException.class)
	public void testAccount_accountHasNullAgency() {
		this.account = new Account("fg1265fr459",Tools.today(), 120.25, 250, 0, 
				null, mock(CountryCode.class), mock(AccountType.class), 0);
	}
	@Test(expected=NullPointerException.class)
	public void testAccount_accountHasNullCountryCode() {
		this.account = new Account("fg1265fr459",Tools.today(), 120.25, 250, 0, 
				mock(Agency.class), null, mock(AccountType.class), 0);
	}
	@Test(expected=NullPointerException.class)
	public void testAccount_accountHasNullAccountType() {
		this.account = new Account("fg1265fr459",Tools.today(), 120.25, 250, 0, 
				null, mock(CountryCode.class), null, 0);
	}
	@Test
	public void testGetId() {
		this.account.setId(1);
		assertEquals(1, this.account.getId());
	}

	@Test(expected=IllegalArgumentException.class)
	public void testSetId_isInvalid() {
		this.account.setId(-1);
	}
	public void testSetId() {
		this.account.setId(1);
	}
	@Test
	public void testGetAccountNumber() {
		assertEquals("fg1265fr459", this.account.getAccountNumber());
	}

	@Test
	public void testGetCreationDate() {
		assertEquals(Tools.today(), this.account.getCreationDate());
	}

	@Test
	public void testGetFirstTotal() {
		assertEquals(120.25, this.account.getFirstTotal(), 0);
	}

	@Test
	public void testGetOverdraft() {
		assertEquals(200, this.account.getOverdraft());
	}

	@Test
	public void testGetInterestRate() {
		assertEquals(0, this.account.getInterestRate(), 0);
	}

	@Test
	public void testGetAgency() {
		assertEquals(this.mockAgency, this.account.getAgency());
	}

	@Test
	public void testGetCountryCode() {
		assertEquals(this.mockCountryCode, this.account.getCountryCode());
	}

	@Test
	public void testGetAccountType() {
		assertEquals(this.mockAccountType, this.account.getAccountType());
	}

	@Test
	public void testGetAlertThresh() {
		assertEquals(0, this.account.getAlertThresh());
	}

	@Test
	public void testGetTransactions() {
		assertEquals(new ArrayList<PeriodicTransaction>(), this.account.getTransactions());
	}

	@Test
	public void testAddTransactions() {
		Account tmp_acc = this.account;
		PeriodicTransaction tmp = new PeriodicTransaction("Ligne 1",(Double)21.23, Tools.today(), Tools.today(), 2, "Ligne de test", 
				mock(TransactionType.class), mock(TargetTransaction.class), mock(Category.class), mock(PeriodUnit.class));
		int numberTransaction = this.account.getTransactions().size();
		tmp_acc.addTransactions(tmp);
		assertEquals(numberTransaction+1, this.account.getTransactions().size());
		
	}

}
