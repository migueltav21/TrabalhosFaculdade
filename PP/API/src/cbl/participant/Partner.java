/**
 * Nome: Gabriel Ferreira Moreira
 * Número: 8220225
 * Turma: 3
 * Nome: Miguel Correira Ribeiro Rangel Tavares
 * Número: 8220229
 * Turma: 3
 */
package cbl.participant;

import ma02_resources.participants.Contact;
import ma02_resources.participants.Instituition;

public class Partner extends Participant implements ma02_resources.participants.Partner {

    private final String vat;
    private final String website;

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

    @Override
    public String toString() {
        return "Partner{"
                + "vat='" + vat + '\''
                + ", website='" + website + '\''
                + "name='" + this.getName() + '\''
                + ", email='" + this.getEmail() + '\''
                + ", contact=" + this.getContact()
                + ", instituition=" + this.getInstituition()
                + '}';
    }
}
