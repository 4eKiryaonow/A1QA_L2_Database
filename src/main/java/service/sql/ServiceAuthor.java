package service.sql;

import dao.model.AuthorDao;
import dao.implementation.AuthorImpl;
import model.sql.Author;

public class ServiceAuthor {
    private AuthorDao author;

    public ServiceAuthor() {
        this.author = new AuthorImpl();
    }

    public Author findAuthor(Author author) {
        return this.author.getByLogin(author.getLogin());
    }

    public void createAuthor(Author author) {
        if (!this.author.isCreated(author)) {
            this.author.add(author);
        }
    }
}