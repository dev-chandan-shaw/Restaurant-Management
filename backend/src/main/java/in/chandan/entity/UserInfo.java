package in.chandan.entity;
import jakarta.persistence.*;

@Entity
public class UserInfo { 

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY) 
	private int id;

	private String firstName;

	private String lastName;
	@Column(unique = true, nullable = false)
	private String email; 
	private String password; 
	private String roles;

	private String phone;

	private String gender;

	@OneToOne
	@JoinColumn(name = "orders", referencedColumnName = "id")
	private Orders orders;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getRoles() {
		return roles;
	}
	public void setRoles(String roles) {
		this.roles = roles;
	}

	public Orders getOrders() {
		return orders;
	}

	public void setOrders(Orders orders) {
		this.orders = orders;
	}

	public UserInfo() {
		this.roles = "ROLE_USER";
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
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

}
