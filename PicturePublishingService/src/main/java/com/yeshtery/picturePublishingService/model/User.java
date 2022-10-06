package com.yeshtery.picturePublishingService.model;
import java.util.*;

import javax.persistence.*;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

@Entity
@Table(name = "\"User\"")
public class User implements UserDetails{
  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private Long id;
  public Long getId() {
	return id;
}
public String getUserName() {
	return userName;
}


@Column(nullable = false, unique = true,columnDefinition = "text")
  private String email;
@Column(columnDefinition = "text")
  private String address;
@Column(columnDefinition = "text")
  private String password;
@Column(columnDefinition = "text")
  private String userName;
  private boolean enabled;
  
  @ManyToMany
  @JoinTable(
      name = "user_role",
      joinColumns = @JoinColumn(name = "user_id"),
      inverseJoinColumns = @JoinColumn(name = "role_id")
  )
  private Set<Role> roles = new HashSet<>();
   
   

  @Override
  public Collection<? extends GrantedAuthority> getAuthorities() {
      List<SimpleGrantedAuthority> authorities = new ArrayList<>();
      for (Role role : roles) {
          authorities.add(new SimpleGrantedAuthority(role.getName()));
      }
      return authorities;
  }

  public Set<Role> getRoles() {
      return roles;
  }

  public void setRoles(Set<Role> roles) {
      this.roles = roles;
  }
   
  public void addRole(Role role) {
      this.roles.add(role);
  }
  
  @Override
  public String getUsername() {
      return this.email;
  }

  @Override
  public boolean isAccountNonExpired() {
      return true;
  }

  @Override
  public boolean isAccountNonLocked() {
      return true;
  }

  @Override
  public boolean isCredentialsNonExpired() {
      return true;
  }

  @Override
  public boolean isEnabled() {
      return true;
  }
  
  
  public User(String email, String password) {
      this.email = email;
      this.password = password;
  }
  
 

public void setEnabled(boolean enabled) {
	this.enabled = enabled;
}



public void setId(Long id) {
	this.id = id;
}

public String getEmail() {
	return email;
}

public void setEmail(String email) {
	this.email = email;
}

public String getAddress() {
	return address;
}

public void setAddress(String address) {
	this.address = address;
}

public String getPassword() {
	return password;
}

public void setPassword(String password) {
	this.password = password;
}

public String getUserName1() {
	return userName;
}

public void setUserName(String userName) {
	this.userName = userName;
}


  public User() {
  }



}