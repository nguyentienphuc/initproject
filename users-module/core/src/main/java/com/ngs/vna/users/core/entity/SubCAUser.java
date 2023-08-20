package com.ngs.vna.users.core.entity;


import io.jmix.core.metamodel.annotation.JmixEntity;
import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@JmixEntity
@Entity
@DiscriminatorValue("SubCA")
public class SubCAUser extends User {
    @JoinColumn(name = "ca_user_id")
    @ManyToOne(fetch = FetchType.LAZY)
    protected CAUser caUser;
}
