package edu.ti.caih313.collections.dataobj;

import java.time.DateTimeException;
import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;

public class Person {
    private Name name;
    private Gender gender;

    private EmailAddress emailAddress;

    private LocalDate birthDate;

    public enum Gender {MALE, FEMALE}

    public Person(Name name, Gender gender, LocalDate birthDate) {
        this.name = name;
        this.gender = gender;
        this.birthDate = birthDate;
    }
    public void  addEmailAddress(String email, EmailAddress.Type type){
        if (getEmail() == null){
            emailAddress = new EmailAddress(email, type);
        }
        else{
            emailAddress.getEmailMap().put(type, email);
        }

    }
    public EmailAddress getEmail(){
        if (emailAddress == null){
            emailAddress = new EmailAddress();

        }
        return emailAddress;
    }


    public Name getName() {
        return name;
    }

    public void setName(Name name) {
        this.name = name;
    }

    public Gender getGender() {
        return gender;
    }

    public Integer getAge() {
        Period ageNow = Period.between(birthDate, LocalDate.now());
        return ageNow.getYears();
    }
    DateTimeFormatter format = DateTimeFormatter.ofPattern("MMM d, yyyy 'CE'");







    public String toString() {
        return String.format("Person{name=%s, gender=%s, birthDate=%s, emails=%s}", name, gender, birthDate.format(format), getEmail().toString());
    }
}
