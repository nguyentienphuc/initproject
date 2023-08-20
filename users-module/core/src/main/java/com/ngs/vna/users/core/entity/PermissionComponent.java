package com.ngs.vna.users.core.entity;


import io.jmix.core.metamodel.annotation.JmixEntity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Index;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.Set;

@JmixEntity
@Table(name = "PermissionComponent", indexes = {
        @Index(name = "IDX_PERMISSION_ACTION_COMPONENT", columnList = "code"),
})
@Entity
@Data
@EqualsAndHashCode(callSuper=false)
public class PermissionComponent extends AbstractPermission{

    @Column(name = "order")
    protected Integer order;

    @JoinColumn(name = "group_id")
    @ManyToOne(fetch = FetchType.LAZY)
    protected PermissionComponentGroup group;

    @ManyToMany(mappedBy = "components")
    protected Set<PermissionAction> actions;
}
