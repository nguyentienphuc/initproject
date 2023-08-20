package com.ngs.vna.users.core.listener;

import io.jmix.core.DataManager;
import io.jmix.core.FileStorage;
import io.jmix.core.security.Authenticated;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationStartedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;


@Component
public class UserCoreDataInitializer {

    @Autowired
    private DataManager dataManager;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private FileStorage fileStorage;

    @EventListener
    @Authenticated
    public void onApplicationStarted(ApplicationStartedEvent event) {
    }

}