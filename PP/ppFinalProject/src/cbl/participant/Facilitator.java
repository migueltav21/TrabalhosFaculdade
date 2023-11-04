package cbl.participant;

import cbl.participants.Contact;
import cbl.participants.Instituition;

public class Facilitator extends Participant implements cbl.participants.Facilitator{
    private String areaOfExpertise;

    public Facilitator(String name, String email, Contact contact, Instituition instituition, String areaOfExpertise) {
        super(name, email, contact, instituition);
        this.areaOfExpertise = areaOfExpertise;
    }

    @Override
    public String getAreaOfExpertise() {
        return areaOfExpertise;
    }

    @Override
    public void setAreaOfExpertise(String s) {
        this.areaOfExpertise = s;
    }
}
