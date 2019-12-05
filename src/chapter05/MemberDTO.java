package chapter05;

// DTO : Data Trasfer Object
// DAO(CRUD)작업에 필요한 데이터를
// 전송할 때 편리하게 전송하기위한 가방 역할
public class MemberDTO {
	// MemberDTO는 회원관련된 정보를 담을 수 있는 가방
	// DTO의 정속 4가지 기능
	// 1. 가방의 포켓을 정의(가방에 넣을 수 있는 값을 정의)
	// 2. 가방에 값을 담는 기능
	// 3. 값을 숨기는 기능(보안) Getter() &Setter()
	// 4. 가방에 담겨있는 값을 보여주는 기능

	// 1) 가방 포켓 정의(7칸)
	String id;
	String pw;
	int age;
	String name;
	String email;
	String phone;
	String address;

	// 2) 가방에 담는 기능
	// - 디폴트 생성자
	public MemberDTO() {
	}

	// - 오버로딩 생성자
	// 회원가입시 필요한 7개의 값을 담는 기능
	public MemberDTO(String id, String pw, int age, String name, String email, String phone, String address) {
		super();
		this.id = id;
		this.pw = pw;
		this.age = age;
		this.name = name;
		this.email = email;
		this.phone = phone;
		this.address = address;
	}

	// 회원수정시 필요한 6개의 값을 담는 기능
	public MemberDTO(String pw, int age, String name, String email, String phone, String address) {
		super();
		this.pw = pw;
		this.age = age;
		this.name = name;
		this.email = email;
		this.phone = phone;
		this.address = address;
	}

	// 회원(이름)조회시 필요한 1개의 값을 담는 기능
	public MemberDTO(String name) {
		super();
		this.name = name;
	}

	// 로그인시 필요한 2가지 기능 값을 담는 기능
	public MemberDTO(String id, String pw) {
		super();
		this.id = id;
		this.pw = pw;
	}

	// 3번 캡슐화(은닉) Getter() & Setter()
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

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	// 4번 DTO에 담겨 있는 모든 값을 출력하는 기능
	@Override
	public String toString() {
		return "MemberDTO [id=" + id + ", pw=" + pw + ", age=" + age + ", name=" + name + ", email=" + email
				+ ", phone=" + phone + ", address=" + address + "]";
	}



}
