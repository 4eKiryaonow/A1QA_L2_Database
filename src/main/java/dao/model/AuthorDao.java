package dao.model;

import model.sql.Author;

public interface AuthorDao extends GenericDao<Author> {
    Author getByLogin(String login);
    boolean isCreated(Author author);
}