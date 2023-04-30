package com.ics499.clothingstore.model;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

/**
 * Transaction model. Extension of Payment, Transaction is the confirmation of
 * payment when a order is placed.
 * 
 * @author Dylan Skokan - Isaiah Cuellar - Tom Waterman - Justin Pham - Kyle
 *         McClernon
 *
 */
@Entity
public class Transaction implements Payment {

	@Id
	@GeneratedValue
	private long transactionId;

	private String paymentMethod;// could this be a enum? like Visa, Mastercard, discover?
	private String creditCardNumber;
	private int creditCardCV;
	private Date creditCardExpirationDate;
	private double total;
	private Date transactionDate;
	private boolean isReturn;// should returns be it's own subclass?

	@OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL) // TomW
	@JoinColumn(name = "orderId")
	private Order order;

	public Transaction(String paymentMethod, String creditCardNumber, int creditCardCV, Date creditCardExpirationDate,
			double total, Date transactionDate, boolean isReturn) {
		super();
		this.paymentMethod = paymentMethod;
		this.creditCardNumber = creditCardNumber;
		this.creditCardCV = creditCardCV;
		this.creditCardExpirationDate = creditCardExpirationDate;
		this.total = total;
		this.transactionDate = transactionDate;
		this.isReturn = isReturn;
	}

	public Transaction() {

	}

	public Order getOrder() {
		return order;
	}

	public void setOrder(Order order) {
		this.order = order;
	}

	public String getPaymentMethod() {
		return paymentMethod;
	}

	public void setPaymentMethod(String paymentMethod) {
		this.paymentMethod = paymentMethod;
	}

	public String getCreditCardNumber() {
		return creditCardNumber;
	}

	public void setCreditCardNumber(String creditCardNumber) {
		this.creditCardNumber = creditCardNumber;
	}

	public int getCreditCardCV() {
		return creditCardCV;
	}

	public void setCreditCardCV(int creditCardCV) {
		this.creditCardCV = creditCardCV;
	}

	public Date getCreditCardExpirationDate() {
		return creditCardExpirationDate;
	}

	public void setCreditCardExpirationDate(Date creditCardExpirationDate) {
		this.creditCardExpirationDate = creditCardExpirationDate;
	}

	public double getTotal() {
		return total;
	}

	public void setTotal(double total) {
		this.total = total;
	}

	public Date getTransactionDate() {
		return transactionDate;
	}

	public void setTransactionDate(Date transactionDate) {
		this.transactionDate = transactionDate;
	}

	public boolean isReturn() {
		return isReturn;
	}

	public void setReturn(boolean isReturn) {
		this.isReturn = isReturn;
	}

	/*
	 * @Override public String toString() { return "Transaction [PaymentMethod=" +
	 * PaymentMethod + ", creditCardNumber=" + creditCardNumber + ", creditCardCV="
	 * + creditCardCV + ", creditCardExpirationDate=" + creditCardExpirationDate +
	 * ", cart=" + cart + ", total=" + total + ", transactionDate=" +
	 * transactionDate + ", isReturn=" + isReturn + ", userAccountId=" +
	 * userAccountId + "]"; }
	 */

	@Override
	public String doSomeEncrypting() {
		return null;
	}
}