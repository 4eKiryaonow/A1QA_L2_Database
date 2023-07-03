package dao.model;

import dao.model.GenericDao;
import model.sql.Test;

import java.util.List;

public interface TestDao extends GenericDao<Test> {
    long getLastInsertId();
    List<Test> getTestListByIdRegEx(String regExp);
}