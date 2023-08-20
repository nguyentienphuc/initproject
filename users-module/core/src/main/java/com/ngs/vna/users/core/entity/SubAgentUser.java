package com.ngs.vna.users.core.entity;

import io.jmix.core.metamodel.annotation.JmixEntity;
import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@JmixEntity
@Entity
@DiscriminatorValue("SubAgent")
public class SubAgentUser extends User{
    @JoinColumn(name = "agent_user_id")
    @ManyToOne(fetch = FetchType.LAZY)
    protected AgentUser agentUser;
}
