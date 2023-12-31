package net.codejava.hibernate;
 
import java.util.HashSet;
import java.util.Set;
 
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
 
@Entity
@Table(name = "USERS")
public class User {
	
	@Id
    @GeneratedValue
    @Column(name = "USER_ID")
    private long id;
	
    private String username;
    private String password;
    private String email;
 
    @ManyToMany(mappedBy = "users")
    private Set<Group> groups = new HashSet<Group>();
 
    public User(String username, String password, String email) {
        this.username = username;
        this.password = password;
        this.email = email;
    }
 
    public void addGroup(Group group) {
        this.groups.add(group);
    }
 
    
    public long getId() {
        return id;
    }
 
    
    public Set<Group> getGroups() {
        return groups;
    }

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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public void setId(long id) {
		this.id = id;
	}

	public void setGroups(Set<Group> groups) {
		this.groups = groups;
	}
 
    // other getters and setters...
    
}