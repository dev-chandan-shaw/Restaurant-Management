package in.chandan.entity;
import jakarta.persistence.*;

@Entity
public class UserInfo { 

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY) 
	private int id; 
	private String name; 
	private String email; 
	private String password; 
	private String roles;

	@OneToOne
	@JoinColumn(name = "orders", referencedColumnName = "id")
	private Orders orders;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
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

	@Override
	public String toString() {
		return "UserInfo{" +
				"name='" + name + '\'' +
				", email='" + email + '\'' +
				", roles='" + roles + '\'' +
				'}';
	}
}
