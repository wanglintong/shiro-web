package cn.com.zlqf.shiro.entity;

import java.io.Serializable;
import java.util.List;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

import org.hibernate.annotations.Fetch;

@Entity(name="t_role")
public class Role implements Serializable{
	private String id;
	private String name;
	private Set<Permission> permissions;
	
	@Id
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	@JoinTable(name="t_role_permission",joinColumns={@JoinColumn(name="role_id",referencedColumnName="id")},
			inverseJoinColumns={@JoinColumn(name="permission_id",referencedColumnName="id")})
	@ManyToMany(fetch=FetchType.EAGER)
	public Set<Permission> getPermissions() {
		return permissions;
	}
	public void setPermissions(Set<Permission> permissions) {
		this.permissions = permissions;
	}
	@Override
	public String toString() {
		return "Role [id=" + id + ", name=" + name + ", permissions=" + permissions + "]";
	}
}
