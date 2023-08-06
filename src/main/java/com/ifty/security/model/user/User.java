package com.ifty.security.model.user;

import java.util.Collection;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="_usert")
public class User implements UserDetails {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	private String firstname;
	private String lastname;
	private String email;
	private String password;
	@Enumerated(EnumType.STRING)
	private Role role;
	
	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		return List.of(new SimpleGrantedAuthority(role.name()));
	}
	 @Override
	  public String getPassword() {
	    return password;
	  }

	  @Override
	  public String getUsername() {
	    return email;
	  }
	@Override
	public boolean isAccountNonExpired() {

		return false;
	}
	@Override
	public boolean isAccountNonLocked() {

		return false;
	}
	@Override
	public boolean isCredentialsNonExpired() {

		return false;
	}
	@Override
	public boolean isEnabled() {

		return false;
	}


}
