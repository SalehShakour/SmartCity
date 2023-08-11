package person;
import java.time.LocalDate;
public abstract class Person  {
    private String firstName;
    private String lastName;
    private int age;
    private Gender gender;
    private LocalDate birthday;
    private String address;
    private String phoneNumber;
    private String email;
    private final String validEmailRgx = "^(?=.{1,64}@)[A-Za-z0-9_-]+(\\.[A-Za-z0-9_-]+)*@[^-][A-Za-z0-9-]+(\\.[A-Za-z0-9-]+)*(\\.[A-Za-z]{2,})$";
    private BloodType bloodType;

}
