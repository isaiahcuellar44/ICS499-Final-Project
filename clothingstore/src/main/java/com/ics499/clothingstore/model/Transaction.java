package com.ics499.clothingstore.model;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

@Entity
public class Transaction implements Payment {

	@Id
	@GeneratedValue
	private long transactionId;
	
	private String PaymentMethod;// could this be a enum? like Visa, Mastercard, discover?
	private String creditCardNumber;
	private int creditCardCV;
	private Date creditCardExpirationDate;
	private long shoppingCartId;
	private double total;
	private Date transactionDate;
	private boolean isReturn;// should returns be it's own subclass?
	private long userAccountId;
	
	@ManyToOne(cascade = CascadeType.ALL)
	private User user;
	
	@OneToOne
	private ShoppingCart transactionCart;

	public Transaction(String paymentMethod, String creditCardNumber, int creditCardCV, Date creditCardExpirationDate,
			ShoppingCart cart, double total, Date transactionDate, boolean isReturn, long userAccountId) {
		super();
		PaymentMethod = paymentMethod;
		this.creditCardNumber = creditCardNumber;
		this.creditCardCV = creditCardCV;
		this.creditCardExpirationDate = creditCardExpirationDate;
		//this.cart = cart;
		this.total = total;
		this.transactionDate = transactionDate;
		this.isReturn = isReturn;
		this.userAccountId = userAccountId;
	}

	public Transaction() {

	}

	/**
	 * does this generate and return a PDF as a receipt?
	 */
	public void printReceipt() {

	}

	public String getPaymentMethod() {
		return PaymentMethod;
	}

	public void setPaymentMethod(String paymentMethod) {
		PaymentMethod = paymentMethod;
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
	/*
	public ShoppingCart getCart() {
		return cart;
	}

	public void setCart(ShoppingCart cart) {
		this.cart = cart;
	}
	 */
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

	public long getUserAccountId() {
		return userAccountId;
	}

	public void setUserAccountId(long userAccountId) {
		this.userAccountId = userAccountId;
	}

	/*
	@Override
	public String toString() {
		return "Transaction [PaymentMethod=" + PaymentMethod + ", creditCardNumber=" + creditCardNumber
				+ ", creditCardCV=" + creditCardCV + ", creditCardExpirationDate=" + creditCardExpirationDate
				+ ", cart=" + cart + ", total=" + total + ", transactionDate=" + transactionDate + ", isReturn="
				+ isReturn + ", userAccountId=" + userAccountId + "]";
	}
	*/
	@Override
	public String doSomeEncrypting() {
		return null;
	}

	public long getShoppingCartId() {
		return shoppingCartId;
	}

	public void setShoppingCartId(long shoppingCartId) {
		this.shoppingCartId = shoppingCartId;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
}