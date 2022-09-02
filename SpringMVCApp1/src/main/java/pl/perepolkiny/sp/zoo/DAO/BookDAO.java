package pl.perepolkiny.sp.zoo.DAO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
import pl.perepolkiny.sp.zoo.models.Book;
import java.util.List;

@Component
public class BookDAO {
    private final JdbcTemplate jdbcTemplate;
    
    @Autowired
    public BookDAO(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<Book> index() {
        return jdbcTemplate.query("SELECT * FROM Book",
                new BeanPropertyRowMapper<>(Book.class));
    }

    public Book show(int id) {
        return jdbcTemplate.query("SELECT * FROM Book WHERE book_id=?",
                new Object[]{id}, new BeanPropertyRowMapper<>(Book.class))
                .stream().findAny().orElse(null);
    }

    public List<Book> getBookByPersonId(int id) {
        return jdbcTemplate.query("SELECT * FROM Book WHERE person_id=?",
                new Object[]{id}, new BeanPropertyRowMapper<>(Book.class));
            //    .stream().findAny().orElse(null);
    }

    public void save(Book Book) {
        jdbcTemplate.update("INSERT INTO Book(person_id, title, author, year) VALUES(?, ?, ?, ?)", Book.getPerson_id(),
                Book.getTitle(), Book.getAuthor(), Book.getYear());
    }

    public void update(int id, Book updatedBook) {
        jdbcTemplate.update("UPDATE Book SET person_id=?, title=?, author=?, year=?  WHERE book_id=?",
                updatedBook.getPerson_id(), updatedBook.getTitle(),
                updatedBook.getAuthor(), updatedBook.getYear(), id);
    }

    public void delete(int id) {
        jdbcTemplate.update("DELETE FROM Book WHERE book_id=?", id);
    }
}
