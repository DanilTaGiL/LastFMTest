package ru.lastfm.REST.models;

public class SessionResponse {
    private Session session;
    public SessionResponse(){}

    public SessionResponse(Session session) {
        this.session = session;
    }

    public Session getSession() {
        return session;
    }

    public void setSession(Session session) {
        this.session = session;
    }

    @Override
    public String toString() {
        return "SessionResponse{" +
                "session=" + session +
                '}';
    }
}
