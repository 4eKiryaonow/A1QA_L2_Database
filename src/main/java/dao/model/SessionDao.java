package dao.model;

import dao.model.GenericDao;
import model.sql.Session;

public interface SessionDao extends GenericDao<Session> {
    Session getBySessionKey(String sessionKey);
}