package edu.ti.caih313.collections.dataobj;

import org.junit.Test;

import java.time.LocalDate;
import java.time.Month;

import static edu.ti.caih313.collections.dataobj.Person.Gender.MALE;
import static org.junit.Assert.*;

public class EmailAddressTest {

    @Test
    public void getEmailAddressIfThreeEmails() {
        Person smith = new Person(new Name("John", "Smith"), MALE, LocalDate.of(1978, Month.MARCH, 15));
        smith.addEmailAddress("smith@home", EmailAddress.Type.HOME);
        smith.addEmailAddress("smith@work", EmailAddress.Type.WORK);
        smith.addEmailAddress("smith@school", EmailAddress.Type.SCHOOL);
        assertEquals("smith@home", smith.getEmail().getEmailAddress());
    }
    @Test
    public void getEmailAddressIfNoEmails(){
        Person smith = new Person(new Name("John", "Smith"), MALE, LocalDate.of(1978, Month.MARCH, 15));
        assertNull(smith.getEmail().getEmailAddress());
    }

    @Test
    public void testGetEmailAddressOfCertainType() {
        Person smith = new Person(new Name("John", "Smith"), MALE, LocalDate.of(1978, Month.MARCH, 15));
        assertNull(smith.getEmail().getEmailAddress(EmailAddress.Type.HOME));
        smith.addEmailAddress("smith@home", EmailAddress.Type.HOME);
        smith.addEmailAddress("smith@work", EmailAddress.Type.WORK);
        smith.addEmailAddress("smith@school", EmailAddress.Type.SCHOOL);
        assertEquals("smith@home", smith.getEmail().getEmailAddress(EmailAddress.Type.HOME));

    }

    @Test
    public void testToStringWithThreeEmails(){//also tests if the replace function works
       Person smith = new Person(new Name("John", "Smith"), MALE, LocalDate.of(1978, Month.MARCH, 15));
       smith.addEmailAddress("smith@home", EmailAddress.Type.HOME);
       smith.addEmailAddress("jsmith@home", EmailAddress.Type.HOME);
       smith.addEmailAddress("smith@work", EmailAddress.Type.WORK);
       smith.addEmailAddress("smith@school", EmailAddress.Type.SCHOOL);
       assertEquals("<HOME: jsmith@home, WORK: smith@work, SCHOOL: smith@school>", smith.getEmail().toString());
    }
    @Test
    public void testToStringWithNoEmail(){
        Person smith = new Person(new Name("John", "Smith"), MALE, LocalDate.of(1978, Month.MARCH, 15));
        assertEquals("<no email address available>", smith.getEmail().toString());

    }
    @Test
    public void testToStringWithOneEmail(){
        Person smith = new Person(new Name("John", "Smith"), MALE, LocalDate.of(1978, Month.MARCH, 15));
        smith.addEmailAddress("smith@home", EmailAddress.Type.HOME);
        assertEquals("<HOME: smith@home>", smith.getEmail().toString());
    }
    @Test
    public void testPersonToStringWithNoEmail(){
        Person smith = new Person(new Name("John", "Smith"), MALE, LocalDate.of(1978, Month.MARCH, 15));
        assertEquals("Person{name=Smith, John, gender=MALE, birthDate=Mar 15, 1978 CE, emails=<no email address available>}", smith.toString());

    }
    @Test
    public void testPersonToStringWithOneEmail(){
        Person smith = new Person(new Name("John", "Smith"), MALE, LocalDate.of(1978, Month.MARCH, 15));
        smith.addEmailAddress("smith@home", EmailAddress.Type.HOME);
        assertEquals("Person{name=Smith, John, gender=MALE, birthDate=Mar 15, 1978 CE, emails=<HOME: smith@home>}", smith.toString());

    }
    @Test
    public void testPersonToStringWithThreeEmails(){
        Person smith = new Person(new Name("John", "Smith"), MALE, LocalDate.of(1978, Month.MARCH, 15));
        smith.addEmailAddress("smith@home", EmailAddress.Type.HOME);
        smith.addEmailAddress("smith@work", EmailAddress.Type.WORK);
        smith.addEmailAddress("smith@school", EmailAddress.Type.SCHOOL);
        assertEquals("Person{name=Smith, John, gender=MALE, birthDate=Mar 15, 1978 CE, emails=<HOME: smith@home, WORK: smith@work, SCHOOL: smith@school>}", smith.toString());

    }

}