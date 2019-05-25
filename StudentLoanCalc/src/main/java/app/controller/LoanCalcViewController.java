package app.controller;

import app.StudentCalc;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import java.net.URL;
import java.time.LocalDate;
import java.util.ResourceBundle;

import org.apache.poi.ss.formula.functions.FinanceLib;

import javafx.fxml.Initializable;
import javafx.event.ActionEvent;
import javafx.scene.control.DatePicker;

public class LoanCalcViewController implements Initializable   {

	private StudentCalc SC = null;
	
	@FXML
	private TextField LoanAmount;
	
	@FXML
	private TextField totalPayments;
	
	@FXML
	private TextField totalInterest;
	
	@FXML
	private TextField interestRate;
	
	@FXML
	private TextField term;
	
	@FXML
	private TextField additionalPayment;
	
	@FXML
	private Label lblTotalPayemnts;
	
	@FXML
	private DatePicker PaymentStartDate;
	
	
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
	}

	public void setMainApp(StudentCalc sc) {
		this.SC = sc;
	}
	
	/**
	 * btnCalcLoan - Fire this event when the button clicks
	 * 
	 * @version 1.0
	 * @param event
	 */
	@FXML
	private void btnCalcLoan(ActionEvent event) {

		double dInterestRate = Double.parseDouble(interestRate.getText())/12;
		double dLoanAmount = Double.parseDouble(LoanAmount.getText());
		double dTerm = Double.parseDouble(term.getText())*12;
		double dAdditionalPayment = Double.parseDouble(additionalPayment.getText());	

		
		if (dAdditionalPayment == 0) {
			double thePay = dTerm * 12;
			double well = Math.abs(FinanceLib.pmt(dInterestRate, dTerm, dLoanAmount, 0, false))*thePay-dLoanAmount;
			totalInterest.setText(Double.toString(well));
			totalPayments.setText(Double.toString(thePay));
		}else {
			double interest = (Math.abs(FinanceLib.pmt(dInterestRate, dTerm, dLoanAmount, 0, false))-dAdditionalPayment)*dTerm;
			double pay = interest/(Math.abs(FinanceLib.pmt(dInterestRate, dTerm, dLoanAmount, 0, false)));
			interest = interest - dLoanAmount;
			totalPayments.setText(Double.toString(pay));
			totalInterest.setText(Double.toString(interest));
		}
	}
}
