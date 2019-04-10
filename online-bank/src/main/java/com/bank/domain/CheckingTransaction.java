package com.bank.domain;

import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name= "CHECKINGTRANSACTION", catalog = "ONLINEBANKING")
public class CheckingTransaction {




	//    @Id
//    @GeneratedValue(strategy = GenerationType.AUTO)
	@Id
	@SequenceGenerator(name="CHECKINGTRANSACTION_SEQ_GEN", sequenceName="CHECKINGTRANSACTION_SEQ", allocationSize=1)
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator="CHECKINGTRANSACTION_SEQ_GEN")
	@Column(nullable = false, name = "ID")
    private Long id;
    private Date transactionDate;
    private String description;
    private String type;
    private String status;
    private double amount;
    private BigDecimal availableBalance;

    public CheckingTransaction() {}
    
    public CheckingTransaction(Date transactionDate, String description, String type, String status,
			double amount, BigDecimal availableBalance, CheckingAccount checkingAccount) {
		this.transactionDate = transactionDate;
		this.description = description;
		this.type = type;
		this.status = status;
		this.amount = amount;
		this.availableBalance = availableBalance;
		this.checkingAccount = checkingAccount;
	}


    @ManyToOne
    @JoinColumn(name = "checking_account_id")
    private CheckingAccount checkingAccount;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public BigDecimal getAvailableBalance() {
        return availableBalance;
    }

    public void setAvailableBalance(BigDecimal availableBalance) {
        this.availableBalance = availableBalance;
    }

    public CheckingAccount getCheckingAccount() {
        return checkingAccount;
    }

    public void setCheckingAccount(CheckingAccount checkingAccount) {
        this.checkingAccount = checkingAccount;
    }

	public Date getTransactionDate() {
		return transactionDate;
	}

	public void setTransactionDate(Date transactionDate) {
		this.transactionDate = transactionDate;
	}

}
