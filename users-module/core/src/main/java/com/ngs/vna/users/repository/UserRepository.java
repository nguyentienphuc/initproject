package com.ngs.vna.users.repository;

import com.ngs.vna.users.core.entity.User;
import io.jmix.core.repository.JmixDataRepository;

import java.util.UUID;

public interface UserRepository extends JmixDataRepository<User, UUID> {
}
