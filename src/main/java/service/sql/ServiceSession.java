package service.sql;

import dao.model.SessionDao;
import dao.implementation.SessionImpl;
import model.sql.Session;

public class ServiceSession {
    private SessionDao session;

    public ServiceSession() {
        session = new SessionImpl();
    }

    public void createSession(Session session) {
        this.session.add(session);
    }

    public Session getBySessionKey(Session session) {
        return this.session.getBySessionKey(session.getSessionKey());
    }
}