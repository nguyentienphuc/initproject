package com.ngs.vna.users.core.entity;

import io.jmix.core.metamodel.annotation.JmixEntity;
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
@Table(name = "PermissionAction", indexes = {
        @Index(name = "IDX_PERMISSION_ACTION_CODE", columnList = "code"),
})
@Entity
@Data
@EqualsAndHashCode(callSuper=false)
public class PermissionAction extends AbstractPermission {
    @ManyToMany
    @JoinTable(
            name = "PermissionComponentAction",
            joinColumns = @JoinColumn(name = "action_id"),
            inverseJoinColumns = @JoinColumn(name = "component_id"))
    protected Set<PermissionComponent> components;
}
