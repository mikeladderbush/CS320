package com.projectonecs320.Factories;

import java.util.function.Consumer;

import com.projectonecs320.Classes.Session;
import com.projectonecs320.Services.SessionService;

public class SessionFactory {

    private static final SessionService sessionService = new SessionService();

    // Method to create a Session with default values
    public static Session createSession() {
        String id = sessionService.generateId();
        return new Session.SessionBuilder(id).buildSession();
    }

    public static Session createSession(Consumer<Session.SessionBuilder> consumer) {
        String id = sessionService.generateId();
        Session.SessionBuilder builder = new Session.SessionBuilder(id);
        consumer.accept(builder);
        return builder.buildSession();
    }
}
