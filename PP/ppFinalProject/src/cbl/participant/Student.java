package cbl.participant;

import cbl.participants.Contact;
import cbl.participants.Instituition;

public class Student extends Participant implements cbl.participants.Student{
    private int number;

    public Student(String name, String email, Contact contact, Instituition instituition, int number) {
        super(name, email, contact, instituition);
        this.number = number;
    }

    @Override
    public int getNumber() {
        return number;
    }
}
