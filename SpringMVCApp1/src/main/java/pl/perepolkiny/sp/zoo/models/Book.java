package pl.perepolkiny.sp.zoo.models;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

public class Book {
    private int book_id;
 //   @NotEmpty(message = "Person id should not be empty")
 //   @Min(value = 0, message = "Default value if not owned by any person")
    private int person_id;
    @NotEmpty(message = "Title should not be empty")
    @Size(min = 2, max = 50, message = "Title should be between 2 and 50 characters")
    private String title;
    @Size(min = 2, max = 30, message = "Author should be between 2 and 30 characters")
    private String author;
    @Min(value = 0, message = "Year should be greater than 0")
    private int year;

    public Book(int book_id, int person_id, String title, String author, int year) {
        this.book_id = book_id;
        this.person_id = person_id;
        this.title = title;
        this.author = author;
        this.year = year;
    }

    public Book() {}

    public int getBook_id() {
        return book_id;
    }

    public void setBook_id(int book_id) {
        this.book_id = book_id;
    }

    public int getPerson_id() {
        return person_id;
    }

    public void setPerson_id(int person_id) {
        this.person_id = person_id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

}
