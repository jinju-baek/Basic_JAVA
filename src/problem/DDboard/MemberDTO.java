package problem.DDboard;

import java.sql.Date;

public class MemberDTO {
	
	private String id;
	private String pw;
	private String name;
	private String PHONE;
	private Date date;
	
	public MemberDTO(String id, String pw, String name, String pHONE, Date date) {
		super();
		this.id = id;
		this.pw = pw;
		this.name = name;
		PHONE = pHONE;
		this.date = date;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getPw() {
		return pw;
	}

	public void setPw(String pw) {
		this.pw = pw;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPHONE() {
		return PHONE;
	}

	public void setPHONE(String pHONE) {
		PHONE = pHONE;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	@Override
	public String toString() {
		return "MemberDTO [id=" + id + ", pw=" + pw + ", name=" + name + ", PHONE=" + PHONE + ", date=" + date + "]";
	}
	
	
	
}
