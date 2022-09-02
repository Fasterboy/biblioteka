package pl.perepolkiny.sp.zoo.models;



import javax.validation.constraints.Email;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import javax.validation.constraints.Pattern;

public class Person {
    private int person_id;
    @NotEmpty(message = "Surname should not be empty")
    @Size(min = 2, max = 100, message = "Surname should be between 2 and 30 characters")
    private String surname;
    @NotEmpty(message = "Birthday should not be empty")
    @Pattern(regexp="^(0?[1-9]|[12][0-9]|3[01])[\\/\\-](0?[1-9]|1[012])[\\/\\-]\\d{4}$", message = "Your birthday be in this format: 01/01/1900")
    private String birthday;

    public Person() {}

    public Person(int person_id, String surname, String birthday) {
        this.person_id = person_id;
        this.surname = surname;
        this.birthday = birthday;
    }

    public int getPerson_id() {
        return person_id;
    }

    public void setPerson_id(int person_id) {
        this.person_id = person_id;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

}
