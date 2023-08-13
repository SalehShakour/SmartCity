package person;

import java.time.LocalDate;

public class RegularPerson extends Person {

    public RegularPerson(String firstName, String lastName, int age, Gender gender, LocalDate birthday, String address, String phoneNumber, String email, BloodType bloodType) {
        super(firstName, lastName, age, gender, birthday, address, phoneNumber, email, bloodType);
    }
}
