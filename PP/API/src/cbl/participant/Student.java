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

public class Student extends Participant implements ma02_resources.participants.Student{
    private final int number;
    private static int numberCount = 0;

    public Student(String name, String email, Contact contact, Instituition instituition) {
        super(name, email, contact, instituition);
        this.number = numberCount++;
    }

    @Override
    public int getNumber() {
        return number;
    }

    @Override
    public String toString() {
        return "Student{" +
                "number=" + number +
                "name='" + this.getName() + '\'' +
                ", email='" + this.getEmail() + '\'' +
                ", contact=" + this.getContact() +
                ", instituition=" + this.getInstituition() +
                '}';
    }
}
