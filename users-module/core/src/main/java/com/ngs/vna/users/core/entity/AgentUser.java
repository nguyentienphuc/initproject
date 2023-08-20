package com.ngs.vna.users.core.entity;


import io.jmix.core.metamodel.annotation.JmixEntity;
import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;

import java.util.List;

@JmixEntity
@Entity
@DiscriminatorValue("Agent")
public class AgentUser extends User{
    @OneToMany(mappedBy = "agentUser")
    protected List<SubAgentUser> subAgents;
}
