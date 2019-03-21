package evrybank.model;

public class Account {

	private int aid;
	private String bankName;
	
	private int accountNumber;
	private String accountType;
	private String branchName;
	
	public Account(int aid, String bankName, int accountNumber, String accountType, String branchName,
			int depositAmount) {
		super();
		this.aid = aid;
		this.bankName = bankName;
		this.accountNumber = accountNumber;
		this.accountType = accountType;
		this.branchName = branchName;
		this.depositAmount = depositAmount;
	}

	private int depositAmount;
	
	public Account() {
		super();
	}

	public int getAid() {
		return aid;
	}

	public void setAid(int aid) {
		this.aid = aid;
	}

	public String getBankName() {
		return bankName;
	}

	public void setBankName(String bankName) {
		this.bankName = bankName;
	}

	public int getAccountNumber() {
		return accountNumber;
	}

	public void setAccountNumber(int accountNumber) {
		this.accountNumber = accountNumber;
	}

	public String getAccountType() {
		return accountType;
	}

	public void setAccountType(String accountType) {
		this.accountType = accountType;
	}

	public String getBranchName() {
		return branchName;
	}

	public void setBranchName(String branchName) {
		this.branchName = branchName;
	}

	public int getDepositAmount() {
		return depositAmount;
	}

	public void setDepositAmount(int depositAmount) {
		this.depositAmount = depositAmount;
	}
	
	
	
	
	
}
