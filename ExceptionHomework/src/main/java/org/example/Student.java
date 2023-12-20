package org.example;

public class Student {
   private String cnp;
    private String firstName;
   private String lastName;
    private String dateOfBirth;
    private Gender gender;

    public Student(String cnp, String firstName, String lastName, String dateOfBirth, Gender gender) {
        this.cnp = cnp;
        this.firstName = firstName;
        this.lastName = lastName;
        this.dateOfBirth = dateOfBirth;
        this.gender = gender;
    }

    public String getCnp() {
        return cnp;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public Gender getGender() {
        return gender;
    }

    @Override
    public String toString() {
        return "Student{" +
                "cnp='" + cnp + '\'' +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", dateOfBirth='" + dateOfBirth + '\'' +
                ", gender=" + gender +
                '}';
    }
    public static int calculateAge(String dateOfBirth){
        String[] tokens= dateOfBirth.split("/");
        int yearOfBirth=Integer.parseInt(tokens[2]);
        return 2023-yearOfBirth;

    }
}
