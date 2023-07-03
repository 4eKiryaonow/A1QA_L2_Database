package service.sql;

import dao.model.TestDao;
import dao.implementation.TestImpl;
import model.sql.Test;

import java.util.List;

public class ServiceTest {
    private TestDao test;

    public ServiceTest() {
        this.test = new TestImpl();
    }

    public List<Test> getAllTest() {
        return this.test.getAll();
    }

    public Test getTest(long testId) {
        return this.test.getById(testId);
    }

    public void createTest(Test test) {
        this.test.add(test);
    }

    public void removeTest(Test test) {
        this.test.delete(test);
    }

    public long getLastIdCreatedTest() {
        return this.test.getLastInsertId();
    }
    public List<Test> getTestListByRegExp(String regExp) {
        return this.test.getTestListByIdRegEx(regExp);
    }
}