package org.demo.guicedemo.server.impl;

import com.google.inject.Provider;

import javax.inject.Inject;

public class SessionManager {
    private final Provider<Long> sessionIdProvider;

    @Inject
    public SessionManager(@SessionId Provider<Long> sessionIdProvider) {
        super();
        this.sessionIdProvider = sessionIdProvider;
    }

    public Long getSessionId() {
        return sessionIdProvider.get();
    }

}
