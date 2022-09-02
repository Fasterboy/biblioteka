package pl.perepolkiny.sp.zoo.util;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;
import pl.perepolkiny.sp.zoo.DAO.BookDAO;
import pl.perepolkiny.sp.zoo.models.Book;

@Component
public class BookValidator implements Validator {
    private final BookDAO bookDAO;

    @Autowired
    public BookValidator(BookDAO bookDAO) {
        this.bookDAO = bookDAO;
    }

    @Override
    public boolean supports(Class<?> aClass) {
        return Book.class.equals(aClass);
    }

    @Override
    public void validate(Object o, Errors errors) {
        Book book = (Book) o;
        // if(personDAO.show(person.getEmail()).isPresent())
        //     errors.rejectValue("email" ,"", "This email is already token");
    }
}
