package com.ngs.vna.users.core.entity;

import com.ngs.vna.jmix.core.data.entity.BaseEntity;
import io.jmix.core.metamodel.annotation.JmixEntity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Inheritance;
import jakarta.persistence.InheritanceType;
import jakarta.persistence.MappedSuperclass;
import lombok.Data;
import lombok.EqualsAndHashCode;


@Data
@Entity
@JmixEntity
@MappedSuperclass
@EqualsAndHashCode(callSuper=false)
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public class AbstractPermission extends BaseEntity {
    @Column(name = "code")
    protected String code;

    @Column(name = "name")
    protected String name;

    @Column(name = "user_type")
    protected String userType;

    public UserType getUserType() {
        return userType == null ? null : UserType.fromString(userType);
    }

    public void setUserType(UserType getUserType) {
        this.userType = getUserType == null ? null : getUserType.getId();
    }


    @Column(name = "service_id")
    protected String serviceId;
}
