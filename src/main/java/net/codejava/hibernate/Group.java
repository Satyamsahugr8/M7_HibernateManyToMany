package net.codejava.hibernate;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.*;

@Entity
@Table(name = "GROUPS")
public class Group {

	@Id
	@GeneratedValue
	@Column(name = "GROUP_ID")
	private long id;

	private String name;

	@ManyToMany(cascade = CascadeType.ALL)
	@JoinTable(name = "USERS_GROUPS", joinColumns = @JoinColumn(name = "GROUP_ID"), inverseJoinColumns = @JoinColumn(name = "USER_ID"))
	private Set<User> users = new HashSet<User>();

	public Group(String name) {
		this.name = name;
	}

	public void addUser(User user) {
		this.users.add(user);
	}

	
	
	// other getters and setters...

	public long getId() {
		return id;
	}
	
	public void setId(long id) {
		this.id = id;
	}

	public Set<User> getUsers() {
		return users;
	}
	
	public void setUsers(Set<User> users) {
		this.users = users;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	

	

}