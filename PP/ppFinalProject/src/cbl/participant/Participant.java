package cbl.participant;

import cbl.participants.Contact;
import cbl.participants.Instituition;

public class Participant implements cbl.participants.Participant{
    private String name;
    private String email;
    private Contact contact;
    private Instituition instituition;

    public Participant(String name, String email, Contact contact, Instituition instituition) {
        this.name = name;
        this.email = email;
        this.contact = contact;
        this.instituition = instituition;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public String getEmail() {
        return email;
    }

    @Override
    public Contact getContact() {
        return contact;
    }

    @Override
    public Instituition getInstituition() {
        return instituition;
    }

    @Override
    public void setInstituition(Instituition instituition) {
        this.instituition = instituition;
    }

    @Override
    public void setContact(Contact contact) {
        this.contact = contact;
    }
}
