package pe.edu.upc.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "user_roles")
public class UserRol implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@ManyToOne
	@JoinColumn(name = "user_id", nullable = false)
	private User user;

	@ManyToOne
	@JoinColumn(name = "rol_id", nullable = false)
	private UserRol rol;
////////////////////////////
	public UserRol(int id, User user, UserRol rol) {
		super();
		this.id = id;
		this.user = user;
		this.rol = rol;
	}

	public UserRol() {
		super();
		// TODO Auto-generated constructor stub
	}

	////////////////////
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public UserRol getRol() {
		return rol;
	}

	public void setRol(UserRol rol) {
		this.rol = rol;
	}
	
}