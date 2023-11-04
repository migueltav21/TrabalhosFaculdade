package cbl.participant;

import cbl.participants.Contact;
import cbl.participants.Instituition;

public class Partner extends Participant implements cbl.participants.Partner{
    private String vat;
    private String website;

    public Partner(String name, String email, Contact contact, Instituition instituition, String vat, String website) {
        super(name, email, contact, instituition);
        this.vat = vat;
        this.website = website;
    }

    @Override
    public String getVat() {
        return vat;
    }

    @Override
    public String getWebsite() {
        return website;
    }
}
