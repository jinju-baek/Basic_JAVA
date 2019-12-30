package problem.bank;

import java.sql.Date;

public class BankDTO {
	private int bno;
	private String bname;
	private String pw;
	private int money;
	private Date regdate;
	
	public BankDTO() {
		super();
	}

	public BankDTO(String bname, String pw) {
		super();
		this.bname = bname;
		this.pw = pw;
	}
	
	public BankDTO(int bno, int money) {
		super();
		this.bno = bno;
		this.money = money;
	}
	
	public BankDTO(int bno, String pw) {
		super();
		this.bno = bno;
		this.pw = pw;
	}

	public BankDTO(int bno, String bname, String pw, int money, Date regdate) {
		super();
		this.bno = bno;
		this.bname = bname;
		this.pw = pw;
		this.money = money;
		this.regdate = regdate;
	}

	public int getBno() {
		return bno;
	}

	public void setBno(int bno) {
		this.bno = bno;
	}

	public String getBname() {
		return bname;
	}

	public void setBname(String bname) {
		this.bname = bname;
	}

	public String getPw() {
		return pw;
	}

	public void setPw(String pw) {
		this.pw = pw;
	}

	public int getMoney() {
		return money;
	}

	public void setMoney(int money) {
		this.money = money;
	}

	public Date getRegdate() {
		return regdate;
	}

	public void setRegdate(Date regdate) {
		this.regdate = regdate;
	}

	@Override
	public String toString() {
		return "BankDTO [bno=" + bno + ", bname=" + bname + ", pw=" + pw + ", money=" + money + ", regdate=" + regdate
				+ "]";
	}
	
	
}
