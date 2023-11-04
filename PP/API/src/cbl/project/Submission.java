/**
 * Nome: Gabriel Ferreira Moreira
 * Número: 8220225
 * Turma: 3
 * Nome: Miguel Correira Ribeiro Rangel Tavares
 * Número: 8220229
 * Turma: 3
 */


package cbl.project;

import ma02_resources.participants.Student;

import java.time.LocalDateTime;

/**
 * Class Submission allow us to creat a submission and to know who submitted it, at what date and a text about it.
 */
public class Submission implements ma02_resources.project.Submission{
    private final LocalDateTime date;
    private final Student student;
    private final String text;

    public Submission(Student student, String text) {
        this.date = LocalDateTime.now();
        this.student = student;
        this.text = text;
    }

    @Override
    public LocalDateTime getDate() {
        return date;
    }

    @Override
    public Student getStudent() {
        return student;
    }

    @Override
    public String getText() {
        return text;
    }

    /**
     * This method compares the provided submission with the instance in which it is being used by the dates of both.
     * @param submission The object to be compared.
     * @return a negative value if the task end date is before, 0 if it ends at the same time, positive if it ends after
     */
    @Override
    public int compareTo(ma02_resources.project.Submission submission) {
        return this.date.compareTo(submission.getDate());
    }

    @Override
    public String toString() {
        return "Submission{" +
                "date=" + date +
                ", student=" + student +
                ", text='" + text + '\'' +
                '}';
    }
}
