package com.ngs.vna.users.core.entity;

import com.ngs.vna.jmix.core.data.entity.BaseEntity;
import io.jmix.core.HasTimeZone;
import io.jmix.core.annotation.Secret;
import io.jmix.core.entity.annotation.SystemLevel;
import io.jmix.core.metamodel.annotation.InstanceName;
import io.jmix.core.metamodel.annotation.JmixEntity;
import io.jmix.security.authentication.JmixUserDetails;
import jakarta.persistence.Column;
import jakarta.persistence.DiscriminatorColumn;
import jakarta.persistence.DiscriminatorType;
import jakarta.persistence.Entity;
import jakarta.persistence.Index;
import jakarta.persistence.Inheritance;
import jakarta.persistence.InheritanceType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
import jakarta.persistence.Transient;
import jakarta.validation.constraints.Email;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.springframework.security.core.GrantedAuthority;

import java.util.Collection;
import java.util.Collections;
import java.util.Set;

@JmixEntity
@Entity
@Table(name = "USER", indexes = {
        @Index(name = "IDX_USER__ON_USERNAME", columnList = "USERNAME", unique = true),
        @Index(name = "IDX_USER__ON_EMAIL", columnList = "EMAIL", unique = true)
})
@Data
@EqualsAndHashCode(callSuper=false)
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name="user_type",
        discriminatorType = DiscriminatorType.STRING)
public class User extends BaseEntity implements JmixUserDetails, HasTimeZone {


    @InstanceName
    @Column(name = "username", nullable = false)
    protected String username;
    @Secret
    @SystemLevel
    @Column(name = "password")
    protected String password;

    @Email
    @Column(name = "email")
    protected String email;

    @Column(name = "ACTIVE")
    protected Boolean active = true;

    @Column(name = "time_zone_id")
    protected String timeZoneId;

    @Column(name = "office_id", nullable = false)
    protected String office_id;


    @ManyToMany
    @JoinTable(
            name = "RoleUser",
            joinColumns = @JoinColumn(name = "role_id"),
            inverseJoinColumns = @JoinColumn(name = "user_id"))
    protected Set<Role> roles;


    @Transient
    protected Collection<? extends GrantedAuthority> authorities;
    public void setAuthorities(Collection<? extends GrantedAuthority> authorities){
        this.authorities = authorities;
    }
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return authorities != null ? authorities : Collections.emptyList();
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
        return Boolean.TRUE.equals(active);
    }


}