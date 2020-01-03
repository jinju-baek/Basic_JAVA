package market;

import java.sql.Date;

public class SaleDTO {
	private int sno;
	private String sname;
	private int cnt;
	private int tprice;
	private Date regdate;
	
	public SaleDTO() {
		super();
	}

	public SaleDTO(int sno, String sname, int cnt, int tprice, Date regdate) {
		super();
		this.sno = sno;
		this.sname = sname;
		this.cnt = cnt;
		this.tprice = tprice;
		this.regdate = regdate;
	}

	public int getSno() {
		return sno;
	}

	public void setSno(int sno) {
		this.sno = sno;
	}

	public String getSname() {
		return sname;
	}

	public void setSname(String sname) {
		this.sname = sname;
	}

	public int getCnt() {
		return cnt;
	}

	public void setCnt(int cnt) {
		this.cnt = cnt;
	}

	public int getTprice() {
		return tprice;
	}

	public void setTprice(int tprice) {
		this.tprice = tprice;
	}

	public Date getRegdate() {
		return regdate;
	}

	public void setRegdate(Date regdate) {
		this.regdate = regdate;
	}

	@Override
	public String toString() {
		return "SaleDTO [sno=" + sno + ", sname=" + sname + ", cnt=" + cnt + ", tprice=" + tprice + ", regdate="
				+ regdate + "]";
	}
	
	
	
}
