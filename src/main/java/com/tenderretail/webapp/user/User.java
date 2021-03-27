/*
 * Contactless Cons WebApp by Brian Donaldson
 * Copyright (c) 2020.  Brian Donaldson
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */

package com.tenderretail.webapp.user;

import com.tenderretail.api.domain.Address;
import com.tenderretail.webapp.user.UserRole;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

@Getter
@Setter
@EqualsAndHashCode
@NoArgsConstructor
@Entity
public class User implements UserDetails {

    private final static long serialVersionUID = 270727596527329664L;

    private long id;
    private String firstName;
    private String lastName;
    private Address address;
    private String email;
    private String phoneNumber;
    private String password;
    @Enumerated(EnumType.STRING)
    private UserRole userRole;
    private Boolean locked = false;
    private Boolean enabled = false;

    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    public User(String firstName,
                String lastName,
                String email,
                String password,
                UserRole userRole) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.password = password;
        this.userRole = userRole;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        SimpleGrantedAuthority authority =
                new SimpleGrantedAuthority(userRole.name());
        return Collections.singletonList(authority);
    }

    @Override
    public String getUsername() {
        return email;
    }

    @Override
    public String getPassword() {
        return password;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return !locked;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return enabled;
    }
}