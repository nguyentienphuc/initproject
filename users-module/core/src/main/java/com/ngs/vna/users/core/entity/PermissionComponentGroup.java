package com.ngs.vna.users.core.entity;

import com.ngs.vna.jmix.core.data.entity.BaseEntity;
import io.jmix.core.metamodel.annotation.JmixEntity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Index;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.EqualsAndHashCode;

@JmixEntity
@Table(name = "PermissionComponentGroup", indexes = {
        @Index(name = "IDX_PERMISSION_ACTION_COMPONENT", columnList = "code"),
})
@Entity
@Data
@EqualsAndHashCode(callSuper=false)
public class PermissionComponentGroup extends BaseEntity {
    @Column(name = "code")
    protected String code;

    @Column(name = "name")
    protected String name;
    @Column(name = "order")
    protected Integer order = 1;

    @Column(name = "user_type")
    protected String userType;

    public UserType getUserType() {
        return userType == null ? null : UserType.fromString(userType);
    }

    public void setUserType(UserType getUserType) {
        this.userType = getUserType == null ? null : getUserType.getId();
    }
}
