package com.ngs.vna.jmix.core.data.entity;


import io.jmix.core.annotation.DeletedBy;
import io.jmix.core.annotation.DeletedDate;
import io.jmix.core.entity.annotation.JmixGeneratedValue;
import jakarta.persistence.Column;
import jakarta.persistence.Id;
import jakarta.persistence.MappedSuperclass;
import jakarta.persistence.Version;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;

import java.util.Date;
import java.util.UUID;


@Data
@MappedSuperclass
@EqualsAndHashCode(callSuper=false)
public abstract class BaseEntity {

    @Id
    @Column(name = "id", nullable = false)
    @JmixGeneratedValue
    private UUID id;

    @Version
    @Column(name = "version", nullable = false)
    private Integer version;

    @CreatedBy
    @Column(name = "created_by")
    private String createdBy;

    @CreatedDate
    @Column(name = "created_ts")
    private Date createdTs;

    @LastModifiedBy
    @Column(name = "last_modified_by")
    private String lastModifiedBy;

    @LastModifiedDate
    @Column(name = "last_modified_ts")
    private Date lastModifiedTs;

    @DeletedBy
    @Column(name = "deleted_by")
    private String deletedBy;

    @DeletedDate
    @Column(name = "deleted_ts")
    private Date deletedTs;
}
