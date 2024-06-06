package com.projectonecs320.Classes;

/**
 * Represents a Training Session.
 */
public class Session {

    private String id;

    public static class SessionBuilder {

        private String id;

        public SessionBuilder(String id) {
            this.id = id;
        }

        public Session buildSession() {
            return new Session(this);
        }
    }

    private Session(SessionBuilder SessionBuilder) {
        id = SessionBuilder.id;
    }

    /**
     * Retrieves the ID of the Session.
     * 
     * @return The ID of the Session.
     */
    public String getId() {
        return id;
    }

    /**
     * For testing purpose only.
     * 
     * @param id
     */
    public void setId(String id) {
        this.id = id;
    }
}
