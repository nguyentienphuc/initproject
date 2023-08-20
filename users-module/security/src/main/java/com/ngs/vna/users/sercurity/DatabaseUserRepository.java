package com.ngs.vna.users.sercurity;


import com.ngs.vna.users.core.entity.User;
import io.jmix.securitydata.user.AbstractDatabaseUserRepository;
import org.springframework.context.annotation.Primary;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.stereotype.Component;

import java.util.Collection;
import java.util.Objects;
import java.util.stream.Collectors;

@Primary
@Component("UserRepository")
public class DatabaseUserRepository extends AbstractDatabaseUserRepository<User> {
    @Override
    protected Class<User> getUserClass() {
        return User.class;
    }

    @Override
    protected void initSystemUser(final User systemUser) {
        final Collection<GrantedAuthority> authorities = getGrantedAuthoritiesBuilder()
                .addResourceRole(FullAccessRole.CODE)
                .build();
        systemUser.setAuthorities(authorities);
    }

    @Override
    protected void initAnonymousUser(final User anonymousUser) {
    }



    @Override
    protected Collection<? extends GrantedAuthority> createAuthorities(String username) {
        return roleAssignmentRepository.getAssignmentsByUsername(username).stream()
                .map(this::createAuthority)
                .filter(Objects::nonNull)
                .collect(Collectors.toList());
    }
}
