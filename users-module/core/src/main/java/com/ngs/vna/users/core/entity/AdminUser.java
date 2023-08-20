package com.ngs.vna.users.core.entity;


import io.jmix.core.metamodel.annotation.JmixEntity;
import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;

@JmixEntity
@Entity
@DiscriminatorValue("Admin")
public class AdminUser extends User{
}
