package pkgUT;

import static org.junit.Assert.*;
import org.apache.poi.ss.formula.functions.*;
import org.junit.Test;

public class TestPMT {

	@Test
	public void test() {
		double PMT;
		double r = 0.07 / 12;
		double n = 20 * 12;
		double p = 150000;
		double f = 0;
		boolean t = false;
		PMT = Math.abs(FinanceLib.pmt(r, n, p, f, t));
		
		double PMTExpected = 1162.95;
		
		assertEquals(PMTExpected, PMT, 0.01);
		
		
		
	}
	
	@Test
	public void total_payments_test1() {
		double yearsOfLoan = 20;
		double expectedPayments = 240;
		double totalPayments = yearsOfLoan * 12;
		
		assertEquals(expectedPayments, totalPayments, 0.01);
		
	}
	
	@Test
	public void total_interest_test1() {
		double PMT;
		double r = 0.07 / 12;
		double n = 20 * 12;
		double p = 150000;
		double f = 0;
		boolean t = false;
		PMT = Math.abs(FinanceLib.pmt(r, n, p, f, t));
		
		double expectedInterest = 129107.62;
		
		double totalInterest = PMT*n-p;
		
		assertEquals(expectedInterest, totalInterest, 0.01);
		
	}
	
	/*
	@Test
	public void total_payments_test2() {
		double r = 0.07 / 12;
		double n = 20 * 12;
		double p = 150000;
		double f = 0;
		boolean t = false;
		double additional = 100;
		double PMT = Math.abs(FinanceLib.pmt(r, n, p, f, t));
		double expectedPayments = 203;
		double pay = 0;
		double interest = 0;
		
		while(additional < p) {
			interest = interest + PMT;
			pay++;
			p = p - additional;
		}
		
		assertEquals(expectedPayments, pay, 0.01);
	}
	*/
}

 

