package model;
public class StudentUserDetails {
	
	//data members
	String username;
	String password;
	String mobileno;

	String firstName;
	String lastName;
	String location;
	int sid;
	String sname;
	String age;
	String address;

	//default constructor
	public StudentUserDetails() {
		super();
	}

	public int getSid() {
		return sid;
	}


	public StudentUserDetails(String username, String password, String mobileno, String firstName, String lastName,
			String location) {
		super();
		this.username = username;
		this.password = password;
		this.mobileno = mobileno;
		this.firstName = firstName;
		this.lastName = lastName;
		this.location = location;
			}
	public StudentUserDetails( int sid, String sname, String age, String address) {
		this.sid = sid;
		this.sname = sname;
		this.age = age;
		this.address = address;
	}
	
	public void setSid(int sid) {
		this.sid = sid;
	}


	public String getSname() {
		return sname;
	}


	public void setSname(String sname) {
		this.sname = sname;
	}


	public String getAge() {
		return age;
	}


	public void setAge(String age) {
		this.age = age;
	}


	public String getAddress() {
		return address;
	}


	public void setAddress(String address) {
		this.address = address;
	}


	public String getFirstName() {
		return firstName;
	}


	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}


	public String getLastName() {
		return lastName;
	}


	public void setLastName(String lastName) {
		this.lastName = lastName;
	}


	public String getLocation() {
		return location;
	}


	public void setLocation(String location) {
		this.location = location;
	}


	

	//getters and setters
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getMobileno() {
		return mobileno;
	}
	public void setMobileno(String mobileno) {
		this.mobileno = mobileno;
	}

	}

