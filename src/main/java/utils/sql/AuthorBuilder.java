package utils.sql;

import hoard.sql.DataManager;
import model.sql.Author;
import service.sql.ServiceAuthor;

public class AuthorBuilder {
    public static Author getAuthorFromDB() {
        Author author = DataManager.getAuthor();
        ServiceAuthor serviceAuthor = new ServiceAuthor();
        serviceAuthor.createAuthor(author);
        author = serviceAuthor.findAuthor(author);
        return author;
    }
}