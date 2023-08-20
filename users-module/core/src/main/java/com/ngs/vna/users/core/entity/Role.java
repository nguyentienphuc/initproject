package com.ngs.vna.users.core.entity;

import com.ngs.vna.jmix.core.data.entity.BaseEntity;
import io.jmix.core.entity.annotation.SystemLevel;
import io.jmix.core.metamodel.annotation.JmixEntity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Index;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.Set;


@JmixEntity
@Table(name = "Roles", indexes = {
        @Index(name = "IDX_ROLES", columnList = "code"),
})
@Entity
@Data
@EqualsAndHashCode(callSuper=false)
@SystemLevel
public class Role extends BaseEntity {

    @Column(name = "code")
    protected String code;

    @Column(name = "name")
    protected String name;

    @Column(name = "ACTIVE")
    protected Boolean active = true;

    @ManyToMany
    @JoinTable(
            name = "RolePermissionComponent",
            joinColumns = @JoinColumn(name = "role_id"),
            inverseJoinColumns = @JoinColumn(name = "component_id"))
    protected Set<PermissionComponent> components;
}
