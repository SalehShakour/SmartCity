package person;

import java.time.LocalDate;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.logging.Logger;

public abstract class Person {

    private static final Logger logger = Logger.getLogger(Person.class.getName());
    private String firstName;
    private String lastName;
    private int age;
    private Gender gender;
    private LocalDate birthday;
    private String address;
    private String phoneNumber;
    private String email;

    public Person(String firstName, String lastName, int age, Gender gender, LocalDate birthday, String address, String phoneNumber, String email, BloodType bloodType) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        this.gender = gender;
        this.birthday = birthday;
        this.address = address;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.bloodType = bloodType;
    }

    /**
     * A regular expression pattern for validating email addresses.
     * <p>
     * The pattern enforces the following rules:
     * - The email address must have at least 1 and at most 64 characters before the @ symbol.
     * - The email address can contain alphanumeric characters, underscores, and hyphens.
     * - The email address can have multiple dot-separated segments before the @ symbol.
     * - The email address must have at least one character after the @ symbol.
     * - The email address can have multiple dot-separated segments after the @ symbol.
     * - The email address must have at least two characters after the last dot. */
    private final String validEmailRgx = "^(?=.{1,64}@)[A-Za-z0-9_-]+(\\.[A-Za-z0-9_-]+)*@[^-][A-Za-z0-9-]+(\\.[A-Za-z0-9-]+)*(\\.[A-Za-z]{2,})$";
    private BloodType bloodType;

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public LocalDate getBirthday() {
        return birthday;
    }

    public void setBirthday(LocalDate birthday) {
        this.birthday = birthday;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    /**
     * Sets the email address for the user.
     *
     * @param email The email address to set
     *              Validates an email address using a regular expression pattern.
     *              return True if the email address is valid, false otherwise */
    public void setEmail(String email) {
        Pattern pattern = Pattern.compile(validEmailRgx);
        Matcher matcher = pattern.matcher(email);
        if (matcher.matches()) {
            this.email = email;
        } else {
            logger.warning("Invalid email address");
        }
    }

    public String getValidEmailRgx() {
        return validEmailRgx;
    }

    public BloodType getBloodType() {
        return bloodType;
    }

    public void setBloodType(BloodType bloodType) {
        this.bloodType = bloodType;
    }
}
