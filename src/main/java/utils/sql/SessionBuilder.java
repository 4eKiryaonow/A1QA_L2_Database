package utils.sql;

import hoard.sql.DataManager;
import model.sql.Session;
import org.testng.ITestResult;
import service.sql.ServiceSession;
import java.sql.Timestamp;
public class SessionBuilder {
    public static Session buildSession(ITestResult iTestResult) {
        Session session = new Session();
        session.setSessionKey(iTestResult.id());
        session.setCreatedTime(new Timestamp(iTestResult.getStartMillis()));
        session.setBuildNumber(DataManager.getBuildNumber());
        return session;
    }
    public static Session getSessionFromDB(ITestResult iTestResult) {
        Session session = buildSession(iTestResult);
        ServiceSession serviceSession = new ServiceSession();
        serviceSession.createSession(session);
        return serviceSession.getBySessionKey(session);
    }
}